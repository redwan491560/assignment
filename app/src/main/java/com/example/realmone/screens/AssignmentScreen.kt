package com.example.realmone.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.realmone.Screens
import com.example.realmone.volkorn

@Composable
fun AssignmentScreen(navController: NavHostController) {

    Column(
        Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
            .systemBarsPadding(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Assignments", fontSize = 18.sp, fontFamily = volkorn)
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            OutlinedButton(shape = RoundedCornerShape(8.dp), onClick = {
                navController.navigate(Screens.FirstScreen.name)
            }) {
                Text(text = "Assignment 1", fontFamily = volkorn)
            }
            Spacer(modifier = Modifier.width(20.dp))

            OutlinedButton(shape = RoundedCornerShape(8.dp),onClick = {
                navController.navigate(Screens.SecondScreen.name)
            }) {
                Text(text = "Assignment 2", fontFamily = volkorn)
            }
        }
        Row {
            OutlinedButton(shape = RoundedCornerShape(8.dp),onClick = {
                navController.navigate(Screens.ThirdScreen.name)
            }) {
                Text(text = "Assignment 3", fontFamily = volkorn)
            }
            Spacer(modifier = Modifier.width(20.dp))

            OutlinedButton(shape = RoundedCornerShape(8.dp),onClick = {
                navController.navigate(Screens.FourthScreen.name)
            }) {
                Text(text = "Assignment 4", fontFamily = volkorn)
            }

        }
        Row {
            OutlinedButton(shape = RoundedCornerShape(8.dp),onClick = {
                navController.navigate(Screens.FifthScreen.name)
            }) {
                Text(text = "Assignment 5", fontFamily = volkorn)
            }
            Spacer(modifier = Modifier.width(20.dp))
            OutlinedButton(shape = RoundedCornerShape(8.dp),onClick = {
                navController.navigate(Screens.SixthScreen.name)
            }) {
                Text(text = "Assignment 6", fontFamily = volkorn)
            }

        }
        Row {
            OutlinedButton(shape = RoundedCornerShape(8.dp),enabled = false, onClick = {
                navController.navigate(Screens.SeventhScreen.name)
            }) {
                Text(text = "Assignment 7", fontFamily = volkorn)
            }
            Spacer(modifier = Modifier.width(20.dp))

            OutlinedButton(shape = RoundedCornerShape(8.dp),enabled = false, onClick = {
                navController.navigate(Screens.SeventhScreen.name)
            }) {
                Text(text = "Assignment 8", fontFamily = volkorn)
            }

        }


    }
}

@Preview(showSystemUi = true)
@Composable
private fun ASdsbdaf() {
    AssignmentScreen(navController = rememberNavController())
}