package com.example.tugas1

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tugas1.Navigation.Screen
import com.example.tugas1.component.BottomBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MakananApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
){
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Makanan Khas Indonesia")
                }
            )
        },
        bottomBar = {
            BottomBar(navController)
        },
        modifier = modifier
    ) {
            contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Makanan.route,
            modifier = modifier.padding(contentPadding)
        ){
            composable(Screen.Makanan.route){
                MakananScreen(navController)
            }
            composable(Screen.About.route){
                AboutScreen()
            }
        }
    }
}
