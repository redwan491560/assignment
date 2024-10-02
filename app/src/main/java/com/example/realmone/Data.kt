package com.example.realmone

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

enum class Screens {
    MainScreen, ShowDB, AssignmentScreen, SecondScreen, ThirdScreen, Validated
}

val volkorn = FontFamily(
    Font(R.font.volkorn, weight = FontWeight.Normal)
)


class ComposablesDesign {
    companion object {
        @Composable
        fun TextDesign(text: String, size: Int = 16, color: Color = Color.Black) {
            Text(text = text, fontSize = size.sp, fontFamily = volkorn, color = color)

        }
    }
}