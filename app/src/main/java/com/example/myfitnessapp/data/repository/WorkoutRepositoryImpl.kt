package com.example.myfitnessapp.data.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.myfitnessapp.domain.models.*
import com.example.myfitnessapp.domain.repository.WorkoutRepository
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.example.myfitnessapp.util.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class WorkoutRepositoryImpl @Inject constructor(
    private val app: Application,
    ) : WorkoutRepository {



    private var workoutPlanId: String? = null

    private val userCollection = Firebase.firestore.collection("users")


    override suspend fun deleteWorkoutPlan(workoutPlanId: String,uid:String) {
        withContext(Dispatchers.IO) {
            try {

                userCollection.document(uid).collection("workout_plan")
                    .document(workoutPlanId).delete()
                userCollection.document(uid).collection("workout_plan")
                    .document(workoutPlanId).collection("workouts").get()
                    .addOnCompleteListener {
                        val docs = it.result.documents

                        docs.forEach { doc ->
                            userCollection.document(uid).collection("workout_plan")
                                .document(workoutPlanId)
                                .collection("workouts").document(doc.id).delete()
                            userCollection.document(uid).collection("workout_plan")
                                .document(workoutPlanId)
                                .collection("workouts").document(doc.id).collection("exercises")
                                .get()
                                .addOnCompleteListener {
                                    val exercises = it.result.documents
                                    exercises.forEach { e ->
                                        userCollection.document(uid).collection("workout_plan")
                                            .document(workoutPlanId)
                                            .collection("workouts").document(doc.id)
                                            .collection("exercises").document(e.id).delete()
                                    }

                                }
                        }
                    }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override suspend fun addWorkoutPlan(
        workoutPlan: WorkoutPlan,
        workouts: ArrayList<Workout>,
        uid:String
    ): Response<Void> {

        return withContext(Dispatchers.IO) {

            try {
                val result =

                    // create workout_plan document
                    userCollection.document(uid).collection("workout_plan")
                        .document(workoutPlan.name.toString()).set(workoutPlan).await()

                // add workouts collection to workout_plan
                workouts.forEach {
                    userCollection.document(uid).collection("workout_plan")
                        .document(workoutPlan.name.toString())
                        .collection("workouts").document(it.dayOfWeek.toString()).set(it)
                        .await()
                }


                Response.Success(result)
            } catch (e: Exception) {
                e.printStackTrace()
                Response.Error(e.message.toString())
            }

        }
    }

    override suspend fun getWorkoutPlan(uid:String): Response<QuerySnapshot> {
        return withContext(Dispatchers.IO) {

            try {
                val result = userCollection.document(uid).collection("workout_plan")
                    .get().await()

                workoutPlanId = result?.documents?.firstOrNull()?.id

                Response.Success(result)
            } catch (e: Exception) {
                e.printStackTrace()
                Response.Error(e.message.toString())

            }

        }
    }





    override suspend fun getUser(uid:String): Response<DocumentSnapshot> {

        return withContext(Dispatchers.IO) {
            try {

                val result = userCollection.document(uid).get().await()

                Response.Success(result)

            } catch (e: Exception) {
                e.printStackTrace()
                Response.Error(e.message!!)
            }
        }

    }


    /**
     * Inside the body of get , call withContext(Dispatchers.IO) to create a block that runs on the IO thread pool.
     * Any code you put inside that block always executes via the IO dispatcher.
     * Since withContext is itself a suspend function,
     * the function get is also a suspend function.
     */
    override suspend fun addNewExercise(exercise: Exercise, uid:String): Response<Void> {
        return withContext(Dispatchers.IO) {
            try {

                val result =
                        userCollection.document(uid).collection("exercises")
                            .document(exercise.name.toString()).set(exercise).await()

                Response.Success(result)

            } catch (e: Exception) {
                e.printStackTrace()
                Response.Error(e.message.toString())
            }
        }
    }




    override suspend fun getExercises(uid:String): MutableLiveData<Response<QuerySnapshot>> {

        val data = MutableLiveData<Response<QuerySnapshot>>()

            userCollection.document(uid).collection("exercises")
                .addSnapshotListener { snapshot, error ->

                    snapshot?.let {
                        data.value = Response.Success(it)

                    }

                    error?.let {
                        data.value = Response.Error(it.message.toString())
                        Log.e("Error", data.value?.message.toString())
                        return@addSnapshotListener
                    }

        }


        return data
    }


}