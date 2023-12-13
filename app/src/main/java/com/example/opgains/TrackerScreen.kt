package com.example.opgains

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.opgains.ui.theme.OPGainsTheme

@Composable
fun TrackerScreen(navController: NavController, modifier: Modifier = Modifier,
                  trackerButtonText: String, workoutExercises:Int) {
        var amount by remember { mutableIntStateOf(workoutExercises) }

    @Composable
    fun TrackerBottomBar(barButtonColor1: Color, barButtonColor2: Color, barButtonColor3: Color,
                         icon1: ImageVector, icon3: ImageVector,
                         navController: NavController, modifier: Modifier = Modifier,) {
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
                onClick = { amount++},
                colors = ButtonDefaults.buttonColors(barButtonColor2)
            ) {
                Spacer(Modifier.width(10.dp))
                TrackerButtonText(
                    buttonTextStr = "Add Exercise"
                )
                Spacer(Modifier.width(10.dp))
            }

            Button(onClick = { navController.navigate(route = Screen.Home.route) },
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

    @Composable
    fun ScrollableList(
        names: List<String> = List(amount) { "$it" }
    ) {

        LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {

            items(items = names) { name ->

                ListItem(name = name)

            }

        }

    }

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
            barButtonColor2 = (Color(0xFF94A150)),
            barButtonColor3 = (Color(0xFFFF0000)),
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
    Column (
        modifier=modifier
            .fillMaxSize()

    ){
        Column (
            modifier=modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(top = 60.dp)
                .padding(bottom = 60.dp)
        ){
            ScrollableList()

        }
        Spacer(modifier = Modifier.height(60.dp))

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
fun ListItem(name : String){

    val expanded = remember { mutableStateOf(false)}
    val extraPadding by animateDpAsState(
        if (expanded.value) 24.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Surface(color = (Color(0xFF94A150)),
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)){

        Column(modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()) {

            Row{

                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp)
                }

                OutlinedButton(onClick = { expanded.value = !expanded.value }) {
                    Text(if (expanded.value) "Show less" else "Show more")
                }
            }

            if (expanded.value){

                Column(modifier = Modifier.padding(
                    bottom = extraPadding.coerceAtLeast(0.dp)
                )) {
                    Text(text = "Hugos riktiga namn är Hugo Lenfjärtsson")
                }

            }
        }

    }



}





@Preview(showBackground = true)
@Composable
fun DetailPreview() {
    OPGainsTheme {
        //ListItem(name = "Push Up")


        TrackerScreen(
            navController = rememberNavController(),
            trackerButtonText = "Visualize",
            workoutExercises=0
        )
    }
}