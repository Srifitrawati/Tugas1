package com.example.tugas1.Navigation

sealed class Screen(val route: String) {
    data object Makanan : Screen ("makanan")
    data object About : Screen ("about")
    data object Detail : Screen ("detail")
}