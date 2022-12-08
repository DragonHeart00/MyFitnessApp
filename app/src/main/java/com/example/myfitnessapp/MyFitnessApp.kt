package com.example.myfitnessapp

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.HiltAndroidApp

/**
 * generate top level component: generates a base class for your application that uses those generated components
 * Because the code generation needs access to all of your modules
 */

@HiltAndroidApp
class MyFitnessApp : Application(){

    // should be saved in data store
    val isDarkTheme = mutableStateOf(false)

    fun toggleTheme() {
        isDarkTheme.value = !isDarkTheme.value
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var context: Context? = null
        fun getContext(): Context {
            return context!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}