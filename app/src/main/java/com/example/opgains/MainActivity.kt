package com.example.opgains

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.opgains.ui.theme.OPGainsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OPGainsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen(
                        title = "OPGains ",
                        buttonText = "Start workout!",
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(title: String, buttonText: String, modifier: Modifier = Modifier) {
    val appLogo = painterResource(R.drawable.opgainsround)
    val buttonColor = ButtonDefaults.buttonColors(Color(0xFF4B5320))
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFB4F1C1))
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = appLogo,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = modifier
                    .height(200.dp)
                    .width(200.dp)
            )
            TitleText(
                titleStr = title,
                modifier = modifier
                    .padding(top = 10.dp,bottom = 50.dp)
            )
            Spacer(
                modifier = modifier
                    .height(180.dp)
            )
            Button(onClick = { /*TODO*/ },
                colors = buttonColor){
                ButtonText(
                    buttonTextStr = buttonText,
                )
            }
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

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    OPGainsTheme {
        HomeScreen(
            title = "OPGains",
            buttonText = "Start workout!",
        )
    }
}