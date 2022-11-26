package com.example.myfitnessapp.domain.model

import com.example.myfitnessapp.R

data class Program(
    val id: String,
    val title: String,
    val exerciseNumber: Int,
    val description: String,
    val programImageId: Int = 0
)


fun getProgram(): List<Program> {
    return listOf(
        Program(
            id = "1",
            title = "Lose weight",
            exerciseNumber = 4,
            description = "Monty enjoys chicken treats and cuddling while watching Seinfeld.",
            programImageId = R.drawable.p1
        ),
        Program(
            id = "2",
            title = "Improve my Conditioning",
            exerciseNumber = 4,
            description = "Monty enjoys chicken treats and cuddling while watching Seinfeld.",
            programImageId = R.drawable.p2
        ),
        Program(
            id = "3",
            title = "Be Stronger",
            exerciseNumber = 8,
            description = "Beezy's favorite past-time is helping you choose your brand color.",
            programImageId = R.drawable.p3
        ),
        Program(
            id = "4",
            title = "Bigger Muscles",
            exerciseNumber = 8,
            description = "Beezy's favorite past-time is helping you choose your brand color.",
            programImageId = R.drawable.p4
        ),

        );
}