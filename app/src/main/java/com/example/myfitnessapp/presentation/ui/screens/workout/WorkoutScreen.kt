package com.example.myfitnessapp.presentation.ui.screens.workout

//@Composable
//fun WorkoutScreen(navigateToProgram: (Program) -> Unit) {
//    val programs = remember { DataProvider.programList }
//    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp )
//    ){
//        items(
//            items = programs,
//            itemContent = {
//                ProgramListItem(program = it, navigateToProgram)
//            }
//        )
//    }
//}
//
//
//@Composable
//fun ProgramListItem(program: Program, navigateToProgram: (Program) -> Unit){
//    Card(
//        modifier = Modifier
//            .padding(horizontal = 8.dp, vertical = 8.dp)
//            .fillMaxSize(),
//        elevation = 2.dp,
//        shape = RoundedCornerShape(corner = CornerSize(16.dp))
//    ) {
//        Row(
//            Modifier.clickable{navigateToProgram(program)}
//        ){
//            ProgramImage(program = program)
//            Column(
//                modifier = Modifier
//                    .padding(16.dp)
//                    .fillMaxSize()
//                    .align(Alignment.CenterVertically)
//            ) {
//                Text(text = program.title, style = MaterialTheme.typography.h6)
//                Text(text = "View Detail", style = MaterialTheme.typography.caption)
//            }
//        }
//    }
//
//}
//
//@Composable
//private fun ProgramImage(program: Program){
//    Image(
//        painter = painterResource(id = program.programImageId),
//        contentDescription = null,
//        contentScale = ContentScale.Crop,
//        modifier = Modifier
//            .padding(8.dp)
//            .size(84.dp)
//            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
//    )
//}