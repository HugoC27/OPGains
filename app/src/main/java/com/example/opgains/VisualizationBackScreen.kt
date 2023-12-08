package com.example.opgains

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.opgains.ui.theme.OPGainsTheme

@Composable
fun VisualizationBackScreen(navController: NavController, modifier: Modifier = Modifier) {
    var scoreBackCalves = 1
    var scoreBackHamstrings = 3
    var scoreBackGlutes = 5
    var scoreBackLowerback = 2
    var scoreBackLats = 4
    var scoreBackTrapezius = 3
    var scoreBackNeck = 1
    var scoreBackShoulders = 5
    var scoreBackTricep = 1
    var scoreBackForearm = 4
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.back_template),
            contentDescription = "back_template",
        )
        Image(
            painter = painterResource(R.drawable.back_calves),
            contentDescription = "back_calves",
            colorFilter = ColorVariableChecker(muscleVariable = scoreBackCalves)
        )
        Image(
            painter = painterResource(R.drawable.back_hamstring),
            contentDescription = "back_hamstring",
            colorFilter = ColorVariableChecker(muscleVariable = scoreBackHamstrings)
        )
        Image(
            painter = painterResource(R.drawable.back_glutes),
            contentDescription = "back_glutes",
            colorFilter = ColorVariableChecker(muscleVariable = scoreBackGlutes)
        )
        Image(
            painter = painterResource(R.drawable.back_lowerback),
            contentDescription = "back_lowerback",
            colorFilter = ColorVariableChecker(muscleVariable = scoreBackLowerback)
        )
        Image(
            painter = painterResource(R.drawable.back_lats),
            contentDescription = "back_lats",
            colorFilter = ColorVariableChecker(muscleVariable = scoreBackLats)
        )
        Image(
            painter = painterResource(R.drawable.back_trapezius),
            contentDescription = "back_trapezius",
            colorFilter = ColorVariableChecker(muscleVariable = scoreBackTrapezius)
        )
        Image(
            painter = painterResource(R.drawable.back_neck),
            contentDescription = "back_neck",
            colorFilter = ColorVariableChecker(muscleVariable = scoreBackNeck)
        )
        Image(
            painter = painterResource(R.drawable.back_shoulders),
            contentDescription = "back_shoulders",
            colorFilter = ColorVariableChecker(muscleVariable = scoreBackShoulders)
        )
        Image(
            painter = painterResource(R.drawable.back_tricep),
            contentDescription = "back_triceps",
            colorFilter = ColorVariableChecker(muscleVariable = scoreBackTricep)
        )
        Image(
            painter = painterResource(R.drawable.back_forearm),
            contentDescription = "back_forearm",
            colorFilter = ColorVariableChecker(muscleVariable = scoreBackForearm)
        )
    }
    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = modifier
            .fillMaxSize()
    ){
        VisualizationBottomBar(
            navController = navController,
            visButtonColor1 = (Color(0xFF94A150)),
            visButtonColor2 = (Color(0xFF6B7534))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun VisualizationBackPreview() {
    OPGainsTheme {
        VisualizationBackScreen(
            navController = rememberNavController(),
        )
    }
}