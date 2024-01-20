package com.example.opgains

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.opgains.ui.theme.OPGainsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExerciseScreen(navController: NavController, modifier: Modifier = Modifier) {
    val camoBackground = painterResource(R.drawable.camo_background)
    val viewModel = viewModel<MainViewModel>()
    val searchText by viewModel.searchText.collectAsState()
    val exercises by viewModel.exercises.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()

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
            .padding(16.dp)
    ) {
        TextField(
            value = searchText,
            onValueChange = viewModel::onSearchTextChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Search") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumnAdder()


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

@Composable
private fun LazyColumnAdder() {
    val viewModel = viewModel<MainViewModel>()
    val exercises by viewModel.exercises.collectAsState()
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(exercises) { exercise ->
            ExerciseAdder(name = exercise.exerciseName)

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

