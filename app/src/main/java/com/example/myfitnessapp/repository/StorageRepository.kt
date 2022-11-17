package com.example.myfitnessapp.repository

import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

const val PROGRAMS_COLLECTION_REF = "programs"
class StorageRepository() {
    val user =Firebase.auth.currentUser
    fun hasUser():Boolean = Firebase.auth.currentUser != null

    fun getUserId():String = Firebase.auth.currentUser?.uid.orEmpty()

    private val programsRef:CollectionReference = Firebase
        .firestore.collection(PROGRAMS_COLLECTION_REF)

}

sealed class Resources<T>(
    val data:T? = null,
    val throwable: Throwable? = null,
){
    class Loading<T>:Resources<T>()
    class Success<T>(data: T?):Resources<T>(data = data)
    class Error<T> (throwable: Throwable?):Resources<T>(throwable = throwable )

}