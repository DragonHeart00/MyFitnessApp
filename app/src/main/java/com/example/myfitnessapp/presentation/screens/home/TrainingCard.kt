package com.example.myfitnessapp.presentation.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.myfitnessapp.domain.models.WorkoutPlan
import com.example.myfitnessapp.ui.theme.veryDarkBlue
import com.example.myfitnessapp.R

@Composable
fun TrainingCard(
    modifier: Modifier,
    workoutPlan: WorkoutPlan,
    onClick: () -> Unit
) {


    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(235.dp)
            .clip(RoundedCornerShape(40.dp))
            .shadow(4.dp),

        ) {
        Surface(
            color = veryDarkBlue.copy(0.5f),
            modifier = Modifier
                .fillMaxSize()
                .clickable { onClick() }
                .paint(
                    painter = painterResource(id = R.drawable.stockimagebarbell),
                    contentScale = ContentScale.Crop
                ),

            ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Bottom)
            ) {

                Heading(text = workoutPlan.name.toString(), modifier = Modifier)

                WorkoutInfo(
                    modifier = Modifier
                        .paddingFromBaseline(bottom = 20.dp),
                    duration = workoutPlan.duration.toString(),
//                    difficulty = workoutPlan.difficulty!!,

                    )

            }

        }

    }
}

@Composable
fun WorkoutInfo(
    modifier: Modifier = Modifier,
    duration: String,
    //difficulty: DifficultyLevels.Difficulty
) {

//    Row(
//        modifier = modifier
//            .fillMaxWidth(),
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.spacedBy(10.dp)
//    ) {
//
//        Icon(
//            painter = painterResource(id = R.drawable.ic_timer),
//            contentDescription = null,
//            tint = myWhite
//        )
//
//        Text(
//            text = "$duration min",
//            color = myWhite,
//            textAlign = TextAlign.End,
//            modifier = Modifier
//                .align(Alignment.Bottom)
//        )
//        Spacer(modifier = Modifier.width(10.dp))
//        Icon(
//            painter = painterResource(id = difficulty.icon!!),
//            contentDescription = null,
//            tint = myWhite,
//            modifier = Modifier
//                .width(20.dp)
//                .height(20.dp)
//        )
//
//        Text(
//            text = stringResource(id = difficulty.difficulty!!),
//            color = myWhite,
//            textAlign = TextAlign.End,
//            modifier = Modifier
//                .align(Alignment.Bottom)
//        )
//    }
}

@Preview
@Composable
fun RestDayView(modifier: Modifier = Modifier) {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.panda_animation))


    Surface(color = Color.Transparent, modifier = modifier) {

        Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.Start) {
            Heading(text = stringResource(R.string.no_sessions_text))

            LottieAnimation(
                composition = composition,
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
                ,
                iterations = Int.MAX_VALUE
            )

            Title(
                text = stringResource(R.string.rest_view_text)

                )

        }


    }

}



