package com.example.myfitnessapp.screens.programCreation

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun ProgramCreationView(

) {


    ProgramNameField()

}





@Composable
fun ProgramNameField() {

    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,

    ) {

        val programName = remember { mutableStateOf(TextFieldValue()) }
        val numberOfExercise = remember { mutableStateOf(TextFieldValue()) }

        Text(text = "Create A Program", style = TextStyle(fontSize = 36.sp))

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = { Text(text = "Program name") },
            value = programName.value,
            onValueChange = { programName.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = { Text(text = "Number of exercise") },
            value = numberOfExercise.value,
            //visualTransformation = PasswordVisualTransformation(),
            //keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { numberOfExercise.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {

        }

    }
    Box(Modifier.fillMaxSize().padding(0.dp,0.dp,25.dp,100.dp)) {
        Button(
            modifier = Modifier.align(Alignment.BottomEnd),
            onClick = {}
        ) {
            Text("Next")
        }
    }
}

