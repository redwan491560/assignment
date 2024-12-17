package com.example.realmone.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.realmone.R
import com.example.realmone.ui.theme.darkMode
import com.example.realmone.volkorn


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SecondScreen() {
    val userType = listOf("Type1", "Type2", "Type3", "Type4")
    var info by remember {
        mutableStateOf("Type1")
    }
    var isChecked by remember { mutableStateOf(false) }
    val optionsList = listOf("Option 1", "Option 2", "Option 3", "Option 4")
    var selectedOption by remember { mutableStateOf("Option 1") }
    var rating by remember { mutableIntStateOf(0) }
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    var isSwitchedOn by remember { mutableStateOf(false) }

    Scaffold(
        Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(
                    if (isSwitchedOn) darkMode else Color.White
                )
                .padding(8.dp, 10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Assignment 2", fontFamily = volkorn, fontSize = 20.sp)
            // checkbox
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp, 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = { isChecked = it }
                )
                Text(
                    text = "Check the box to see the state",
                    fontSize = 16.sp,
                    fontFamily = volkorn
                )
            }

            // radio button
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp, 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Column {
                    optionsList.forEachIndexed { _, s ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = (selectedOption == s),
                                // if selected button is equal to the option then the state is selected
                                onClick = {
                                    selectedOption = s
                                }
                            )
                            Text(s, fontFamily = volkorn, fontSize = 14.sp)
                        }
                    }

                }
            }
            // rating bar
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp, 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                (1..5).forEach { star ->
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = if (star <= rating) Color.Black else Color.Gray,
                        modifier = Modifier
                            .size(30.dp)
                            .clickable {
                                rating = star
                            }
                    )
                }
                Text(
                    text = "Rating: $rating",
                    fontFamily = volkorn,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(25.dp, 3.dp)
                )
            }
            // slider
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Column {
                    Slider(
                        value = sliderPosition,
                        onValueChange = { sliderPosition = it },
                        valueRange = 0f..100f
                    )
                    Text(
                        text = "Value: ${sliderPosition.toInt()}",
                        fontFamily = volkorn,
                        fontSize = 18.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            }
            // switch
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Switch(
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color.White,
                            uncheckedThumbColor = Color.White
                        ),
                        modifier = Modifier.width(40.dp),
                        checked = isSwitchedOn,
                        onCheckedChange = { isSwitchedOn = it },
                        thumbContent = {
                            if (isSwitchedOn) {
                                Image(
                                    painter = painterResource(id = R.drawable.night_mode),
                                    contentDescription = null,
                                    modifier = Modifier.size(SwitchDefaults.IconSize),
                                )
                            } else {
                                Image(
                                    painter = painterResource(id = R.drawable.day_mode),
                                    contentDescription = null,
                                    modifier = Modifier.size(SwitchDefaults.IconSize),
                                )
                            }
                        }
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        text = if (isSwitchedOn) "ON" else "OFF",
                        fontFamily = volkorn,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }

            // dropdown menu
            Row(modifier = Modifier.padding(bottom = 20.dp)) {
                var expanded by remember { mutableStateOf(false) }

                ExposedDropdownMenuBox(
                    expanded = expanded, onExpandedChange = {
                        expanded = !expanded
                    }, modifier = Modifier
                        .width(250.dp)
                ) {
                    Card(
                        shape = RoundedCornerShape(8.dp),
                        elevation = CardDefaults.cardElevation(8.dp),

                        ) {
                        Row(
                            modifier = Modifier
                                .padding(15.dp, 10.dp)
                                .menuAnchor(MenuAnchorType.SecondaryEditable, true),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = info,
                                fontSize = 18.sp,
                                fontFamily = volkorn,
                                modifier = Modifier.weight(8f), maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                            )
                            Icon(
                                imageVector = Icons.Outlined.ArrowDropDown,
                                contentDescription = null
                            )

                        }
                    }
                    ExposedDropdownMenu(
                        matchTextFieldWidth = true,
                        shape = RoundedCornerShape(10.dp),
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        scrollState = rememberScrollState()
                    ) {

                        userType.forEachIndexed { index, string ->
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = string,
                                        fontFamily = volkorn,
                                        fontSize = 14.sp
                                    )
                                },
                                onClick = {
                                    info = userType[index] // Update selected item
                                    expanded = false // Close dropdown after selection
                                },
                                contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                            )

                        }
                    }

                }
            }
            Spacer(modifier = Modifier.height(10.dp))

            Card(
                elevation = CardDefaults.cardElevation(6.dp),
                modifier = Modifier.wrapContentSize(),
                shape = RoundedCornerShape(6.dp)
            ) {
                Column(
                    modifier = Modifier.padding(15.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        Text(
                            text = "Checkbox:",
                            fontSize = 16.sp,
                            fontFamily = volkorn
                        )
                        Text(
                            text = if (isChecked) "Checked" else "Unchecked",
                            fontSize = 16.sp,
                            fontFamily = volkorn
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        Text(
                            text = "Radio Button:",
                            fontSize = 16.sp,
                            fontFamily = volkorn
                        )
                        Text(
                            text = selectedOption,
                            fontSize = 16.sp,
                            fontFamily = volkorn
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        Text(
                            text = "Rating:",
                            fontSize = 16.sp,
                            fontFamily = volkorn,
                        )
                        Text(
                            text = "$rating",
                            fontFamily = volkorn,
                            fontSize = 16.sp,
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        Text(
                            text = "Switch:",
                            fontSize = 16.sp,
                            fontFamily = volkorn
                        )
                        Text(
                            text = if (isSwitchedOn) "ON" else "OFF",
                            fontFamily = volkorn,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        Text(
                            text = "Slider:",
                            fontSize = 16.sp,
                            fontFamily = volkorn
                        )
                        Text(
                            text = "${sliderPosition.toInt()}",
                            fontFamily = volkorn,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        Text(
                            text = "DropDownMenu:",
                            fontSize = 16.sp,
                            fontFamily = volkorn
                        )
                        Text(
                            text = info,
                            fontFamily = volkorn,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

        }


    }


}


@Preview(showSystemUi = true)
@Composable
private fun Ahjbfdhf() {
    SecondScreen()
}