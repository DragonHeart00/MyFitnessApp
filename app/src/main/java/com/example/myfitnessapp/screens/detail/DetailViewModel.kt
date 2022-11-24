package com.example.myfitnessapp.screens.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.myfitnessapp.models.Programs
import com.example.myfitnessapp.repository.StorageRepository
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseUser

class DetailViewModel (
    private val repository: StorageRepository
        ):ViewModel(){

    var detailUiState by mutableStateOf(DetailUiState())


    fun onTitleChange(title: String){
        detailUiState = detailUiState.copy(title = title)
    }

    fun onProgramChange(program: String){
        detailUiState = detailUiState.copy(program = program)
    }

    private val hasUser:Boolean
    get() = repository.hasUser()

    private val user:FirebaseUser?
    get() = repository.user

    fun addProgram(){
        if (hasUser){
            repository.addPrograms(
                userId = user!!.uid,
                title = detailUiState.title,
                description = detailUiState.program,
                timestamp = Timestamp.now()
            ){
                detailUiState= detailUiState.copy(programAddedStatus = it)
            }
        }
    }

}


data class DetailUiState(
    val title:String="",
    val program:String="",
    val programAddedStatus:Boolean = false,
    val updateProgramStatus:Boolean = false,
    val selectedProgram:Programs? = null
)