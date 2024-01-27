package com.example.opgains

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*


data class Exercise(
    val name: String,
    var sets: Int,
    var reps: Int,
    var weight: Double
){


}
