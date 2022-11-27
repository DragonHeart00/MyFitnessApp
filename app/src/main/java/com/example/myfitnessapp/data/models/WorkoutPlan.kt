package com.example.myfitnessapp.data.models

import java.time.DayOfWeek

data class WorkoutPlan (
    val name:String? = null,
    val workouts:ArrayList<DayOfWeek>? = null,
    val duration:Int? = null,
)
