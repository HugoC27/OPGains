package com.example.opgains

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.opgains.ui.theme.OPGainsTheme

@Composable
fun VisualizationBackScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    scoreCalves: Int,
    scoreThigh: Int,
    scoreHipAbductor: Int,
    scoreAbs: Int,
    scoreOblique: Int,
    scoreLats: Int,
    scoreChest: Int,
    scoreTraps: Int,
    scoreNeck: Int,
    scoreShoulders: Int,
    scoreTriceps: Int,
    scoreBiceps: Int,
    scoreForearms: Int,
    scoreHamstrings: Int,
    scoreGlutes: Int,
    scoreLowerBack: Int
) {
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
            colorFilter = ColorVariableChecker(muscleVariable = scoreCalves)
        )
        Image(
            painter = painterResource(R.drawable.back_hamstring),
            contentDescription = "back_hamstring",
            colorFilter = ColorVariableChecker(muscleVariable = scoreHamstrings)
        )
        Image(
            painter = painterResource(R.drawable.back_glutes),
            contentDescription = "back_glutes",
            colorFilter = ColorVariableChecker(muscleVariable = scoreGlutes)
        )
        Image(
            painter = painterResource(R.drawable.back_lowerback),
            contentDescription = "back_lowerback",
            colorFilter = ColorVariableChecker(muscleVariable = scoreLowerBack)
        )
        Image(
            painter = painterResource(R.drawable.back_lats),
            contentDescription = "back_lats",
            colorFilter = ColorVariableChecker(muscleVariable = scoreLats)
        )
        Image(
            painter = painterResource(R.drawable.back_trapezius),
            contentDescription = "back_trapezius",
            colorFilter = ColorVariableChecker(muscleVariable = scoreTraps)
        )
        Image(
            painter = painterResource(R.drawable.back_neck),
            contentDescription = "back_neck",
            colorFilter = ColorVariableChecker(muscleVariable = scoreNeck)
        )
        Image(
            painter = painterResource(R.drawable.back_shoulders),
            contentDescription = "back_shoulders",
            colorFilter = ColorVariableChecker(muscleVariable = scoreShoulders)
        )
        Image(
            painter = painterResource(R.drawable.back_tricep),
            contentDescription = "back_triceps",
            colorFilter = ColorVariableChecker(muscleVariable = scoreTriceps)
        )
        Image(
            painter = painterResource(R.drawable.back_forearm),
            contentDescription = "back_forearm",
            colorFilter = ColorVariableChecker(muscleVariable = scoreForearms)
        )
    }
    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = modifier
            .fillMaxSize()
    ) {
        VisualizationBottomBar(
            navController = navController,
            visButtonColor1 = (Color(0xFF94A150)),
            visButtonColor2 = (Color(0xFF6B7534)),
            visButtonEnabled1 = true,
            visButtonEnabled2 = false,
            scoreCalves = scoreCalves,
            scoreThigh = scoreThigh,
            scoreHipAbductor = scoreHipAbductor,
            scoreAbs = scoreAbs,
            scoreOblique = scoreOblique,
            scoreLats = scoreLats,
            scoreChest = scoreChest,
            scoreTraps = scoreTraps,
            scoreNeck = scoreNeck,
            scoreShoulders = scoreShoulders,
            scoreTriceps = scoreTriceps,
            scoreBiceps = scoreBiceps,
            scoreForearms = scoreForearms,
            scoreHamstrings = scoreHamstrings,
            scoreGlutes = scoreGlutes,
            scoreLowerBack = scoreLowerBack
        )
    }
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = modifier
            .fillMaxSize()
    ) {
        VisualizationTopBar(navController = navController)
    }
}

@Composable
fun VisualizationTopBar(navController: NavController, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(Color(0xFF4B5320))
            .fillMaxWidth()
            .height(54.dp)
    ) {
        Spacer(Modifier.width(20.dp))
        Button(
            onClick = { navController.navigate(route = Screen.Tracker.route) },
            colors = ButtonDefaults.buttonColors(Color(0xFF94A150)),
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "home_icon"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VisualizationBackPreview() {
    OPGainsTheme {
        VisualizationBackScreen(
            navController = rememberNavController(),
            scoreCalves = 2,
            scoreThigh = 1,
            scoreHipAbductor = 0,
            scoreAbs = 3,
            scoreOblique = 3,
            scoreLats = 1,
            scoreChest = 5,
            scoreTraps = 0,
            scoreNeck = 3,
            scoreShoulders = 1,
            scoreTriceps = 3,
            scoreBiceps = 1,
            scoreForearms = 4,
            scoreHamstrings = 5,
            scoreGlutes = 0,
            scoreLowerBack = 4
        )
    }
}