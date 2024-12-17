package com.example.realmone.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.realmone.ComposablesDesign.Companion.TextDesign
import com.example.realmone.Screens
import com.example.realmone.ui.theme.login
import com.example.realmone.ui.theme.loginCard
import com.example.realmone.ui.theme.volkorn
import com.example.realmone.viewmodel.DatabaseViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ThirdScreen(navHostController: NavHostController, databaseViewModel: DatabaseViewModel) {

    val context = LocalContext.current
    var expandedPass by remember {
        mutableStateOf(false)
    }
    var expandedEmail by remember {
        mutableStateOf(false)
    }
    var expandedPhone by remember {
        mutableStateOf(false)
    }


    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(15.dp, 30.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Signup to App",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontFamily = volkorn,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(30.dp))

            TextField(
                value = databaseViewModel.username.value,
                onValueChange = {
                    databaseViewModel.username.value = it
                },
                textStyle = TextStyle(
                    fontFamily = volkorn, fontSize = 14.sp
                ),
                singleLine = true,
                placeholder = {
                    TextDesign(text = "Username", size = 14)

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(0.dp, 5.dp)
                    .clip(RoundedCornerShape(10.dp)),
                shape = RoundedCornerShape(6.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
                ),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedPlaceholderColor = Color.Black,
                    unfocusedPlaceholderColor = Color.Black,
                    focusedIndicatorColor = Color.Blue,
                    unfocusedIndicatorColor = Color.Black,
                    focusedContainerColor = Color(login.value),
                    unfocusedContainerColor = Color(loginCard.value)
                )
            )
            Row {

                TextField(
                    value = databaseViewModel.phone.value,
                    onValueChange = {
                        databaseViewModel.phone.value = it
                    },
                    textStyle = TextStyle(
                        fontFamily = volkorn, fontSize = 14.sp
                    ),
                    singleLine = true,
                    placeholder = {
                        TextDesign(text = "Contact", size = 14)
                    },
                    modifier = Modifier
                        .height(60.dp)
                        .padding(0.dp, 5.dp)
                        .weight(8f)
                        .clip(RoundedCornerShape(10.dp)),
                    shape = RoundedCornerShape(6.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
                    ),
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        focusedPlaceholderColor = Color.Black,
                        unfocusedPlaceholderColor = Color.Black,
                        focusedIndicatorColor = Color.Blue,
                        unfocusedIndicatorColor = Color.Black,
                        focusedContainerColor = Color(login.value),
                        unfocusedContainerColor = Color(loginCard.value)
                    )
                )

            }
            if (expandedPhone) {
                TextDesign(
                    text = "phone number should be 11 digit",
                    color = Color.Red, size = 14
                )
            }
            TextField(
                value = databaseViewModel.email.value,
                onValueChange = {
                    databaseViewModel.email.value = it
                },
                textStyle = TextStyle(
                    fontFamily = volkorn, fontSize = 14.sp
                ),
                singleLine = true,
                placeholder = {
                    Text(
                        text = "your_email@gmail.com",
                        fontFamily = volkorn,
                        fontSize = 14.sp,
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(0.dp, 5.dp)
                    .clip(RoundedCornerShape(10.dp)),
                shape = RoundedCornerShape(6.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
                ),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedPlaceholderColor = Color.Black,
                    unfocusedPlaceholderColor = Color.Black,
                    focusedIndicatorColor = Color.Blue,
                    unfocusedIndicatorColor = Color.Black,
                    focusedContainerColor = Color(login.value),
                    unfocusedContainerColor = Color(loginCard.value)
                )
            )
            if (expandedEmail) {
                TextDesign(
                    text = "Email should be email@domain.com",
                    color = Color.Red, size = 14
                )
            }
            TextField(
                value = databaseViewModel.password.value,
                onValueChange = {
                    databaseViewModel.password.value = it
                },
                textStyle = TextStyle(
                    fontFamily = volkorn, fontSize = 14.sp
                ),
                singleLine = true,
                placeholder = {
                    Text(
                        text = "Password",
                        fontFamily = volkorn,
                        fontSize = 14.sp,
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(0.dp, 5.dp)
                    .clip(RoundedCornerShape(10.dp)),
                shape = RoundedCornerShape(6.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
                ),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedPlaceholderColor = Color.Black,
                    unfocusedPlaceholderColor = Color.Black,
                    focusedIndicatorColor = Color.Blue,
                    unfocusedIndicatorColor = Color.Black,
                    focusedContainerColor = Color(login.value),
                    unfocusedContainerColor = Color(loginCard.value)
                )
            )
            if (expandedPass) {
                Column {
                    TextDesign(text = "- Has to be more than 8 digit")
                    TextDesign(text = "- Use Capital and small letter")
                    TextDesign(
                        text = "- must have 1 uppercase, 1 lowercase letter",
                    )
                    TextDesign(
                        text = "- Have one digit, and one special character",
                    )

                }
            }


            Card(elevation = CardDefaults.cardElevation(8.dp),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.clickable {
                    if (databaseViewModel.username.value.isNotEmpty()) {
                        if (databaseViewModel.password.value.isNotEmpty() &&
                            databaseViewModel.validatePass(databaseViewModel.password.value)
                        ) {
                            if (databaseViewModel.validateContact(databaseViewModel.phone.value) && databaseViewModel.phone.value.isNotEmpty()) {
                                if (databaseViewModel.validateEmail(databaseViewModel.email.value) && databaseViewModel.email.value.isNotEmpty()) {
                                    navHostController.navigate(Screens.Validated.name)
                                } else {
                                    Toast.makeText(
                                        context, "Input not up to standard", Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }
                    } else {
                        Toast.makeText(
                            context, "Fill up all credentials", Toast.LENGTH_SHORT
                        ).show()
                    }
                }) {
                Text(
                    text = "Signup",
                    fontSize = 20.sp,
                    fontFamily = volkorn,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }


    }
}


@Preview(showSystemUi = true)
@Composable
private fun ASDggd() {
    ThirdScreen(rememberNavController(), DatabaseViewModel())
}