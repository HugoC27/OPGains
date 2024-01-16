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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.opgains.ui.theme.OPGainsTheme

@Composable
fun ExerciseScreen(navController: NavController, modifier: Modifier = Modifier) {
    val camoBackground = painterResource(R.drawable.camo_background)
    val shoulderExercises = listOf<String>(
        "Arnold Press",
        "Barbell Shoulder Press",
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
    val tricepsExercises = listOf<String>(
        "Barbell JM Press",
        "Barbell Skull Crusher",
        "Barbell Triceps Extension",
        "Cable Triceps Extension",
        "Cable Triceps Push Down",
        "Dumbbell Skull Crusher",
        "Dumbbell Triceps Extension",
        "Machine Triceps Extension",
        "Smith Machine JM Press"
    )
    val bicepsExercises = listOf<String>(
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
    val forearmExercises = listOf<String>(
        "Cable Reverse Wrist Curl",
        "Cable Wrist Curl",
        "Dumbbell Reverse Wrist Curl",
        "Dumbbell Wrist Curl"
    )
    val backExercises = listOf<String>(
        "Assisted Pull Up",
        "Barbell Row",
        "Kneeling Single Arm Cable Pull Down",
        "Landmine Barbell Row",
        "Lat Pull Down",
        "Machine Pull Down",
        "Machine Row",
        "Pull Up",
        "Seated Cable Row",
        "Single Arm Dumbbell Row",
        "Smith Machine Row"
    )
    val trapExercises = listOf<String>(
        "Barbell Shrugs",
        "Cable Shrugs",
        "Dumbbell Shrugs"
    )
    val lowerBackExercises = listOf<String>(
        "Back Extension",
        "Barbell Good Morning",
        "Deadlift",
        "Machine Back Extension",
        "Sumo Deadlift",
    )
    val chestExercises = listOf<String>(
        "Assisted Dip",
        "Barbell Bench Press",
        "Cable Fly",
        "Dip",
        "Dumbbell Bench Press",
        "Dumbbell Fly",
        "Incline Barbell Bench Press",
        "Incline Dumbbell Bench Press",
        "Incline Machine Chest Press",
        "Incline Smith Machine Bench Press",
        "Machine Chest Press",
        "Machine Dip",
        "Peck Deck Fly",
        "Seated Cable Fly",
        "Smith Machine Bench Press"
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
    val hamstringExercises = listOf<String>(
        "Barbell Romanian Deadlift",
        "Dumbbell Romanian Deadlift",
        "Lying Hamstring Curl",
        "Seated Hamstring Curl",
        "Smith Machine Romanian Deadlift"
    )
    val gluteExercises = listOf<String>(
        "Barbell Hip Thrust",
        "Barbell Lunge",
        "Cable Glute Kickback",
        "Dumbbell Bulgarian Split Squats",
        "Dumbbell Lunge",
        "Hip Abductor",
        "Kas Glute Bridge",
        "Smith Machine Bulgarian Split Squat"
    )
    val calfExercises = listOf<String>(
        "Barbell Calf Raise",
        "Leg Press Calf Raise",
        "Machine Calf Raise",
        "Smith Machine Calf Raise"
    )
    val abExercises = listOf<String>(
        "Cable Crunch",
        "Hanging Leg Raise",
        "Lying Leg Raise",
        "Machine Seated Crunch",
        "Sit Up"
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
            .verticalScroll(rememberScrollState())
            .padding(top = 10.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (exercise in shoulderExercises) {
            ExerciseAdder(name = exercise)
        }
        for (exercise in tricepsExercises) {
            ExerciseAdder(name = exercise)
        }
        for (exercise in bicepsExercises) {
            ExerciseAdder(name = exercise)
        }
        for (exercise in forearmExercises) {
            ExerciseAdder(name = exercise)
        }
        for (exercise in backExercises) {
            ExerciseAdder(name = exercise)
        }
        for (exercise in lowerBackExercises) {
            ExerciseAdder(name = exercise)
        }
        for (exercise in trapExercises) {
            ExerciseAdder(name = exercise)
        }
        for (exercise in chestExercises) {
            ExerciseAdder(name = exercise)
        }
        for (exercise in quadExercises) {
            ExerciseAdder(name = exercise)
        }
        for (exercise in hamstringExercises) {
            ExerciseAdder(name = exercise)
        }
        for (exercise in calfExercises) {
            ExerciseAdder(name = exercise)
        }
        for (exercise in abExercises) {
            ExerciseAdder(name = exercise)
        }


    }


}

@Composable
private fun ExerciseAdder(name: String) {
    val buttonColor = ButtonDefaults.buttonColors(Color(0xFF4B5320))
    Card(
        modifier = Modifier
            .width(350.dp)
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
                onClick = {},
                colors = buttonColor

            ) {
                Text(text = "Click To Add Exercise")
            }

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

