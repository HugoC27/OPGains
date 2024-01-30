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
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
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

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun ExerciseScreen(navController: NavController, modifier: Modifier = Modifier) {

    // Hämtar information från MainViewModel
    val viewModel = viewModel<MainViewModel>()
    val searchText by viewModel.searchText.collectAsState()
    val controller = LocalSoftwareKeyboardController.current
    val buttonColor = ButtonDefaults.buttonColors(Color(0xFF4B5320))


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

    // Lägger in ett sökfält och kort för alla övningar
    Box(contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(Modifier.width(10.dp))
            TextField(
                value = searchText,
                onValueChange = viewModel::onSearchTextChange,
                Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Search") }
            )

            Spacer(modifier = Modifier.height(10.dp))
            filterBar(
                barButtonColor = (Color(0xFF94A150)),
                icon = Icons.Filled.ArrowBack,
                navController = navController
            )
            Spacer(modifier = Modifier.height(10.dp))
            LazyColumnAdder(navController = navController)
        }
        //filterfunktion här
    }
}


// Funktion för att göra korten
@Composable
private fun ExerciseAdder(name: String, navController: NavController) {
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
                text = name,
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
                    createNewListItemData(exName = name)
                    navController.navigate(route = Screen.Tracker.route)
                },
                colors = buttonColor
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
            ExerciseAdder(name = exercise.exerciseName, navController = navController)
        }
    }
}

@Composable
fun filterBar(
    barButtonColor: Color,
    icon: ImageVector,
    navController: NavController,
    modifier: Modifier = Modifier,
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
            onClick = { navController.navigate(route = Screen.Tracker.route) },
            colors = ButtonDefaults.buttonColors(barButtonColor)
        ) {
            Spacer(Modifier.width(10.dp))
            Icon(
                imageVector = icon,
                tint = Color.White,
                contentDescription = "Contact icon"
            )
            Spacer(Modifier.width(10.dp))
        }
        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(barButtonColor)
        ) {
            Spacer(Modifier.width(10.dp))
            TrackerButtonText(
                buttonTextStr = "Filter"
            )
            Spacer(Modifier.width(10.dp))
        }
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
            colors = ButtonDefaults.buttonColors(barButtonColor)
        ) {
            Text(text = "Visualize")
        }
    }
}

@Composable
fun filter(){

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

