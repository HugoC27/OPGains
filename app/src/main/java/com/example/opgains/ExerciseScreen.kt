package com.example.opgains

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.opgains.ui.theme.OPGainsTheme

@Composable
fun ExerciseScreen(navController: NavController, modifier: Modifier = Modifier) {
    val camoBackground = painterResource(R.drawable.camo_background)
    var list = listOf<String>(
        "Arnold Press",
        "Assisted Dip",
        "Assisted Pullups",
        "Back Extension",
        "Barbell Benchpress",
        "Barbell Calf Raise",
        "Barbell Curl",
        "Barbell Good Morning",
        "Barbell JM Press",
        "Barbell Hip Thrust",
        "Barbell Preacher Curl",
        "Barbell Reverse Curl",
        "Barbell Romanian Deadlift",
        "Barbell Row",
        "Barbell Shoudler Press",
        "Barbell Shrugs",
        "Barbell Skullcrusher",
        "Barbell Squat",
        "Barbell Triceps Extension",
        "Barbell Upright Row",
        "Cable Curl",
        "Cable Face Pulls",
        "Cable Fly",
        "Cable Front Raises",
        "Cable Hammer Curl",
        "Cable Rear Delt Fly",
        "Cable Reverse Wrist Curl",
        "Cable Shrugs",
        "Cable Side Lateral Raise",
        "Cable Triceps Extension",
        "Cable Triceps Pushdown",
        "Cable Wrist Curl",
        "Deadlift",
        "Dip",
        "Dumbbell Benchpress",
        "Dumbbell Bulgarian Split Squats",
        "Dumbbell Concentration Curl",
        "Dumbbell Curl",
        "Dumbbell Fly",
        "Dumbbell Front Raises",
        "Dumbbell Hammer Curl",
        "Dumbbell Preacher Curl",
        "Dumbbell Rear Delt Fly",
        "Dumbbell Reverse Curl",
        "Dumbbell Reverse Wrist Curl",
        "Dumbbell Romanian Deadlift",
        "Dumbbell Shoulder Press",
        "Dumbbell Shrugs",
        "Dumbbell Side Lateral Raise",
        "Dumbbell Skullcrusher",
        "Dumbbell Triceps Extension",
        "Dumbbell Wrist Curl",
        "EZ Bar Curl ",
        "EZ Bar Preacher Curl",
        "Goblet Squat",
        "Hack Squat",
        "Hip Abductor",
        "Incline Barbell Benchpress",
        "Incline Dumbbell Benchpress",
        "Incline Machine Chest Press",
        "Incline Smith Machine Benchpress",
        "Kneeling Single Arm Cable Pulldown",
        "Landmine Barbell Row",
        "Landmine Squat ",
        "Lat Pulldown ",
        "Leg Press",
        "Legpress Calf Raise",
        "Lying Hamstring Curl ",
        "Machine Back Extension",
        "Machine Belt Squat",
        "Machine Calf Raise",
        "Machine Leg Press",
        "Machine Pulldown",
        "Machine Row",
        "Machine Shoulder Press",
        "Machine Side Lateral Raise",
        "Machine Triceps Extension",
        "Mashine Chest Press",
        "Mashine Dip",
        "Peck Deck Fly",
        "Pendulum Squat",
        "Pullups",
        "Reverse Peck Deck Fly",
        "Seated Cable Fly",
        "Seated Cable Row",
        "Seated Hamstring Curl",
        "Single Arm Dumbbell Row",
        "Sissy Squat",
        "Smith Machine Benchpress",
        "Smith Machine Bulgarian Split Squat",
        "Smith Machine Calf Raise",
        "Smith Machine JM Press",
        "Smith Machine Romanian Deadlift",
        "Smith Machine Row",
        "Smith Machine Squat ",
        "Sumo Deadlift",
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
    LazyColumn {

    }


}

fun ExcersiseAdder(){

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
