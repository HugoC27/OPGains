package com.example.opgains

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.opgains.ui.theme.OPGainsTheme

@Composable
fun ExerciseScreen(navController: NavController, modifier: Modifier = Modifier) {
    val camoBackground = painterResource(R.drawable.camo_background)
    var shoulderExercises = listOf<String>(
        "Arnold Press",
        "Barbell Shoudler Press",
        "Barbell Upright Row",
        "Cable Face Pulls",
        "Cable Front Raises",
        "Cable Rear Delt Fly",
        "Cable Side Lateral Raise",
        "Dumbbell Front Raises",
        "Dumbbell Rear Delt Fly",
        "Dumbbell Shoulder Press",
        "Dumbbell Side Lateral Raise",
        "Machine Shoulder Press",
        "Machine Side Lateral Raise",
        "Reverse Peck Deck Fly"
    )
    var tricepsExercises = listOf<String>(
        "Barbell JM Press",
        "Barbell Skullcrusher",
        "Barbell Triceps Extension",
        "Cable Triceps Extension",
        "Cable Triceps Pushdown",
        "Dumbbell Skullcrusher",
        "Dumbbell Triceps Extension",
        "Machine Triceps Extension",
        "Smith Machine JM Press"
    )
    var bicepsExercises = listOf<String>(
        "Barbell Curl",
        "Barbell Preacher Curl",
        "Barbell Reverse Curl",
        "Cable Curl",
        "Cable Hammer Curl",
        "Dumbbell Concentration Curl",
        "Dumbbell Curl",
        "Dumbbell Hammer Curl",
        "Dumbbell Preacher Curl",
        "Dumbbell Reverse Curl",
        "EZ Bar Curl",
        "EZ Bar Curl",
        "EZ Bar Preacher Curl",
    )
    var forearmExercises = listOf<String>(
        "Cable Reverse Wrist Curl",
        "Cable Wrist Curl",
        "Dumbbell Reverse Wrist Curl",
        "Dumbbell Wrist Curl"
    )
    var backExercises = listOf<String>(
        "Assisted Pullups",
        "Barbell Row",
        "Kneeling Single Arm Cable Pulldown",
        "Landmine Barbell Row",
        "Lat Pulldown",
        "Machine Pulldown",
        "Machine Row",
        "Pullups",
        "Seated Cable Row",
        "Single Arm Dumbbell Row",
        "Smith Machine Row"
    )
    var trapExercises = listOf<String>(
        "Barbell Shrugs",
        "Cable Shrugs",
        "Dumbbell Shrugs"
    )
    var lowerBack = listOf<String>(
        "Back Extension",
        "Barbell Good Morning",
        "Deadlift",
        "Machine Back Extension",
        "Sumo Deadlift",
    )
    var chestExercises = listOf<String>(
        "Assisted Dip",
        "Barbell Benchpress",
        "Cable Fly",
        "Dip",
        "Dumbbell Benchpress",
        "Dumbbell Fly",
        "Incline Barbell Benchpress",
        "Incline Dumbbell Benchpress",
        "Incline Machine Chest Press",
        "Incline Smith Machine Benchpress",
        "Mashine Chest Press",
        "Mashine Dip",
        "Peck Deck Fly",
        "Seated Cable Fly",
        "Smith Machine Benchpress"
    )
    val quadExercises = listOf<String>(
        "Barbell Squat",
        "Goblet Squat",
        "Hack Squat",
        "Landmine Squat",
        "Leg Press",
        "Machine Belt Squat",
        "Machine Leg Press",
        "Pendulum Squat",
        "Sissy Squat",
        "Smith Machine Squat"
    )

    Image(
        painter = camoBackground,
        contentDescription = "Background",
        contentScale = ContentScale.Crop,
        alpha = 0.6F,
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFA4B25C))

    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ExerciseAdder(name = "Olle")
        ExerciseAdder(name = "Hugo")
        ExerciseAdder(name = "Joe")
        ExerciseAdder(name = "Joe")
        ExerciseAdder(name = "Joe")
        ExerciseAdder(name = "Joe")
        ExerciseAdder(name = "Joe")
        ExerciseAdder(name = "Joe")
        ExerciseAdder(name = "Joe")
        ExerciseAdder(name = "Joe")
        ExerciseAdder(name = "Joe")
        ExerciseAdder(name = "Joe")
        ExerciseAdder(name = "Joe")
        ExerciseAdder(name = "Joe")
        ExerciseAdder(name = "Joe")
    }


}

@Composable
private fun ExerciseAdder(name: String) {
    Card(
        modifier = Modifier
            .width(350.dp)
            .height(150.dp)
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        border = BorderStroke(1.dp, Color.Black),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )
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

