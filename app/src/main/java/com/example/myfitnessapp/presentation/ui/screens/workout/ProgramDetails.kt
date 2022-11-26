package com.example.myfitnessapp.presentation.ui.screens.workout

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.myfitnessapp.domain.model.Program
import com.example.myfitnessapp.domain.model.getProgram

@Composable
fun ProgramDetails(navController: NavController, programId: String?) {
    val programData= getProgram().filter { programData ->programData.id==programId  }
    Scaffold() {
        BuildProfile(program = programData[0])
    }
}


@Composable
fun BuildProfile(program:Program) {

    Column() {


        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.padding(20.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {

                Surface(
                    modifier = Modifier

                        .size(80.dp), shape = CircleShape, elevation = 4.dp
                ) {

                    Image(
                        painter = rememberImagePainter(data = program.programImageId),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.fillMaxWidth()
                    )
                }



            Text(text = program.description)


        }

    }
    }
}