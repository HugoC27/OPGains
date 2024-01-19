package com.example.opgains

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.opgains.ui.theme.OPGainsTheme

var pushMultiplier = 1
var pullMultiplier = 1
var legsMultiplier = 1
var upperMultiplier = 1
var lowerMultiplier = 1
var chestMultiplier = 1
var backMultiplier = 1
var armsMultiplier = 1
var shoulderMultiplier = 1

var globalRadioState = "ppl"

@Composable
fun SettingsScreen(navController: NavController, modifier: Modifier = Modifier) {
    val camoBackground = painterResource(R.drawable.camo_background)
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(globalRadioState) }
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFA4B25C))
    ) {
        Image(
            painter = camoBackground,
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            alpha = 0.6F,
            modifier = modifier
                .fillMaxSize()
        )
    }
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = modifier
            .fillMaxSize()
            .selectableGroup()
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .weight(1f)
            ) {
                WorkoutSplitBox(
                    title = "Push Pull Legs",
                    description = "",
                    pushMulti = 1,
                    pullMulti = 1,
                    legsMulti = 1,
                    upperMulti = 1,
                    lowerMulti = 1,
                    chestMulti = 1,
                    backMulti = 1,
                    armsMulti = 1,
                    shoulderMulti  = 1,
                    boxName = "ppl",
                    selectedOption = selectedOption,
                    onOptionSelected = onOptionSelected)
                WorkoutSplitBox(
                    title = "Upper Lower",
                    description = "",
                    pushMulti = 1,
                    pullMulti = 1,
                    legsMulti = 1,
                    upperMulti = 1,
                    lowerMulti = 1,
                    chestMulti = 1,
                    backMulti = 1,
                    armsMulti = 1,
                    shoulderMulti  = 1,
                    boxName = "ul",
                    selectedOption = selectedOption,
                    onOptionSelected = onOptionSelected)
                WorkoutSplitBox(
                    title = "Bro split",
                    description = "",
                    pushMulti = 1,
                    pullMulti = 1,
                    legsMulti = 1,
                    upperMulti = 1,
                    lowerMulti = 1,
                    chestMulti = 1,
                    backMulti = 1,
                    armsMulti = 1,
                    shoulderMulti  = 1,
                    boxName = "bro",
                    selectedOption = selectedOption,
                    onOptionSelected = onOptionSelected)
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .weight(1f)
            ) {
                WorkoutSplitBox(
                    title = "Push Pull Legs x2",
                    description = "",
                    pushMulti = 2,
                    pullMulti = 2,
                    legsMulti = 2,
                    upperMulti = 1,
                    lowerMulti = 1,
                    chestMulti = 1,
                    backMulti = 1,
                    armsMulti = 1,
                    shoulderMulti = 1,
                    boxName = "ppl2",
                    selectedOption = selectedOption,
                    onOptionSelected = onOptionSelected)
                WorkoutSplitBox(
                    title = "Upper Lower x2",
                    description = "",
                    pushMulti = 1,
                    pullMulti = 1,
                    legsMulti = 1,
                    upperMulti = 2,
                    lowerMulti = 2,
                    chestMulti = 1,
                    backMulti = 1,
                    armsMulti = 1,
                    shoulderMulti  = 1,
                    boxName = "ul2",
                    selectedOption = selectedOption,
                    onOptionSelected = onOptionSelected)
                WorkoutSplitBox(
                    title = "Full Body",
                    description = "",
                    pushMulti = 1,
                    pullMulti = 1,
                    legsMulti = 1,
                    upperMulti = 1,
                    lowerMulti = 1,
                    chestMulti = 1,
                    backMulti = 1,
                    armsMulti = 1,
                    shoulderMulti = 1,
                    boxName = "fb",
                    selectedOption = selectedOption,
                    onOptionSelected = onOptionSelected
                )
            }
        }
    }
    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = modifier
            .fillMaxSize()
    ) {
        BottomBar(
            navController = navController,
            icon1 = Icons.Filled.Phone,
            icon2 = Icons.Filled.Home,
            icon3 = Icons.Filled.Settings,
            barButtonColor1 = (Color(0xFF94A150)),
            barButtonColor2 = (Color(0xFF94A150)),
            barButtonColor3 = (Color(0xFF6B7534)),
            barButtonEnabled1 = true,
            barButtonEnabled2 = true,
            barButtonEnabled3 = false
        )
    }
}

@Composable
fun WorkoutSplitBox(title: String, description: String, modifier: Modifier = Modifier,
                    pushMulti: Int,
                    pullMulti: Int,
                    legsMulti: Int,
                    upperMulti: Int,
                    lowerMulti: Int,
                    chestMulti: Int,
                    backMulti: Int,
                    armsMulti: Int,
                    shoulderMulti: Int,
                    boxName: String,
                    selectedOption: String,
                    onOptionSelected: (String) -> Unit
) {
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = modifier
            .padding(16.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            )
            .fillMaxWidth()
            .height(150.dp)
            .selectable(
                selected = (boxName == selectedOption),
                onClick = {
                    onOptionSelected(boxName)
                    globalRadioState = boxName
                    pushMultiplier = pushMulti
                    pullMultiplier = pullMulti
                    legsMultiplier = legsMulti
                    upperMultiplier = upperMulti
                    lowerMultiplier = lowerMulti
                    chestMultiplier = chestMulti
                    backMultiplier = backMulti
                    armsMultiplier = armsMulti
                    shoulderMultiplier = shoulderMulti
                },
                role = Role.RadioButton
            )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                modifier = modifier
                    .padding(top = 10.dp)
            )
            Text(
                text = description,
                modifier = modifier
                    .padding(5.dp)
            )
            Spacer(modifier.height(25.dp))
            RadioButton(
                selected = (boxName == selectedOption),
                onClick = null,
                colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF94A150)),
                modifier = modifier
                    .size(25.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SettingsPreview() {
    OPGainsTheme {
        SettingsScreen(
            navController = rememberNavController(),
        )
    }
}