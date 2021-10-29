package com.example.composenavigation.composables

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun AppNavHost(
    navController : NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "data-list"
    ) {
        composable(
            route = "bulb/{from}/{blb}",
            arguments = listOf(
                navArgument("from") { type = NavType.StringType },
                navArgument("blb")  { type = NavType.BoolType }
            )
        ) {
            val from = it.arguments?.getString("from") ?: "na"
            val blb = it.arguments?.getBoolean("blb") ?: false
            Bulb(from = from , blb = blb )
        }

        composable("data-list" ) {
            DataList(
                list,
                navCon = navController
            )
        }
    }
}