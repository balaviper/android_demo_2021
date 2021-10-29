package com.example.composebasics

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasics.ui.theme.ComposeBasicsTheme

@Composable
fun simpleText(){
        Column {
            for(i in 0..7) {
            Row{
                Text(
                    text = "Bala  Viper",
                    fontSize = 38.sp,
                    modifier = Modifier.padding(5.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_user1),
                    contentDescription = "User icon",
                    modifier = Modifier
                        .height(35.dp)
                        .border(2.dp, Color.Black)
                        .fillMaxWidth()
                        .padding(15.dp,0.dp)
                )

            }
        }
    }
   
}

@Preview(showBackground = true)
@Composable
fun simplePreview() {
    ComposeBasicsTheme {
        //Greeting("Android")
        simpleText()
    }
}