package com.example.myfitnessapp.domain

import com.google.firebase.auth.AuthResult
import com.example.myfitnessapp.domain.util.Resource

interface UserRepository {

    suspend fun createNewUser(
        userName: String,
        userEmailAddress: String,
        userLoginPassword: String
    ): Resource<AuthResult>


    suspend fun loginUser(email: String, password: String): Resource<AuthResult>

    suspend fun logOutUser()
}