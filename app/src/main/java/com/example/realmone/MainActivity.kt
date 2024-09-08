package com.example.realmone

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.realmone.ui.theme.RealmOneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            RealmOneTheme {
                AssignmentScreen()
            }
        }
    }
}

@Composable
fun AssignmentScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var checkedState by remember {
        mutableStateOf(false)
    }
    var num by remember {
        mutableIntStateOf(0)
    }
    var state by remember {
        mutableStateOf("")
    }
    var selected1 by remember {
        mutableStateOf(false)
    }
    var selected2 by remember {
        mutableStateOf(false)
    }
    val lists = listOf("male", "female")

    Column(
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Image(
            painter = painterResource(id = R.drawable.img), contentDescription = null,
            modifier = Modifier.size(120.dp)
        )
        Text(text = "Leading University", fontFamily = volkorn, fontSize = 20.sp)
        OutlinedButton(onClick = {
            Toast.makeText(context, "You've liked Leading University", Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Like?", fontFamily = volkorn)
        }


    }
}

@Composable
fun App(navController: NavHostController) {

//    NavHost(navController = navController, startDestination = Screens.MainScreen.name) {
//        composable(route = Screens.MainScreen.name) {
//            MainScreen(navController)
//        }
//        composable(route = Screens.ShowDB.name) {
//            ShowData()
//        }
//
//    }

}

@Preview(showSystemUi = true)
@Composable
private fun Jhdfd() {
    AssignmentScreen()
}