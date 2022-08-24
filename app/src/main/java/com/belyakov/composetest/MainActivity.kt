package com.belyakov.composetest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
                    .background(color = Color.Green)
                    .padding(5.dp)
                    .border(5.dp, Color.Black)
                    .padding(10.dp)
                    .border(8.dp, Color.Black)
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.clickable { Log.d("MyTag", "click") },
                    text = "1Hello there!"
                )
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                        .fillMaxWidth()
                        .background(Color.Black)
                )
                Text("11Hello there!")
                Text("111Hello there!")
            }
        }
    }
}