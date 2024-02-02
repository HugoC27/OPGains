package com.example.opgains

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.opgains.ui.theme.OPGainsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExerciseScreen(navController: NavController, modifier: Modifier = Modifier) {

    // Hämtar information från MainViewModel
    val viewModel = viewModel<MainViewModel>()
    val searchText by viewModel.searchText.collectAsState()
    val buttonColor = Color(0xFF94A150)
    val filterText = "Back"


    // Bakgrundsbild
    val camoBackground = painterResource(R.drawable.camo_background)
    Image(
        painter = camoBackground,
        contentDescription = "Background",
        contentScale = ContentScale.Crop,
        alpha = 0.6F,
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFA4B25C))
    )

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        TopBar(
            barButtonColor = (Color(0xFF94A150)),
            icon = Icons.Filled.ArrowBack,
            navController = navController
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(70.dp))
                TextField(
                    value = searchText,
                    onValueChange = viewModel::onSearchTextChange,
                    Modifier.fillMaxWidth(),
                    placeholder = { Text(text = "Search") }
                )
                Spacer(modifier = Modifier.height(7.dp))
                Spacer(modifier = Modifier.height(7.dp))
                LazyColumnAdder(navController = navController)
            }
            Box(
                contentAlignment = Alignment.BottomStart,
                modifier = modifier
                    .fillMaxSize()
            ) {

            }
        }
    }
}


// Funktion för att göra korten
@Composable
private fun ExerciseAdder(exName: String, musName: String, navController: NavController) {
    val buttonColor = ButtonDefaults.buttonColors(Color(0xFF4B5320))
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(top = 2.dp, bottom = 2.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        border = BorderStroke(1.dp, Color.Black),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = exName,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )
            Button(
                modifier = Modifier
                    .width(250.dp)
                    .height(35.dp),
                onClick = {
                    SharedData.addAmount(1)
                    createNewListItemData(exName = exName, musName = musName)
                    navController.navigate(route = Screen.Tracker.route)
                },
                colors = buttonColor,
                border = BorderStroke(1.dp, Color.Black)
            ) {
                Text(
                    text = "Click To Add Exercise",
                    color = Color.White,
                )
            }
        }
    }

}


// Funktion som lägger alla korten i en LazyColumn
@Composable
private fun LazyColumnAdder(navController: NavController) {
    val viewModel = viewModel<MainViewModel>()
    val exercises by viewModel.exercises.collectAsState()
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(exercises) { exercise ->
            ExerciseAdder(
                exName = exercise.exerciseName,
                navController = navController,
                musName = exercise.bodyPartName
            )
        }
    }
}

//funktion för filterraden
@Composable
fun TopBar(
    barButtonColor: Color,
    icon: ImageVector,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
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
            onClick = { navController.navigate(route = Screen.Tracker.route) },
            colors = ButtonDefaults.buttonColors(barButtonColor),
            border = BorderStroke(1.dp, Color.Black)
        ) {
            Spacer(Modifier.width(10.dp))
            Icon(
                imageVector = icon,
                tint = Color.White,
                contentDescription = "Contact icon"
            )
            Spacer(Modifier.width(10.dp))
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
            colors = ButtonDefaults.buttonColors(barButtonColor),
            border = BorderStroke(1.dp, Color.Black)
        ) {
            Text(
                text = "Visualize",
                color = Color.White,
                fontSize = 15.sp
            )
        }
        Spacer(Modifier.width(20.dp))
    }

}

//funktion för filtret
@Composable
fun FilterButton(buttonColor: Color, modifier: Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Button(
            modifier = modifier
                .fillMaxWidth(),
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(buttonColor),
            border = BorderStroke(1.dp, Color.Black)
        ) {
            Spacer(Modifier.width(10.dp))
            Text(
                text = "Filter",
                color = Color.White,
                fontSize = 25.sp
            )
            Spacer(Modifier.width(10.dp))
        }
    }
}

@Composable
fun BotBar(
    modifier: Modifier,
    icon: ImageVector,
    barButtonColor: Color,
    navController: NavController
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
            onClick = { navController.navigate(route = Screen.Home.route) },
            colors = ButtonDefaults.buttonColors(barButtonColor),
            border = BorderStroke(1.dp, Color.Black)
        ) {
            Spacer(Modifier.width(10.dp))
            Icon(
                imageVector = icon,
                contentDescription = "Home icon",
                tint = Color.White
            )
            Spacer(Modifier.width(10.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExercisePreview() {
    OPGainsTheme {
        ExerciseScreen(
            navController = rememberNavController(),
        )
    }
}

