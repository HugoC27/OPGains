package com.example.opgains

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*


data class Exercise(
    val name: String,
    val musName: String,
    var sets: Int,
    var repsList: MutableList<Int>,
    var weightList: MutableList<Double>
){


}
