package com.example.myfitnessapp.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myfitnessapp.repository.AuthRepository

class HomeViewModal(
    private val repository: AuthRepository = AuthRepository()
): ViewModel() {
    fun signOut() = repository.signOut()
}