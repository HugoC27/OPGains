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

@Composable
fun VisualizationFrontScreen(navController: NavController, modifier: Modifier = Modifier) {
    val frontMuscleTemplate = painterResource(R.drawable.front_template)
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            painter = frontMuscleTemplate,
            contentDescription = "front_template",
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