package com.example.composebasics

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composebasics.ui.theme.ComposeBasicsTheme


class InputDemo {
    companion object{
        @Composable
        fun InputLable(){
            var text by remember{ mutableStateOf("hello")}

            TextField(
                value = text,
                onValueChange = {text = it},
                label = { Text("Lable")} ,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}
