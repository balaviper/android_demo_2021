package com.example.composenavigation.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun Profile(navCon : NavController) {
    Column {
       Button(onClick = { navCon.navigate("grt/mymsgsldkfskfhksdfjsdkfjh sjdfdhs")  }) {
            Text(text = "Greetings")
        }
    }
}