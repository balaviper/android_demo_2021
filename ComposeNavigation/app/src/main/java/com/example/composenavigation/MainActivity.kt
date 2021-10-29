package com.example.composenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.composenavigation.color.ColorNavHost



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            //View(navController) 
            ColorNavHost(navController = navController)
            //ColorView(red = 1f, blue = 0.5f, green = 0.4f)
        }
    }
}
