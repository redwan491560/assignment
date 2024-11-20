package com.example.realmone

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.realmone.screens.Data

enum class Screens {
    MainScreen, ShowDB, AssignmentScreen, SecondScreen, ThirdScreen, Validated, FourthScreen, FifthScreen
}

val volkorn = FontFamily(
    Font(R.font.volkorn, weight = FontWeight.Normal)
)

data class Item(
    val id: String = generateRandomString(),
    val name: String = "",
    val description: String = "",
    val price: Int = 0,
    val image: String? = null
)


fun generateRandomString(): String {
    val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!£$%^&*_abcdefghijklmnopqrstuvwxyz0123456789"
    return (1..16)
        .map { chars.random() }
        .joinToString("")
}


class ComposablesDesign {
    companion object {
        @Composable
        fun TextDesign(text: String, size: Int = 16, color: Color = Color.Black) {
            Text(text = text, fontSize = size.sp, color = color)

        }

        @Composable
        fun ItemCard(item: Item) {
            Card(
                modifier = Modifier
                    .padding(8.dp),
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(4.dp),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Row {
                    Column(
                        modifier = Modifier
                            .weight(6f)
                            .padding(10.dp, 5.dp),
                        verticalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(30.dp)
                        ) {
                            TextDesign(text = item.name, size = 20)
                            TextDesign(text = item.price.toString(), size = 22)
                        }
                        TextDesign(text = item.id, color = Color.Gray)
                        TextDesign(text = item.description, size = 18)
                    }
                    Row(
                        modifier = Modifier
                            .weight(3f)
                            .padding(15.dp, 5.dp)
                            .height(80.dp),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AsyncImage(
                            model = item.image,
                            contentDescription = "Image from Flaticon",
                            modifier = Modifier.size(60.dp)
                        )
                    }

                }


            }
        }
    }
}


val programmingList = listOf(
    Data(
        "C",
        "Efficient and foundational, used for system-level programming and embedded systems."
    ),
    Data(
        "C++",
        "Powerful and versatile, ideal for games, graphics, and high-performance software."
    ),
    Data("Python", "Simple and flexible, popular for web, AI, and data analysis."),
    Data("Kotlin", "Modern and safe, preferred for Android and cross-platform apps."),
    Data("Java", "Stable and portable, a staple for enterprise and Android development."),
    Data("Swift", "Fast and intuitive, the go-to for Apple ecosystem applications.")
)


@Preview(showSystemUi = true)
@Composable
fun Dhgf(modifier: Modifier = Modifier) {
    ComposablesDesign.ItemCard(
        item = Item(
            name = "Item1",
            description = "Description2",
            price = 100,
            image = "https://www.freepik.com/icon/blood_655983#fromView=keyword&page=1&position=1&uuid=ab625699-27b7-4c2a-ade1-7747ecda9b4b"

        )
    )
}


