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
fun VisualizationFrontScreen(navController: NavController, modifier: Modifier = Modifier) {
    var scoreFrontCalf = 2
    var scoreFrontThigh = 4
    var scoreFrontHipAbductor = 1
    var scoreFrontAbs = 4
    var scoreFrontOblique = 5
    var scoreFrontLats = 4
    var scoreFrontChest = 3
    var scoreFrontTraps = 2
    var scoreFrontNeck = 1
    var scoreFrontShoulder = 5
    var scoreFrontTriceps = 2
    var scoreFrontBiceps = 4
    var scoreFrontForearms = 3
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
            colorFilter = ColorVariableChecker(muscleVariable = scoreFrontCalf)
        )
        Image(
            painter = painterResource(R.drawable.front_thigh),
            contentDescription = "front_thigh",
            colorFilter = ColorVariableChecker(muscleVariable = scoreFrontThigh)
        )
        Image(
            painter = painterResource(R.drawable.front_hip_abductor),
            contentDescription = "front_hip_abductor",
            colorFilter = ColorVariableChecker(muscleVariable = scoreFrontHipAbductor)
        )
        Image(
            painter = painterResource(R.drawable.front_abs),
            contentDescription = "front_abs",
            colorFilter = ColorVariableChecker(muscleVariable = scoreFrontAbs)
        )
        Image(
            painter = painterResource(R.drawable.front_obliques),
            contentDescription = "front_oblique",
            colorFilter = ColorVariableChecker(muscleVariable = scoreFrontOblique)
        )
        Image(
            painter = painterResource(R.drawable.front_lats),
            contentDescription = "front_lats",
            colorFilter = ColorVariableChecker(muscleVariable = scoreFrontLats)
        )
        Image(
            painter = painterResource(R.drawable.front_chest),
            contentDescription = "front_chest",
            colorFilter = ColorVariableChecker(muscleVariable = scoreFrontChest)
        )
        Image(
            painter = painterResource(R.drawable.front_traps),
            contentDescription = "front_lats",
            colorFilter = ColorVariableChecker(muscleVariable = scoreFrontTraps)
        )
        Image(
            painter = painterResource(R.drawable.front_neck),
            contentDescription = "front_neck",
            colorFilter = ColorVariableChecker(muscleVariable = scoreFrontNeck)
        )
        Image(
            painter = painterResource(R.drawable.front_shoulders),
            contentDescription = "front_shoulder",
            colorFilter = ColorVariableChecker(muscleVariable = scoreFrontShoulder)
        )
        Image(
            painter = painterResource(R.drawable.front_tricep),
            contentDescription = "front_tricep",
            colorFilter = ColorVariableChecker(muscleVariable = scoreFrontTriceps)
        )
        Image(
            painter = painterResource(R.drawable.front_bicep),
            contentDescription = "front_biceps",
            colorFilter = ColorVariableChecker(muscleVariable = scoreFrontBiceps)
        )
        Image(
            painter = painterResource(R.drawable.front_forearms),
            contentDescription = "front_forearms",
            colorFilter = ColorVariableChecker(muscleVariable = scoreFrontForearms)
        )
    }
    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = modifier
            .fillMaxSize()
    ){
        VisualizationBottomBar(
            navController = navController,
            visButtonColor1 = (Color(0xFF6B7534)),
            visButtonColor2 = (Color(0xFF94A150))
        )
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
fun VisualizationBottomBar(visButtonColor1: Color, visButtonColor2: Color,
                           navController: NavController, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(Color(0xFF4B5320))
            .fillMaxWidth()
            .height(64.dp)
    ) {
        Button(onClick = { navController.navigate(route = Screen.VisualizationFront.route) },
            colors = ButtonDefaults.buttonColors(visButtonColor1)){
            Spacer(Modifier.width(10.dp))
            BottomButtonText(
                buttonTextStr = "Front"
            )
            Spacer(Modifier.width(10.dp))
        }
        Button(onClick = { navController.navigate(route = Screen.VisualizationBack.route) },
            colors = ButtonDefaults.buttonColors(visButtonColor2)){
            Spacer(Modifier.width(10.dp))
            BottomButtonText(
                buttonTextStr = "Back"
            )
            Spacer(Modifier.width(10.dp))
        }
    }
}

@Composable
fun BottomButtonText(buttonTextStr: String, fontSize: TextUnit = 16.sp, modifier: Modifier = Modifier) {
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
        )
    }
}