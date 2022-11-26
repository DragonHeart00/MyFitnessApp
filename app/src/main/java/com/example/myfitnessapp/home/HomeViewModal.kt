package com.example.myfitnessapp.home

import androidx.lifecycle.ViewModel
import com.example.myfitnessapp.login.repository.AuthRepository

class HomeViewModal(
    private val repository: AuthRepository = AuthRepository()
): ViewModel() {
    fun signOut() = repository.signOut()
}