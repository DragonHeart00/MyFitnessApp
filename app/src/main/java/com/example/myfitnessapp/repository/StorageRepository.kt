package com.example.myfitnessapp.repository

import com.example.myfitnessapp.models.Programs
import com.google.firebase.Timestamp
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

const val PROGRAMS_COLLECTION_REF = "programs"

class StorageRepository(){
    val user = Firebase.auth.currentUser
    fun hasUser():Boolean = Firebase.auth.currentUser != null

    fun getUserId():String = Firebase.auth.currentUser?.uid.orEmpty()

    private val programsRef:CollectionReference = Firebase
        .firestore.collection(PROGRAMS_COLLECTION_REF)

    //fetch data from database
    @OptIn(ExperimentalCoroutinesApi::class)
    fun getUserPrograms(
        userId:String
    ):Flow<Resources<List<Programs>>> = callbackFlow {
        var snapshotStateListener: ListenerRegistration? = null
        try {
            snapshotStateListener = programsRef
                .orderBy("timestamp")
                .whereEqualTo("userId",userId)
                .addSnapshotListener{snapshot, e ->
                    val response = if (snapshot != null){
                        val programs = snapshot.toObjects(Programs::class.java)
                        Resources.Success(data = programs)
                    }else{
                        Resources.Error(throwable = e?.cause)
                    }
                    trySend(response)
                }
        }catch (e:Exception){
            trySend(Resources.Error(e?.cause))
            e.printStackTrace()
        }
        awaitClose{
            snapshotStateListener?.remove()
        }

    }

    fun getProgram(
        programId:String,
        onError:(Throwable?) -> Unit,
        onSuccess: (Programs?) -> Unit
    ){
        programsRef
            .document(programId)
            .get()
            .addOnSuccessListener {
                onSuccess.invoke(it?.toObject(Programs::class.java))
            }
            .addOnFailureListener{ result ->
                onError.invoke(result.cause)

            }
    }

    fun addPrograms(
        userId:String,
        title:String,
        description:String,
        timestamp: Timestamp,
        onComplete: (Boolean) -> Unit,
    ){
        val documentId = programsRef.document().id
        val program = Programs(userId,title,description,timestamp,documentId= documentId)
        programsRef
            .document(documentId)
            .set(program)
            .addOnCompleteListener{ result ->
                onComplete.invoke(result.isSuccessful)
            }
    }

    fun deleteProgram(programId: String, onComplete:(Boolean) -> Unit){
        programsRef.document(programId)
            .delete()
            .addOnCompleteListener{
                onComplete.invoke(it.isSuccessful)
            }
    }

    fun updateProgram(
        title: String,
        program:String,
        programId:String,
        onResult:(Boolean)-> Unit,
    ){
        val updateData = hashMapOf<String,Any>(
            "description" to program,
            "title" to title
        )
        programsRef.document(programId)
            .update(updateData)
            .addOnCompleteListener{
                onResult.invoke(it.isSuccessful)
            }
    }

}

sealed class Resources<T>(
    val data:T?= null,
    val throwable: Throwable? = null,
){
    class Loading<T>:Resources<T>()
    class Success<T>(data: T?):Resources<T>(data = data)
    class Error<T>(throwable: Throwable?):Resources<T>(throwable = throwable)

}
