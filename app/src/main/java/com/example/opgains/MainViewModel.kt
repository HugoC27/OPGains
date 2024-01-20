package com.example.opgains

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

@OptIn(FlowPreview::class)
class MainViewModel: ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _exercises = MutableStateFlow(allExercises)
    val exercises = searchText
        .debounce(1000L)
        .onEach { _isSearching.update { true } }
        .combine(_exercises) { text, exercises ->
            if(text.isBlank()) {
                exercises
            } else {
                delay(500L)
                exercises.filter {
                    it.doesMatchSearchQuery(text)
                }
            }
        }
        .onEach { _isSearching.update { false } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _exercises.value
        )

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }
}

data class Exercises(
    val exerciseName: String,
    val bodyPartName: String
) {
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            "$exerciseName",
            "$bodyPartName",

        )

        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}

private val allExercises = listOf(
    Exercises(
        exerciseName =  "Arnold Press",
        bodyPartName = "Shoulder"
    ),
    Exercises(
        exerciseName = "Barbell Shoulder Press",
        bodyPartName = "Shoulder"
    ),
    Exercises(
        exerciseName = "Barbell Upright Row",
        bodyPartName = "Shoulder"
    ),
    Exercises(
        exerciseName = "Cable Face Pulls",
        bodyPartName = "Shoulder"
    ),
    Exercises(
        exerciseName = "Cable Front Raises",
        bodyPartName = "Shoulder"
    ),
    Exercises(
        exerciseName = "Cable Rear Delt Fly",
        bodyPartName = "Shoulder"
    ),
    Exercises(
        exerciseName = "Cable Side Lateral Raise",
        bodyPartName = "Shoulder"
    ),
    Exercises(
        exerciseName = "Dumbbell Front Raises",
        bodyPartName = "Shoulder"
    ),
    Exercises(
        exerciseName = "Dumbbell Rear Delt Fly",
        bodyPartName = "Shoulder"
    ),
    Exercises(
        exerciseName = "Dumbbell Shoulder Press",
        bodyPartName = "Shoulder"
    ),
    Exercises(
        exerciseName = "Dumbbell Side Lateral Raise",
        bodyPartName = "Shoulder"
    ),
    Exercises(
        exerciseName = "Machine Shoulder Press",
        bodyPartName = "Shoulder"
    ),
    Exercises(
        exerciseName = "Machine Side Lateral Raise",
        bodyPartName = "Shoulder"
    ),
    Exercises(
        exerciseName = "Reverse Peck Deck Fly",
        bodyPartName = "Shoulder"
    ),



    Exercises(
        exerciseName = "JM Press",
        bodyPartName = "Triceps"
    ),
    Exercises(
        exerciseName = "Barbell Skull Crusher",
        bodyPartName = "Triceps"
    ),
    Exercises(
        exerciseName = "Barbell Triceps Extension",
        bodyPartName = "Triceps"
    ),
    Exercises(
        exerciseName = "Cable Triceps Extension",
        bodyPartName = "Triceps"
    ),
    Exercises(
        exerciseName = "Cable Triceps Push Down",
        bodyPartName = "Triceps"
    ),
    Exercises(
        exerciseName = "Dumbbell Skull Crusher",
        bodyPartName = "Triceps"
    ),
    Exercises(
        exerciseName = "Dumbbell Triceps Extension",
        bodyPartName = "Triceps"
    ),
    Exercises(
        exerciseName = "Machine Triceps Extension",
        bodyPartName = "Smith Machine JM Press"
    ),
    Exercises(
        exerciseName = "Smith Machine JM Press",
        bodyPartName = "Triceps"
    ),



    Exercises(
        exerciseName = "Barbell Curl",
        bodyPartName = "Biceps"
    ),
    Exercises(
        exerciseName = "Barbell Preacher Curl",
        bodyPartName = "Biceps"
    ),
    Exercises(
        exerciseName = "Barbell Reverse Curl",
        bodyPartName = "Biceps"
    ),
    Exercises(
        exerciseName = "Cable Curl",
        bodyPartName = "Biceps"
    ),
    Exercises(
        exerciseName = "Cable Hammer Curl",
        bodyPartName = "Biceps"
    ),
    Exercises(
        exerciseName = "Dumbbell Concentration Curl",
        bodyPartName = "Biceps"
    ),
    Exercises(
        exerciseName = "Dumbbell Curl",
        bodyPartName = "Biceps"
    ),
    Exercises(
        exerciseName = "Dumbbell Hammer Curl",
        bodyPartName = "Biceps"
    ),
    Exercises(
        exerciseName = "Dumbbell Preacher Curl",
        bodyPartName = "Biceps"
    ),
    Exercises(
        exerciseName = "Dumbbell Reverse Curl",
        bodyPartName = "Biceps"
    ),
    Exercises(
        exerciseName = "EZ Bar Curl",
        bodyPartName = "Biceps"
    ),
    Exercises(
        exerciseName = "EZ Bar Preacher Curl",
        bodyPartName = "Biceps"
    ),



    Exercises(
        exerciseName = "Cable Reverse Wrist Curl",
        bodyPartName = "Forearms"
    ),
    Exercises(
        exerciseName = "Cable Wrist Curl",
        bodyPartName = "Forearms"
    ),
    Exercises(
        exerciseName = "Dumbbell Reverse Wrist Curl",
        bodyPartName = "Forearms"
    ),
    Exercises(
        exerciseName = "Dumbbell Wrist Curl",
        bodyPartName = "Forearms"
    ),



    Exercises(
        exerciseName = "Assisted Pull Up",
        bodyPartName = "Back"
    ),
    Exercises(
        exerciseName = "Barbell Row",
        bodyPartName = "Back"
    ),
    Exercises(
        exerciseName = "Kneeling Single Arm Cable Pull Down",
        bodyPartName = "Back"
    ),
    Exercises(
        exerciseName = "Landmine Barbell Row",
        bodyPartName = "Back"
    ),
    Exercises(
        exerciseName = "Lat Pull Down",
        bodyPartName = "Back"
    ),
    Exercises(
        exerciseName = "Seated Cable Row",
        bodyPartName = "Back"
    ),
    Exercises(
        exerciseName = "Machine Pull Down",
        bodyPartName = "Back"
    ),
    Exercises(
        exerciseName = "Machine Row",
        bodyPartName = "Back"
    ),
    Exercises(
        exerciseName = "Pull Up",
        bodyPartName = "Back"
    ),
    Exercises(
        exerciseName = "Single Arm Dumbbell Row",
        bodyPartName = "Back"
    ),
    Exercises(
        exerciseName = "Smith Machine Row",
        bodyPartName = "Back"
    ),



    Exercises(
        exerciseName = "Barbell Shrugs",
        bodyPartName = "Traps"
    ),
    Exercises(
        exerciseName = "Cable Shrugs",
        bodyPartName = "Traps"
    ),
    Exercises(
        exerciseName = "Dumbbell Shrugs",
        bodyPartName = "Traps"
    ),



    Exercises(
        exerciseName = "Back Extension",
        bodyPartName = "Lower back"
    ),
    Exercises(
        exerciseName = "Barbell Good Morning",
        bodyPartName = "Lower back"
    ),
    Exercises(
        exerciseName = "Deadlift",
        bodyPartName = "Lower back"
    ),
    Exercises(
        exerciseName = "Machine Back Extension",
        bodyPartName = "Lower back"
    ),
    Exercises(
        exerciseName = "Sumo Deadlift",
        bodyPartName = "Lower back"
    ),



    Exercises(
        exerciseName = "Assisted Dip",
        bodyPartName = "Chest"
    ),
    Exercises(
        exerciseName = "Barbell Bench Press",
        bodyPartName = "Chest"
    ),
    Exercises(
        exerciseName = "Cable Fly",
        bodyPartName = "Chest"
    ),
    Exercises(
        exerciseName = "Dip",
        bodyPartName = "Chest"
    ),
    Exercises(
        exerciseName = "Dumbbell Bench Press",
        bodyPartName = "Chest"
    ),
    Exercises(
        exerciseName = "Dumbbell Fly",
        bodyPartName = "Chest"
    ),
    Exercises(
        exerciseName = "Incline Barbell Bench Press",
        bodyPartName = "Chest"
    ),
    Exercises(
        exerciseName = "Incline Dumbbell Bench Press",
        bodyPartName = "Chest"
    ),
    Exercises(
        exerciseName = "Incline Machine Chest Press",
        bodyPartName = "Chest"
    ),
    Exercises(
        exerciseName = "Incline Smith Machine Bench Press",
        bodyPartName = "Chest"
    ),
    Exercises(
        exerciseName = "Machine Chest Press",
        bodyPartName = "Chest"
    ),
    Exercises(
        exerciseName = "Machine Dip",
        bodyPartName = "Chest"
    ),
    Exercises(
        exerciseName = "Peck Deck Fly",
        bodyPartName = "Chest"
    ),
    Exercises(
        exerciseName = "Seated Cable Fly",
        bodyPartName = "Chest"
    ),
    Exercises(
        exerciseName = "Smith Machine Bench Press",
        bodyPartName = "Chest"
    ),



    Exercises(
        exerciseName = "Barbell Romanian Deadlift",
        bodyPartName = "hamstrings"
    ),
    Exercises(
        exerciseName = "Dumbbell Romanian Deadlift",
        bodyPartName = "hamstrings"
    ),
    Exercises(
        exerciseName = "Lying Hamstring Curl",
        bodyPartName = "hamstrings"
    ),
    Exercises(
        exerciseName = "Seated Hamstring Curl",
        bodyPartName = "hamstrings"
    ),
    Exercises(
        exerciseName = "Smith Machine Romanian Deadlift",
        bodyPartName = "hamstrings"
    ),



    Exercises(
        exerciseName = "Barbell Hip Thrust",
        bodyPartName = "glutes"
    ),
    Exercises(
        exerciseName = "Barbell Lunge",
        bodyPartName = "glutes"
    ),
    Exercises(
        exerciseName = "Cable Glute Kickback",
        bodyPartName = "glutes"
    ),
    Exercises(
        exerciseName = "Dumbbell Bulgarian Split Squats",
        bodyPartName = "glutes"
    ),
    Exercises(
        exerciseName = "Dumbbell Lunge",
        bodyPartName = "glutes"
    ),
    Exercises(
        exerciseName = "Hip Abductor",
        bodyPartName = "glutes"
    ),
    Exercises(
        exerciseName = "Kas Glute Bridge",
        bodyPartName = "glutes"
    ),
    Exercises(
        exerciseName = "Smith Machine Bulgarian Split Squat",
        bodyPartName = "glutes"
    ),



    Exercises(
        exerciseName = "Barbell Calf Raise",
        bodyPartName = "Calf Calves"
    ),
    Exercises(
        exerciseName = "Leg Press Calf Raise",
        bodyPartName = "Calf Calves"
    ),
    Exercises(
        exerciseName = "Machine Calf Raise",
        bodyPartName = "Calf Calves"
    ),
    Exercises(
        exerciseName = "Smith Machine Calf Raise",
        bodyPartName = "Calf Calves"
    ),



    Exercises(
        exerciseName = "Cable Crunch",
        bodyPartName = "abs abdoninals"
    ),
    Exercises(
        exerciseName = "Cable Crunch",
        bodyPartName = "Hanging Leg Raise",
    ),
    Exercises(
        exerciseName = "Cable Crunch",
        bodyPartName = "Lying Leg Raise",
    ),
    Exercises(
        exerciseName = "Cable Crunch",
        bodyPartName = "Machine Seated Crunch",
    ),
    Exercises(
        exerciseName = "Cable Crunch",
        bodyPartName = "Sit Up"
    ),







    )
