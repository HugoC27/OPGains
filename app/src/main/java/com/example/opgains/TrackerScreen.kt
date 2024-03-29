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
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*

import androidx.compose.ui.text.input.KeyboardType

var scoreCalves = 0
var scoreThigh = 0
var scoreHipAbductor = 0
var scoreAbs = 0
var scoreOblique = 0
var scoreLats = 0
var scoreChest = 0
var scoreTraps = 0
var scoreNeck = 0
var scoreShoulders = 0
var scoreTriceps = 0
var scoreBiceps = 0
var scoreForearms = 0
var scoreHamstrings = 0
var scoreGlutes = 0
var scoreLowerBack =0
val exerciseList = mutableListOf<Exercise>()
data class ListItemData(val exercise: Exercise, val onAddSet: (Int, Int, Double) -> Unit)
var listItemData = mutableListOf<ListItemData>()


@Composable
fun TrackerScreen(
    navController: NavController, modifier: Modifier = Modifier,
    trackerButtonText: String
) {
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
    Column(
        modifier = modifier
            .fillMaxSize()

    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(top = 60.dp)
                .padding(bottom = 60.dp)
        ) {

            ScrollableList(navController = navController)

        }
        Spacer(modifier = Modifier.height(60.dp))

    }
}

@Composable
fun TrackerBottomBar(
    barButtonColor1: Color, barButtonColor2: Color, barButtonColor3: Color,
    icon1: ImageVector, icon3: ImageVector,
    navController: NavController, modifier: Modifier = Modifier,
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
            onClick = { navController.navigate(route = Screen.Settings.route) },
            colors = ButtonDefaults.buttonColors(barButtonColor1),
            border = BorderStroke(1.dp, Color.Black)
        ) {
            Spacer(Modifier.width(10.dp))
            Icon(
                imageVector = icon1,
                contentDescription = "Settings icon",
                tint = Color.White
            )
            Spacer(Modifier.width(10.dp))
        }
        Button(
            onClick = {
                navController.navigate(route = Screen.Exercise.route)
                      },
            colors = ButtonDefaults.buttonColors(barButtonColor2),
            border = BorderStroke(1.dp, Color.Black)
        ) {
            Spacer(Modifier.width(10.dp))
            TrackerButtonText(
                buttonTextStr = "Add Exercise"
            )
            Spacer(Modifier.width(10.dp))
        }
        Button(
            onClick = {
                listItemData.forEach { listItem ->
                    listItem.exercise.sets = 0
                }
                listItemData.clear()
                navController.navigate(route=Screen.Home.route)
                      },
            colors = ButtonDefaults.buttonColors(barButtonColor3),
            border = BorderStroke(1.dp, Color.Black)
        ) {
            Spacer(Modifier.width(10.dp))
            Icon(
                imageVector = icon3,
                contentDescription = "Settings icon",
                tint = Color.White
            )
            Spacer(Modifier.width(10.dp))
        }
    }
}

fun createNewListItemData(exName: String, musName: String) {
    var repsTracker= mutableListOf<Int>()
    var weightTracker= mutableListOf<Double>()


    var newExercise = Exercise(exName, musName, 1,repsTracker, weightTracker)

    val newListItemData = ListItemData(
        exercise = newExercise,
        onAddSet = { sets, reps, weight ->
            println("Adding set for ${newExercise.name}: Sets=$sets, Reps=$reps, Weight=$weight")
            newExercise.sets=sets
            newExercise.repsList[0] = reps
            newExercise.weightList[0] = weight
        }
    )
    listItemData.add(newListItemData)
}

@Composable
fun ScrollableList(navController:NavController) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = listItemData) { item ->
            ListItem(exercise = item.exercise, onAddSet = item.onAddSet,navController=navController)
        }
    }
}


@Composable
fun SetTracker(
    exercise: Exercise,
    navController:NavController,
    onAddSet: (sets: Int, reps: Int, weight: Double) -> Unit
) {


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
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = "Reps", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.width(50.dp))
            Text(text = "Weight (kg)", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        }

        //SetRows
        for (i in 0 until exercise.sets) {
            exercise.repsList.add(0)
            exercise.weightList.add(0.0)
            SetRow(set = i, repsList = exercise.repsList , weightList = exercise.weightList ){ reps, weight ->
                // This block of code will be executed when the values change
                // Update your data, perform calculations, or trigger other actions
                println("Reps: ${exercise.repsList[i]}, Weight: $weight")
            }
        }

        // Add Set button
        Button(
            colors = ButtonDefaults.buttonColors(Color(0xFF94A150)),
            onClick = {
                // Update Exercise properties and trigger recomposition
                exercise.sets++
                exercise.repsList.add(0)
                exercise.weightList.add(0.0)
                navController.navigate(route = Screen.Tracker.route)

            },
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = 16.dp)
        ) {
            Icon(imageVector = Icons.Default.Add,
                contentDescription = "Add Set",
                tint = Color.White)
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Add Set",
                color = Color.White)
        }
    }
}
@Composable
fun ListItem(
    onAddSet: (sets: Int, reps: Int, weight: Double) -> Unit,
    exercise: Exercise,
    navController:NavController
) {
    exerciseList.add(exercise)
    Card(
        border = BorderStroke(1.dp, Color.Black),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {

            Row {
                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = exercise.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    SetTracker(
                        exercise = exercise,
                        onAddSet = onAddSet,
                        navController=navController

                    )
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetRow(set: Int, repsList: MutableList<Int>, weightList: MutableList<Double>, onValuesChanged: (Int, Double) -> Unit) {
    // Variables for textfield output
    var reps by remember { mutableStateOf(repsList.getOrElse(set) { 0 }.toString()) }
    var weight by remember { mutableStateOf(weightList.getOrElse(set) { 0.0 }.toString()) }
    val displaySet = set + 1

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(text = "$displaySet", fontSize = 16.sp)
        Spacer(modifier = Modifier.width(16.dp))
        OutlinedTextField(
            value = reps,
            onValueChange = {
                reps = it
                repsList[set] = it.toIntOrNull() ?: 0
                onValuesChanged(repsList[set], weightList[set])
            },
            label = { Text("Reps") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.width(100.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        OutlinedTextField(
            value = weight,
            onValueChange = {
                weight = it
                weightList[set] = it.toDoubleOrNull() ?: 0.0
                onValuesChanged(repsList[set], weightList[set])
            },
            label = { Text("Weight") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.width(100.dp)
        )
    }
}



@Composable
fun TrackerTopBar(
    navController: NavController,
    modifier: Modifier = Modifier,
    trackerButtonText2: String
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
            onClick = { navController.navigate(route = Screen.Home.route) },
            colors = ButtonDefaults.buttonColors(Color(0xFF94A150)),
            border = BorderStroke(1.dp, Color.Black)
        ) {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "home_icon",
                tint = Color.White
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
            colors = ButtonDefaults.buttonColors(Color(0xFF94A150)),
            border = BorderStroke(1.dp, Color.Black)
        ) {
            TrackerButtonText(
                buttonTextStr = trackerButtonText2,
            )
        }
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