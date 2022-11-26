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

    }
    Scaffold(topBar = {
        TopAppBar(
            elevation = 3.dp,
            backgroundColor = Color.White
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Icon",
                    tint = Color.Black,
                    modifier = Modifier.clickable { navController.popBackStack() }

                )
                Spacer(modifier = Modifier.width(30.dp))
                Text(text = programData[0].title,
                    fontWeight = FontWeight.Bold,
                    )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Icon",
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.width(10.dp))
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Icon",
                    tint = Color.Black
                )

            }

        }
    }) {
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