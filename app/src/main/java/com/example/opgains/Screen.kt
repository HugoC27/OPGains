package com.example.opgains

const val ARGUMENT_CALVES = "calves"
const val ARGUMENT_THIGH = "thigh"
const val ARGUMENT_HIP_ABDUCTOR = "hip_abductor"
const val ARGUMENT_ABS = "abs"
const val ARGUMENT_OBLIQUE = "oblique"
const val ARGUMENT_LATS = "lats"
const val ARGUMENT_CHEST = "chest"
const val ARGUMENT_TRAPS = "traps"
const val ARGUMENT_NECK = "neck"
const val ARGUMENT_SHOULDER = "shoulder"
const val ARGUMENT_TRICEPS = "triceps"
const val ARGUMENT_BICEPS = "biceps"
const val ARGUMENT_FOREARMS = "forearms"
const val ARGUMENT_HAMSTRINGS = "hamstrings"
const val ARGUMENT_GLUTES = "glutes"
const val ARGUMENT_LOWERBACK = "lowerback"

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object Tracker: Screen(route = "tracker_screen")
    object Contact: Screen(route = "contact_screen")
    object Settings: Screen(route = "settings_screen")
    object VisualizationFront: Screen(route = "visualization_front_screen?" +
            "calves={calves}&" +
            "thigh={thigh}&" +
            "hip_abductor={hip_abductor}&" +
            "abs={abs}&" +
            "oblique={oblique}&" +
            "lats={lats}&" +
            "chest={chest}&" +
            "traps={traps}&" +
            "neck={neck}&" +
            "shoulder={shoulder}&" +
            "triceps={triceps}&" +
            "biceps={biceps}&" +
            "forearms={forearms}&" +
            "hamstrings={hamstrings}&" +
            "glutes={glutes}&" +
            "lowerback={lowerback}"
    ) {
        fun passAllScores(
            calves: Int = 0,
            thigh: Int = 0,
            hip_abductor: Int = 0,
            abs: Int = 0,
            oblique: Int = 0,
            lats: Int = 0,
            chest: Int = 0,
            traps: Int = 0,
            neck: Int = 0,
            shoulder: Int = 0,
            triceps: Int = 0,
            biceps: Int = 0,
            forearms: Int = 0,
            hamstrings: Int = 0,
            glutes: Int = 0,
            lowerback: Int = 0
        ): String {
            return "visualization_front_screen?" +
                    "calves=$calves&" +
                    "thigh=$thigh&" +
                    "hip_abductor=$hip_abductor&" +
                    "abs=$abs&" +
                    "oblique=$oblique&" +
                    "lats=$lats&" +
                    "chest=$chest&" +
                    "traps=$traps&" +
                    "neck=$neck&" +
                    "shoulder=$shoulder&" +
                    "triceps=$triceps&" +
                    "biceps=$biceps&" +
                    "forearms=$forearms&" +
                    "hamstrings=$hamstrings&" +
                    "glutes=$glutes&" +
                    "lowerback=$lowerback"
        }
    }
    object VisualizationBack: Screen(route = "visualization_back_screen?" +
            "calves={calves}&" +
            "thigh={thigh}&" +
            "hip_abductor={hip_abductor}&" +
            "abs={abs}&" +
            "oblique={oblique}&" +
            "lats={lats}&" +
            "chest={chest}&" +
            "traps={traps}&" +
            "neck={neck}&" +
            "shoulder={shoulder}&" +
            "triceps={triceps}&" +
            "biceps={biceps}&" +
            "forearms={forearms}&" +
            "hamstrings={hamstrings}&" +
            "glutes={glutes}&" +
            "lowerback={lowerback}"
    ) {
        fun passAllScores(
            calves: Int = 0,
            thigh: Int = 0,
            hip_abductor: Int = 0,
            abs: Int = 0,
            oblique: Int = 0,
            lats: Int = 0,
            chest: Int = 0,
            traps: Int = 0,
            neck: Int = 0,
            shoulder: Int = 0,
            triceps: Int = 0,
            biceps: Int = 0,
            forearms: Int = 0,
            hamstrings: Int = 0,
            glutes: Int = 0,
            lowerback: Int = 0
        ): String {
            return "visualization_back_screen?" +
                    "calves=$calves&" +
                    "thigh=$thigh&" +
                    "hip_abductor=$hip_abductor&" +
                    "abs=$abs&" +
                    "oblique=$oblique&" +
                    "lats=$lats&" +
                    "chest=$chest&" +
                    "traps=$traps&" +
                    "neck=$neck&" +
                    "shoulder=$shoulder&" +
                    "triceps=$triceps&" +
                    "biceps=$biceps&" +
                    "forearms=$forearms&" +
                    "hamstrings=$hamstrings&" +
                    "glutes=$glutes&" +
                    "lowerback=$lowerback"
        }
    }
    object Exercise: Screen(route = "exercise_screen")
}
