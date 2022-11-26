package com.example.myfitnessapp.recipes.presentation.ui.screens.home

import androidx.lifecycle.ViewModel
import com.example.myfitnessapp.recipes.repository.AuthRepository

class HomeViewModal(
    private val repository: AuthRepository = AuthRepository()
): ViewModel() {
    fun signOut() = repository.signOut()
}