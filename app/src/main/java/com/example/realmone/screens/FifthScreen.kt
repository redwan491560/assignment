package com.example.realmone.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.realmone.ComposablesDesign
import com.example.realmone.programmingList
import com.example.realmone.volkorn


@Composable
fun FifthAssignmentScreen() {

    var expandedIndex by remember {
        mutableIntStateOf(-1)
    }


    Column(
        modifier = Modifier
            .systemBarsPadding()
            .padding(top = 40.dp, start = 15.dp),
        verticalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        ComposablesDesign.TextDesign(text = "Programming Languages", size = 18)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .systemBarsPadding()
                .padding(5.dp, 15.dp), verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            programmingList.forEachIndexed { index, str ->
                ListItemComposable(
                    text = str.text,
                    description = str.description,
                    isExpanded = index == expandedIndex
                ) {
                    expandedIndex = if (index == expandedIndex) -1 else index
                }
            }
        }
    }


}

data class Data(
    val text: String = "",
    val description: String = ""
)

@Composable
fun ListItemComposable(
    text: String,
    description: String,
    isExpanded: Boolean = false,
    onclick: () -> Unit
) {

    OutlinedCard(
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier.padding(5.dp),
        colors = CardDefaults.cardColors(
            Color(0xFFBDDEEC)
        )
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp, 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = text, fontSize = 20.sp, fontFamily = volkorn)
                Icon(
                    imageVector = if (isExpanded) Icons.Outlined.KeyboardArrowUp else Icons.Outlined.KeyboardArrowDown,
                    contentDescription = null,
                    Modifier
                        .size(25.dp)
                        .clickable {
                            onclick()
                        }
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            if (isExpanded) {
                Text(text = description, fontFamily = volkorn, fontSize = 16.sp)
            }

        }

    }

}

@Preview(showSystemUi = true)
@Composable
private fun Jf() {
    FifthAssignmentScreen()
}