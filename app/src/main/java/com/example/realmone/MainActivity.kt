package com.example.realmone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.realmone.screens.AssignmentScreen
import com.example.realmone.screens.SecondScreen
import com.example.realmone.ui.theme.RealmOneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            RealmOneTheme {
                App(navController)
            }
        }
    }
}


@Composable
fun App(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screens.AssignmentScreen.name) {
        composable(route = Screens.AssignmentScreen.name) {
            AssignmentScreen(navController)
        }
        composable(route = Screens.SecondScreen.name) {
            SecondScreen()
        }

    }

}


@Preview(showSystemUi = true)
@Composable
private fun Jhdfd() {
    AssignmentScreen(rememberNavController())
}