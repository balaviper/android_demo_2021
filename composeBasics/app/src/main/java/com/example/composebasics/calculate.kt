package com.example.composebasics


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.lang.Exception
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
internal fun Calculator() {

    var result by remember { mutableStateOf("") }
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }

    Column {

        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().border(2.dp, Color(0xFF_FF_00_00))
        ) {
            Text(
                text = result,
                style = TextStyle(
                    fontSize = 30.sp,
                )
            )
        }

        Row {
            TextField(
                value =  "$num1",
                onValueChange = { num1 = it},
                label = { Text("Number 1") },
                modifier = Modifier.padding(top = 10.dp)
            )
        }
        Row {
            TextField(
                value =  "$num2",
                onValueChange = { num2 = it },
                label = { Text("Number 2") },
                modifier = Modifier.padding(top = 10.dp)
            )
        }

        Row {
            Button(onClick = {
                try {
                    result = (num1.toInt() + num2.toInt()).toString()
                }
                catch(e: Exception){
                    result = "Enter a valid number"
                }
            }) {
                Text(
                    text = "Addition",
                    style = TextStyle()
                )
            }
        }
    }
}