package com.example.myfitnessapp.screens.programCreation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProgramCreationView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {

        ProgramNameField()

    }
}


@Composable
fun ProgramNameFields() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = text,
        label = { Text(text = "Enter Program Name ..") },
        onValueChange = {
            text = it
        }
    )

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

