package com.example.myfitnessapp.domain.repository

import com.google.firebase.auth.AuthResult
import com.example.myfitnessapp.util.Resource

interface UserRepository {

    suspend fun createNewUser(
        userName: String,
        userEmailAddress: String,
        userLoginPassword: String
    ): Resource<AuthResult>

    fun hasUser(): Boolean
    suspend fun loginUser(email: String, password: String): Resource<AuthResult>

    suspend fun logOutUser()
}