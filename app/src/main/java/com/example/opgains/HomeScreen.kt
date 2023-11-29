package com.example.opgains

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.opgains.ui.theme.OPGainsTheme
import androidx.compose.material.icons.filled.Settings

@Composable
fun HomeScreen(title: String, buttonText: String, navController: NavController, modifier: Modifier = Modifier) {
    val appLogo = painterResource(R.drawable.opgainsround)
    val buttonColor = ButtonDefaults.buttonColors(Color(0xFF4B5320))
    val camoBackground = painterResource(R.drawable.camo_background)
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFA4B25C))
    ){
        Image(
            painter = camoBackground,
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            alpha = 0.6F,
            modifier = modifier
                .fillMaxSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = appLogo,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = modifier
                    .height(280.dp)
                    .width(280.dp)
            )
            TitleText(
                titleStr = title,
                modifier = modifier
                    .padding(top = 10.dp,bottom = 10.dp)
            )
            Spacer(
                modifier = modifier
                    .height(90.dp)
            )
            Button(onClick = { navController.navigate(route = Screen.Detail.route) },
                colors = buttonColor){
                ButtonText(
                    buttonTextStr = buttonText,
                )
            }
            Spacer(
                modifier = modifier
                    .height(50.dp)
            )
        }
        Box(
            contentAlignment = Alignment.BottomStart,
            modifier = modifier
                .fillMaxSize()
        ){
            BottomBar(
                navController = navController,
                icon1 = Icons.Filled.Phone,
                icon2 = Icons.Filled.Home,
                icon3 = Icons.Filled.Settings,
                barButtonColor1 = (Color(0xFF94A150)),
                barButtonColor2 = (Color(0xFF6B7534)),
                barButtonColor3 = (Color(0xFF94A150))
            )
        }
    }
}

@Composable
fun TitleText(titleStr: String, modifier: Modifier = Modifier){
    Text(
        text = titleStr,
        textAlign = TextAlign.Center,
        fontSize = 40.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color.Black,
        modifier = modifier
    )
}

@Composable
fun ButtonText(buttonTextStr: String, modifier: Modifier = Modifier){
    Text(
        text = buttonTextStr,
        textAlign = TextAlign.Center,
        fontSize = 35.sp,
        color = Color.White,
        modifier = modifier
    )
}

@Composable
fun BottomBar(barButtonColor1: Color, barButtonColor2: Color, barButtonColor3: Color,
              icon1: ImageVector, icon2: ImageVector, icon3: ImageVector,
              navController: NavController, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(Color(0xFF4B5320))
            .fillMaxWidth()
            .height(64.dp)
    ){
        Button(onClick = { navController.navigate(route = Screen.Contact.route) },
            colors = ButtonDefaults.buttonColors(barButtonColor1)){
            Spacer(Modifier.width(10.dp))
            Icon(
                imageVector = icon1,
                contentDescription = "Contact icon"
            )
            Spacer(Modifier.width(10.dp))
        }
        Button(onClick = { navController.navigate(route = Screen.Home.route) },
            colors = ButtonDefaults.buttonColors(barButtonColor2)){
            Spacer(Modifier.width(10.dp))
            Icon(
                imageVector = icon2,
                contentDescription = "Home icon"
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
fun HomePreview() {
    OPGainsTheme {
        HomeScreen(
            title = "OPGains",
            buttonText = "START WORKOUT",
            navController = rememberNavController(),
        )
    }
}