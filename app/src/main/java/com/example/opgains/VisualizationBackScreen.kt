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
    val backMuscleTemplate = painterResource(R.drawable.back_template)
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            painter = backMuscleTemplate,
            contentDescription = "back_template",
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