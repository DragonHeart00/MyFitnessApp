package com.example.myfitnessapp.domain.repository

import androidx.lifecycle.MutableLiveData
import com.example.myfitnessapp.domain.models.*
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import com.example.myfitnessapp.util.Response

interface WorkoutRepository {

    //suspend pauses the execution of the current coroutine, saving all local variables.
    suspend fun addWorkoutPlan(workoutPlan: WorkoutPlan, workouts: ArrayList<Workout>, uid:String): Response<Void>

    suspend fun getWorkoutPlan(uid:String): Response<QuerySnapshot>

    suspend fun getExercises(uid:String):MutableLiveData<Response<QuerySnapshot>>

    suspend fun getUser(uid:String): Response<DocumentSnapshot>

    suspend fun addNewExercise(exercise: Exercise, uid:String): Response<Void>

    suspend fun deleteWorkoutPlan(workoutPlanId: String,uid:String)




}