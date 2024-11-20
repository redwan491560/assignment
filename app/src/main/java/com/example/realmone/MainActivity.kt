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
import com.example.realmone.screens.FifthAssignmentScreen
import com.example.realmone.screens.FourthScreen
import com.example.realmone.screens.SecondScreen
import com.example.realmone.screens.ThirdScreen
import com.example.realmone.screens.Validated
import com.example.realmone.ui.theme.RealmOneTheme
import com.example.realmone.viewmodel.DatabaseViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val viewModel = DatabaseViewModel()
            RealmOneTheme {
                App(navController, viewModel)
            }
        }
    }
}


@Composable
fun App(navController: NavHostController, viewModel: DatabaseViewModel) {

    NavHost(navController = navController, startDestination = Screens.AssignmentScreen.name) {
        composable(route = Screens.AssignmentScreen.name) {
            AssignmentScreen(navController)
        }
        composable(route = Screens.SecondScreen.name) {
            SecondScreen()
        }
        composable(route = Screens.ThirdScreen.name) {
            ThirdScreen(navController, viewModel)
        }
        composable(route = Screens.Validated.name) {
            Validated(viewModel)
        }
        composable(route = Screens.FourthScreen.name) {
            FourthScreen(viewModel)
        }
        composable(route = Screens.FifthScreen.name) {
            FifthAssignmentScreen()
        }
    }


}


@Preview(showSystemUi = true)
@Composable
private fun Jhdfd() {
    AssignmentScreen(rememberNavController())
}