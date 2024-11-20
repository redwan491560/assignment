package com.example.realmone.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.realmone.R
import com.example.realmone.Screens
import com.example.realmone.volkorn

@Composable
fun AssignmentScreen(navController: NavHostController) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    Column(
        Modifier
            .fillMaxWidth()
            .systemBarsPadding(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedButton(modifier = Modifier.padding(10.dp, 20.dp), onClick = {
            Toast.makeText(context, "You've liked Leading University", Toast.LENGTH_SHORT).show()
        }) {
            Text(
                text = "Toast?",
                fontFamily = volkorn, fontSize = 20.sp
            )
        }


        Spacer(modifier = Modifier.height(40.dp))

        OutlinedCard(
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img), contentDescription = null,
                modifier = Modifier
                    .padding(15.dp)
                    .size(120.dp),
            )
        }
        Text(
            text = "Leading University",
            textDecoration = TextDecoration.Underline,
            fontFamily = volkorn,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(40.dp))
        Row {
            OutlinedButton(onClick = {
                navController.navigate(Screens.SecondScreen.name)
            }) {
                Text(text = "Assignment 2", fontFamily = volkorn)
            }
            Spacer(modifier = Modifier.width(20.dp))
            OutlinedButton(onClick = {
                navController.navigate(Screens.ThirdScreen.name)
            }) {
                Text(text = "Assignment 3", fontFamily = volkorn)
            }
        }
        Row {
            OutlinedButton(onClick = {
                navController.navigate(Screens.FourthScreen.name)
            }) {
                Text(text = "Assignment 4", fontFamily = volkorn)
            }
            Spacer(modifier = Modifier.width(20.dp))
            OutlinedButton(onClick = {
                navController.navigate(Screens.FifthScreen.name)
            }) {
                Text(text = "Assignment 5", fontFamily = volkorn)
            }
        }


    }
}

@Preview(showSystemUi = true)
@Composable
private fun ASdsbdaf() {
    AssignmentScreen(navController = rememberNavController())
}