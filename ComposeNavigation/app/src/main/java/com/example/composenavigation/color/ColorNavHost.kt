package com.example.composenavigation.color

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.composenavigation.composables.Bulb
import com.example.composenavigation.composables.DataList
import com.example.composenavigation.composables.list

@Composable
fun ColorNavHost(
    navController : NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "Start"
    ) {
        composable(
            route = "Next/{red}/{blue}/{green}",
            arguments = listOf(
                navArgument("red") { type = NavType.FloatType },
                navArgument("blue")  { type = NavType.FloatType },
                navArgument("green")  { type = NavType.FloatType }
            )
        ) {
            val red = it.arguments?.getFloat("red") ?: 0f
            val blue = it.arguments?.getFloat("blue") ?: 0f
            val green = it.arguments?.getFloat("green") ?: 0f
            ColorView(red = red, blue = blue, green = green)
        }

        composable("Start" ) {
            View(navCon = navController)
        }
    }
}