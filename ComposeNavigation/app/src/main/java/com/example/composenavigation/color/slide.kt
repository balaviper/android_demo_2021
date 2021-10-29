package com.example.composenavigation.color


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun MySliderDemo(): Float {
    var slide by remember { mutableStateOf(0f) }
    Slider(
        value = slide,
        valueRange = 0f..1f,
        onValueChange = { slide = it }
    )

    return slide
}

@Composable
fun View(navCon: NavController) {
    var red by remember { mutableStateOf(0f) }
    var blue by remember { mutableStateOf(0f) }
    var green by remember { mutableStateOf(0f) }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Row(Modifier.padding(16.dp)) {
            Column {
                //Text(text = "Red : ${red}")
                red = MySliderDemo()
                Text(
                    text = "Red Color Value : ${red*255}"
                )
            }
        }
        Row(Modifier.padding(16.dp)) {
            Column {
                //Text(text = "Blue : ${blue}")
                blue = MySliderDemo()
                Text(
                    text = "Blue Color Value : ${blue*255}"
                )
            }
        }
        Row(Modifier.padding(16.dp)) {
            Column {
                //Text(text = "Green : ${green}")
                green = MySliderDemo()
                Text(
                    text = " Green Color Value : ${green*255}"
                )
            }
        }

        Row(Modifier.padding(35.dp)) {
            Button(onClick = { navCon.navigate("Next/${red}/${blue}/${green}") }) {
                Text(text = "Next")
            }
        }

        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxHeight()
                .fillMaxWidth()
                .background(
                    Color(red, green, blue)
                )
        ){}
    }
}