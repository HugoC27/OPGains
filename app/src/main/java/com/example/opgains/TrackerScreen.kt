package com.example.opgains

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
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.opgains.ui.theme.OPGainsTheme

@Composable
fun TrackerScreen(navController: NavController, modifier: Modifier = Modifier, trackerButtonText: String) {


    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = modifier
            .fillMaxSize()
    ) {
        TrackerBottomBar(
            navController = navController,
            icon1 = Icons.Filled.Settings,
            icon3 = Icons.Filled.Close,
            barButtonColor1 = (Color(0xFF94A150)),
            barButtonColor2 = (Color(0xFF6B7534)),
            barButtonColor3 = (Color(0xFF94A150))
        )
    }
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = modifier
            .fillMaxSize()
    ) {
        TrackerTopBar(
            navController = navController,
            modifier = modifier,
            trackerButtonText2 = trackerButtonText
        )
    }
}

@Composable
fun TrackerTopBar( navController: NavController, modifier: Modifier = Modifier, trackerButtonText2: String ) {
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
            onClick = { navController.navigate(route = Screen.Home.route) },
            colors = ButtonDefaults.buttonColors(Color(0xFF94A150)),
        ) {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "home_icon"
            )
        }
    }
    Row(
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(54.dp)
    ) {

        Button(
            onClick = { navController.navigate(route = Screen.VisualizationFront.route) },
            colors = ButtonDefaults.buttonColors(Color(0xFF94A150)),
        ) {
            TrackerButtonText(
                buttonTextStr = trackerButtonText2,
            ) }
        Spacer(Modifier.width(20.dp))
    }
}

@Composable
fun TrackerButtonText(buttonTextStr: String, modifier: Modifier = Modifier) {
    Text(
        text = buttonTextStr,
        textAlign = TextAlign.Center,
        fontSize = 15.sp,
        color = Color.White,
        modifier = modifier
    )
}

@Composable
fun TrackerBottomBar(barButtonColor1: Color, barButtonColor2: Color, barButtonColor3: Color,
                     icon1: ImageVector, icon3: ImageVector,
                     navController: NavController, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(Color(0xFF4B5320))
            .fillMaxWidth()
            .height(64.dp)
    ) {
        Button(
            onClick = { navController.navigate(route = Screen.Contact.route) },
            colors = ButtonDefaults.buttonColors(barButtonColor1)
        ) {
            Spacer(Modifier.width(10.dp))
            Icon(
                imageVector = icon1,
                contentDescription = "Contact icon"
            )
            Spacer(Modifier.width(10.dp))
        }
        Button(
            onClick = { navController.navigate(route = Screen.Home.route) },
            colors = ButtonDefaults.buttonColors(barButtonColor2)
        ) {
            Spacer(Modifier.width(10.dp))
            TrackerButtonText(
                buttonTextStr = "Add Exercise"
            )
            Spacer(Modifier.width(10.dp))
        }

        Button(onClick = { navController.navigate(route = Screen.Settings.route) },
            colors = ButtonDefaults.buttonColors(barButtonColor3)){
            Spacer(Modifier.width(10.dp))
            Icon(
                imageVector = icon3,
                contentDescription = "Settings icon"
            )
            Spacer(Modifier.width(10.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailPreview() {
    OPGainsTheme {
        TrackerScreen(
            navController = rememberNavController(),
            trackerButtonText = "Visualize"
        )
    }
}