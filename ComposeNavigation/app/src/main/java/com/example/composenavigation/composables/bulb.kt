package com.example.composenavigation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composenavigation.R


@Composable
fun Bulb(from : String, blb : Boolean) {
     var c by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp)
    ) {
        Text(
            text = from,
            modifier = Modifier
                .weight(0.3f)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 36.sp,
        )
        Image(

            painter = painterResource(id = if(blb) R.drawable.ic_blb_on else R.drawable.ic_blb_off),
            contentDescription = from,
            modifier = Modifier
                .weight(0.7f)
                .fillMaxWidth()
                .clickable {

                }
        )
    }
}