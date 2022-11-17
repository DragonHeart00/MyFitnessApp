package com.example.myfitnessapp.repository

import com.example.myfitnessapp.models.Programs
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import java.lang.Exception

const val PROGRAMS_COLLECTION_REF = "programs"
class StorageRepository() {
    val user =Firebase.auth.currentUser
    fun hasUser():Boolean = Firebase.auth.currentUser != null

    fun getUserId():String = Firebase.auth.currentUser?.uid.orEmpty()

    private val programsRef:CollectionReference = Firebase
        .firestore.collection(PROGRAMS_COLLECTION_REF)

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getUserPrograms(
        userId:String
    ): Flow<Resources<List<Programs>>> = callbackFlow {

        var snapshotStateListener:ListenerRegistration? = null

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

}

sealed class Resources<T>(
    val data:T? = null,
    val throwable: Throwable? = null,
){
    class Loading<T>:Resources<T>()
    class Success<T>(data: T?):Resources<T>(data = data)
    class Error<T> (throwable: Throwable?):Resources<T>(throwable = throwable )

}