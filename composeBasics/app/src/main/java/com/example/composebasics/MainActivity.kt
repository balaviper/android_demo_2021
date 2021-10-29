package com.example.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.example.composebasics.ui.theme.ComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val friends = listOf<Friend>(
            Friend("Abc", "9666666", "@abc"),
            Friend("Pqr", "9894313", "@pqr"),
            Friend("Lmn", "6346523748", "@lmn"),
            Friend("Abc", "9666666", "@abc"),
            Friend("Pqr", "9894313", "@pqr"),
            Friend("Lmn", "6346523748", "@lmn"),
            Friend("Abc", "9666666", "@abc"),
            Friend("Pqr", "9894313", "@pqr"),
            Friend("Lmn", "6346523748", "@lmn"),
            Friend("Abc", "9666666", "@abc"),
            Friend("Pqr", "9894313", "@pqr"),
            Friend("Lmn", "6346523748", "@lmn"),
            Friend("Abc", "9666666", "@abc"),
            Friend("Pqr", "9894313", "@pqr"),
            Friend("Lmn", "6346523748", "@lmn"),
            Friend("Abc", "9666666", "@abc"),
            Friend("Pqr", "9894313", "@pqr"),
            Friend("Lmn", "6346523748", "@lmn"),
            Friend("Lmn", "6346523748", "@lmn"),
            Friend("Abc", "9666666", "@abc"),
            Friend("Pqr", "9894313", "@pqr"),
            Friend("Lmn", "6346523748", "@lmn"),
            Friend("Lmn", "6346523748", "@lmn"),
            Friend("Abc", "9666666", "@abc"),
            Friend("Pqr", "9894313", "@pqr"),
            Friend("Lmn", "6346523748", "@lmn"),
            Friend("Lmn", "6346523748", "@lmn"),
            Friend("Abc", "9666666", "@abc"),
            Friend("Pqr", "9894313", "@pqr"),
            Friend("Lmn", "6346523748", "@lmn"),
            Friend("Lmn", "6346523748", "@lmn"),
            Friend("Abc", "9666666", "@abc"),
            Friend("Pqr", "9894313", "@pqr"),
            Friend("Lmn", "6346523748", "@lmn"),
            Friend("Lmn", "6346523748", "@lmn"),
            Friend("Abc", "9666666", "@abc"),
            Friend("Pqr", "9894313", "@pqr"),
            Friend("Lmn", "6346523748", "@lmn")
        )

        setContent {
            ComposeBasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    //Greeting("Android")
                    //Calculator()
                    //OptimizedCalculator()
                    FriendList(friends = friends)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        textDecoration = TextDecoration.Underline
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBasicsTheme {
        Calculator()
    }
}