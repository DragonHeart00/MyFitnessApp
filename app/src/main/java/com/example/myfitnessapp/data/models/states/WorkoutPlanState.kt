package com.example.myfitnessapp.data.models.states

import com.example.myfitnessapp.data.models.WorkoutPlan

data class WorkoutPlanState(
    val workoutPlan: WorkoutPlan? = null,
    val loading:Boolean = false,
    val error:String? = null
)
