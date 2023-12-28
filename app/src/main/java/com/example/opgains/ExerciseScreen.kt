package com.example.opgains

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
        "Machine Chest Press",
        "Machine Dip",
        "Machine Leg Press",
        "Machine Pulldown",
        "Machine Row",
        "Machine Shoulder Press",
        "Machine Side Lateral Raise",
        "Machine Triceps Extension",
        "Peck Deck Fly",
        "Pendulum Squat",
        "Pullup",
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
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        ExerciseAdder(Name = "Hugo")

    }


}

@Composable
private fun ExerciseAdder(Name: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Card(
            modifier = Modifier
                .width(350.dp)
                .height(150.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            border = BorderStroke(1.dp, Color.Black),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = Name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )
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
