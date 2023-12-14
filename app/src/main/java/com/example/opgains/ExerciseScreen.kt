package com.example.opgains

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.opgains.ui.theme.OPGainsTheme

@Composable
fun ExerciseScreen(navController: NavController, modifier: Modifier = Modifier) {
    val camoBackground = painterResource(R.drawable.camo_background)



}
@Preview(showBackground = true)
@Composable
fun ExercisePreview() {
    OPGainsTheme {
        ContactScreen(
            navController = rememberNavController(),
        )
    }
}
