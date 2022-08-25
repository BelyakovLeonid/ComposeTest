package com.belyakov.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Main()
        }
    }

    @Composable
    fun Main() {
        val constraintSet = ConstraintSet {
            val firstBox = createRefFor("First")
            val secondBox = createRefFor("Second")
            val guideline = createGuidelineFromStart(0.7F)

            constrain(firstBox) {
                start.linkTo(parent.start)
                end.linkTo(guideline)
                top.linkTo(parent.top)
                bottom.linkTo(secondBox.top)
            }
            constrain(secondBox) {
                start.linkTo(parent.start)
                end.linkTo(guideline)
                top.linkTo(firstBox.bottom)
                bottom.linkTo(parent.bottom)
            }

            createVerticalChain(firstBox, secondBox, chainStyle = ChainStyle.Packed)
        }

        ConstraintLayout(
            modifier = Modifier.fillMaxSize(),
            constraintSet = constraintSet
        ) {
            Box(
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .background(Color.Yellow)
                    .layoutId("First")
            )
            Box(
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .background(Color.Green)
                    .layoutId("Second")
            )
        }
    }

    @Composable
    @Preview
    fun Test() {
        Main()
    }
}