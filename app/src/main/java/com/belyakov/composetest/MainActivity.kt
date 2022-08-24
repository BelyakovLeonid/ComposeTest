package com.belyakov.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Green),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier
                        .background(color = Color.Blue)
                ) {
                    Text(
                        modifier = Modifier.height(100.dp),
                        text = "1Hello there!"
                    )
                    Text("11Hello there!")
                    Text("111Hello there!")
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.Magenta),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("1Hello there!")
                    Text("11Hello there!")
                    Text("111Hello there!")
                }
            }
        }
    }
}