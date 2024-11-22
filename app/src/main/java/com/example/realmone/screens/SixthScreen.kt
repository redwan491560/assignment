package com.example.realmone.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.realmone.ComposablesDesign
import com.example.realmone.ItemParam

@Composable
fun SixthScreen(navController: NavController) {


    val foodItems = listOf(
        ItemParam(
            name = "Burger", description = "Juicy beef burger with lettuce and tomato", price = 200
        ),
        ItemParam(name = "Pizza", description = "Cheese-loaded Margherita pizza", price = 500),
        ItemParam(name = "Pasta", description = "Creamy Alfredo pasta with mushrooms", price = 350),
        ItemParam(
            name = "Salad",
            description = "Fresh garden salad with vinaigrette dressing",
            price = 150
        ),
        ItemParam(
            name = "Steak",
            description = "Grilled rib-eye steak with peppercorn sauce",
            price = 1200
        ),
        ItemParam(
            name = "Ice Cream",
            description = "Creamy vanilla ice cream topped with chocolate syrup",
            price = 120
        )
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        foodItems.forEach {
            ComposablesDesign.ItemCardClickable(item = it) {
                navController.navigate(
                    ItemParam(
                        name = it.name, price = it.price, description = it.description
                    )
                )
            }
        }

    }

}

@Composable
fun DisplayScreen(itemParam: ItemParam) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 40.dp)
            .systemBarsPadding()
    ) {
        Card(
            modifier = Modifier
                .padding(8.dp),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            Column(
                Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = "Name: ${itemParam.name}", fontSize = 22.sp)
                Text(text = "Price: ${itemParam.price}$", fontSize = 18.sp)
                Text(text = itemParam.description, fontSize = 16.sp)

            }

        }

    }

}


@Preview(showSystemUi = true)
@Composable
private fun SBDG() {
    SixthScreen(navController = rememberNavController())
}