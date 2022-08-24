package com.belyakov.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test()
        }
    }
}

@Composable
fun ColorBox(
    modifier: Modifier = Modifier,
    onClick: (Color) -> Unit
) {
    Box(
        modifier = modifier
            .background(Color.Blue)
            .clickable {
                onClick(
                    Color(
                        Random.nextFloat(),
                        Random.nextFloat(),
                        Random.nextFloat(),
                        1F
                    )
                )
            }
    )
}

@Preview
@Composable
fun Test() {
    val state = remember {
        mutableStateOf(Color.Yellow)
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ColorBox(
            modifier = Modifier
                .fillMaxSize()
                .weight(1F)
        ) { newColor ->
            state.value = newColor
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(state.value)
                .weight(1F)
        )
    }
}