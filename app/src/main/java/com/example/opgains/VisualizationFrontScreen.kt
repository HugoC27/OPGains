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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.opgains.ui.theme.OPGainsTheme
import androidx.compose.ui.graphics.ColorFilter

@Composable
fun VisualizationFrontScreen(
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
            painter = painterResource(R.drawable.front_template2),
            contentDescription = "front_template",
        )
        Image(
            painter = painterResource(R.drawable.front_calf),
            contentDescription = "front_calf",
            colorFilter = ColorVariableChecker(muscleVariable = scoreCalves)
        )
        Image(
            painter = painterResource(R.drawable.front_thigh),
            contentDescription = "front_thigh",
            colorFilter = ColorVariableChecker(muscleVariable = scoreThigh)
        )
        Image(
            painter = painterResource(R.drawable.front_hip_abductor),
            contentDescription = "front_hip_abductor",
            colorFilter = ColorVariableChecker(muscleVariable = scoreHipAbductor)
        )
        Image(
            painter = painterResource(R.drawable.front_abs),
            contentDescription = "front_abs",
            colorFilter = ColorVariableChecker(muscleVariable = scoreAbs)
        )
        Image(
            painter = painterResource(R.drawable.front_obliques),
            contentDescription = "front_oblique",
            colorFilter = ColorVariableChecker(muscleVariable = scoreOblique)
        )
        Image(
            painter = painterResource(R.drawable.front_lats),
            contentDescription = "front_lats",
            colorFilter = ColorVariableChecker(muscleVariable = scoreLats)
        )
        Image(
            painter = painterResource(R.drawable.front_chest),
            contentDescription = "front_chest",
            colorFilter = ColorVariableChecker(muscleVariable = scoreChest)
        )
        Image(
            painter = painterResource(R.drawable.front_traps),
            contentDescription = "front_lats",
            colorFilter = ColorVariableChecker(muscleVariable = scoreTraps)
        )
        Image(
            painter = painterResource(R.drawable.front_neck),
            contentDescription = "front_neck",
            colorFilter = ColorVariableChecker(muscleVariable = scoreNeck)
        )
        Image(
            painter = painterResource(R.drawable.front_shoulders),
            contentDescription = "front_shoulder",
            colorFilter = ColorVariableChecker(muscleVariable = scoreShoulders)
        )
        Image(
            painter = painterResource(R.drawable.front_tricep),
            contentDescription = "front_tricep",
            colorFilter = ColorVariableChecker(muscleVariable = scoreTriceps)
        )
        Image(
            painter = painterResource(R.drawable.front_bicep),
            contentDescription = "front_biceps",
            colorFilter = ColorVariableChecker(muscleVariable = scoreBiceps)
        )
        Image(
            painter = painterResource(R.drawable.front_forearms),
            contentDescription = "front_forearms",
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
            visButtonColor1 = (Color(0xFF6B7534)),
            visButtonColor2 = (Color(0xFF94A150)),
            visButtonEnabled1 = false,
            visButtonEnabled2 = true,
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
fun ColorVariableChecker(muscleVariable: Int): ColorFilter? {
    val color: Color? = when (muscleVariable) {
        5 -> Color(0xFFFF3B3B)
        4 -> Color(0xFFFF5353)
        3 -> Color(0xFFFF6969)
        2 -> Color(0xFFFF7E7E)
        1 -> Color(0xFFFF9696)
        else -> null
    }
    return color?.let { ColorFilter.tint(it) }
}

@Composable
fun VisualizationBottomBar(
    visButtonColor1: Color, visButtonColor2: Color,
    visButtonEnabled1: Boolean, visButtonEnabled2: Boolean,
    navController: NavController, modifier: Modifier = Modifier,
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
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(Color(0xFF4B5320))
            .fillMaxWidth()
            .height(64.dp)
    ) {
        Button(
            onClick = {
                navController.navigate(
                    route = Screen.VisualizationFront.passAllScores(
                        calves = scoreCalves,
                        thigh = scoreThigh,
                        hip_abductor = scoreHipAbductor,
                        abs = scoreAbs,
                        oblique = scoreOblique,
                        lats = scoreLats,
                        chest = scoreChest,
                        traps = scoreTraps,
                        neck = scoreNeck,
                        shoulder = scoreShoulders,
                        triceps = scoreTriceps,
                        biceps = scoreBiceps,
                        forearms = scoreForearms,
                        hamstrings = scoreHamstrings,
                        glutes = scoreGlutes,
                        lowerback = scoreLowerBack
                    )
                )
            },
            colors = ButtonDefaults.buttonColors(visButtonColor1),
            enabled = visButtonEnabled1
        ) {
            Spacer(Modifier.width(10.dp))
            BottomButtonText(
                buttonTextStr = "Front"
            )
            Spacer(Modifier.width(10.dp))
        }
        Button(
            onClick = {
                navController.navigate(
                    route = Screen.VisualizationBack.passAllScores(
                        calves = scoreCalves,
                        thigh = scoreThigh,
                        hip_abductor = scoreHipAbductor,
                        abs = scoreAbs,
                        oblique = scoreOblique,
                        lats = scoreLats,
                        chest = scoreChest,
                        traps = scoreTraps,
                        neck = scoreNeck,
                        shoulder = scoreShoulders,
                        triceps = scoreTriceps,
                        biceps = scoreBiceps,
                        forearms = scoreForearms,
                        hamstrings = scoreHamstrings,
                        glutes = scoreGlutes,
                        lowerback = scoreLowerBack
                    )
                )
            },
            colors = ButtonDefaults.buttonColors(visButtonColor2),
            enabled = visButtonEnabled2
        ) {
            Spacer(Modifier.width(10.dp))
            BottomButtonText(
                buttonTextStr = "Back"
            )
            Spacer(Modifier.width(10.dp))
        }
    }
}

@Composable
fun BottomButtonText(
    buttonTextStr: String,
    fontSize: TextUnit = 16.sp,
    modifier: Modifier = Modifier
) {
    Text(
        text = buttonTextStr,
        textAlign = TextAlign.Center,
        fontSize = fontSize,
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun VisualizationFrontPreview() {
    OPGainsTheme {
        VisualizationFrontScreen(
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