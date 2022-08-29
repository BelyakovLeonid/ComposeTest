package com.belyakov.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.belyakov.composetest.ui.theme.ComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    var isNeedToShowOnboarding by rememberSaveable {
        mutableStateOf(true)
    }

    ComposeTestTheme {
        if (isNeedToShowOnboarding) {
            OnboardingScreen {
                isNeedToShowOnboarding = false
            }
        } else {
            ContentScreen(
                names = listOf(
                    "A",
                    "B",
                    "C"
                )
            )
        }
    }

}

@Preview(
    showBackground = true,
    widthDp = 320
)
@Composable
fun PreviewNightWidth320() {
    MyApp()
}