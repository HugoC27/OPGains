package com.example.opgains

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.opgains.ui.theme.OPGainsTheme

@Composable
fun SettingsScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .fillMaxSize()
                .background(Color.Yellow)
        ) {
            Text("Inställningar")
        }
    }
    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = modifier
            .fillMaxSize()
    ) {
        BottomBar(
            navController = navController,
            icon1 = Icons.Filled.Phone,
            icon2 = Icons.Filled.Home,
            icon3 = Icons.Filled.Settings,
            barButtonColor1 = (Color(0xFF94A150)),
            barButtonColor2 = (Color(0xFF94A150)),
            barButtonColor3 = (Color(0xFF6B7534))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsPreview() {
    OPGainsTheme {
        SettingsScreen(
            navController = rememberNavController(),
        )
    }
}