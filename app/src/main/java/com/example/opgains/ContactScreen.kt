package com.example.opgains

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.opgains.ui.theme.OPGainsTheme

@Composable
fun ContactScreen(navController: NavController, modifier: Modifier = Modifier) {
    val camoBackground = painterResource(R.drawable.camo_background)
    val whiteBox = painterResource(R.drawable.whitecontact)
    val appLogo = painterResource(R.drawable.opgainsround)
    Column {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .fillMaxSize()
                .background(Color(0xFFA4B25C))
        ) {
            Image(
                painter = camoBackground,
                contentDescription = "Background",
                contentScale = ContentScale.Crop,
                alpha = 0.6F,
                modifier = modifier
                    .fillMaxSize()
            )
            Image(
                painter = whiteBox,
                contentDescription = "frame",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .height(350.dp)
                    .width(280.dp)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = appLogo,
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = modifier
                        .height(200.dp)
                        .width(200.dp)
                        .padding(bottom = 15.dp)
                )
                Text("opgains@gmail.com")
                Text("+46 123 456 789")

            }
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
            barButtonColor1 = (Color(0xFF6B7534)),
            barButtonColor2 = (Color(0xFF94A150)),
            barButtonColor3 = (Color(0xFF94A150)),
            barButtonEnabled1 = false,
            barButtonEnabled2 = true,
            barButtonEnabled3 = true
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ContactPreview() {
    OPGainsTheme {
        ContactScreen(
            navController = rememberNavController(),
        )
    }
}