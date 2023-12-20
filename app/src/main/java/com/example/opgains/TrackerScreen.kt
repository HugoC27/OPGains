package com.example.opgains

import android.util.Log
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
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
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.ui.text.input.KeyboardType

var scoreCalves = 2
var scoreThigh = 1
var scoreHipAbductor = 0
var scoreAbs = 3
var scoreOblique = 3
var scoreLats = 1
var scoreChest = 5
var scoreTraps = 0
var scoreNeck = 3
var scoreShoulders = 1
var scoreTriceps = 3
var scoreBiceps = 1
var scoreForearms = 4
var scoreHamstrings = 5
var scoreGlutes = 0
var scoreLowerBack = 4

@Composable
fun TrackerScreen(navController: NavController, modifier: Modifier = Modifier,
                  trackerButtonText: String, workoutExercises:Int) {
        var amount by remember { mutableIntStateOf(workoutExercises) }
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
        names: List<String> = List(amount) { "$it" },
        onAddSet: (sets: Int, reps: Int, weight: Float) -> Unit
    ) {
        LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
            items(items = names) { exName ->
                ListItem(name = exName, onAddSet = onAddSet)
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
            modifier= modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(top = 60.dp)
                .padding(bottom = 60.dp)
        ){
            ScrollableList(
                onAddSet = { sets, reps, weight ->

                }
            )

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
            onClick = { navController.navigate(route = Screen.VisualizationFront.passAllScores(
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
            )) },
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
fun ListItem(name: String, onAddSet: (sets: Int, reps: Int, weight: Float) -> Unit) {
    val expanded = remember { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        if (expanded.value) 24.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ), label = ""
    )

    Surface(
        color = (Color(0xFFFFFFFF)),
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Column(modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()) {

            Row {
                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }

                OutlinedButton(
                    colors = ButtonDefaults.buttonColors(Color(0xFF94A150)),
                    onClick = { expanded.value = !expanded.value }) {
                    Text(if (expanded.value) "Show less" else "Show more")
                }
            }

            if (expanded.value) {
                // Display the set tracker for each exercise
                SetTracker(onAddSet = onAddSet)
            }
        }
    }
}

@Composable
fun SetTracker(onAddSet: (sets: Int, reps: Int, weight: Float) -> Unit) {
    var setCount by remember { mutableStateOf(0) }
    var setsData by remember { mutableStateOf<List<SetData>>(emptyList()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Text(text = "Set", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Reps", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Weight (kg)", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        }

        // Set rows
        setsData.forEach { setData ->
            SetRow(setData = setData) { newReps, newWeight ->
                setsData = setsData.map {
                    if (it.setNumber == setData.setNumber) {
                        SetData(it.setNumber, newReps, newWeight)
                    } else {
                        it
                    }
                }
            }
        }

        // Add Set button
        Button(
            onClick = {
                setCount++
                setsData = List(setCount) { SetData(it + 1, 0, 0.0f) }
                onAddSet(0, 0, 0.0f)
                Log.d("SetTracker", "Set count: $setCount, Sets data: $setsData")

            },
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = 16.dp)
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add Set")
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Add Set")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetRow(setData: SetData, onValuesChanged: (Int, Float) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(text = "${setData.setNumber}", fontSize = 16.sp)
        Spacer(modifier = Modifier.width(16.dp))
        OutlinedTextField(
            value = setData.reps.toString(),
            onValueChange = {
                onValuesChanged(it.toIntOrNull() ?: 0, setData.weight)
            },
            label = { Text("Reps") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier= Modifier
                .width(100.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        OutlinedTextField(
            value = setData.weight.toString(),
            onValueChange = {
                onValuesChanged(setData.reps, it.toFloatOrNull() ?: 0.0f)
            },
            label = { Text("Weight") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier= Modifier
                .width(100.dp)
        )
    }
}

data class SetData(val setNumber: Int, val reps: Int, val weight: Float)






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