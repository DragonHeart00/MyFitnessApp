package com.example.myfitnessapp.models

import com.google.firebase.Timestamp

data class Programs(
    val userId:String = "",
    val title:String="",
    val description:String = "",
    val timestamp: Timestamp = Timestamp.now(),
    val documentId: String = "",
)