package com.example.realmone

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.realmone.screens.Data
import kotlinx.serialization.Serializable

enum class Screens {
    AssignmentScreen, FirstScreen, SecondScreen, ThirdScreen, Validated, FourthScreen, FifthScreen, SixthScreen, SeventhScreen
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

@Serializable
data class ItemParam(
    val name: String = "",
    val description: String = "",
    val price: Int = 0
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
        fun TextDesign(
            text: String,
            size: Int = 16,
            color: Color = Color.Black,
            selected: Boolean = false
        ) {
            Text(
                text = text,
                fontSize = size.sp,
                color = color,
                fontFamily = volkorn,
                textDecoration = if (selected) TextDecoration.Underline else TextDecoration.None
            )

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


        @Composable
        fun ItemCardClickable(item: ItemParam, onClick: () -> Unit) {
            Card(
                modifier = Modifier
                    .padding(8.dp),
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(4.dp),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp, 5.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(30.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            TextDesign(text = item.name, size = 22)
                            TextDesign(text = item.price.toString() + " tk", size = 22)
                        }
                    }

                    Image(
                        imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                        contentDescription = "null",
                        modifier = Modifier
                            .size(35.dp)
                            .clickable {
                                onClick()
                            }
                    )
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

@Serializable
data class ArticleViewer(
    val title: String = "",
    val description: String = "",
    val author: String = "",
    val view: Int = 0,
    val rating: Double = 0.2,
    val image: Int? = null,
    val category: String? = null
)


val articleList = listOf(
    ArticleViewer(
        title = "Covid-19. How to keep your family safe!",
        description = "As the Covid-19 pandemic continues to pose challenges globally, ensuring the safety of your loved ones is more important than ever. This article provides practical advice on protecting your family from the virus, including tips on maintaining hygiene, understanding the importance of vaccines, and staying updated on the latest health protocols. Learn how to create a safer environment at home and navigate public spaces responsibly during these uncertain times.",
        author = "Redwan Hussain",
        category = "Health",
        view = 1234,
        rating = 3.5,
        image = R.drawable.covid
    ), ArticleViewer(
        title = "Why mental health is important for us!",
        description = "Mental health is an integral part of our overall well-being, yet it often goes unnoticed in daily life. This article explores why mental health matters, emphasizing its connection to emotional resilience, physical health, and personal growth. It also highlights common challenges people face, ways to prioritize mental wellness, and the importance of fostering open conversations to eliminate stigma. Discover practical strategies for building a healthier mind and supporting those around you",
        author = "Redwan Hussain",
        category = "Health",
        view = 1234,
        rating = 3.5,
        image = R.drawable.mental
    ),
    ArticleViewer(
        title = "How to Maintain a Zero Percent Body Fat",
        description = "The idea of achieving zero percent body fat is a goal often glamorized, but is it truly realistic or healthy? This article delves into the science behind body fat percentages, shedding light on the dangers of striving for extremes and the potential health risks involved. It also emphasizes the importance of balanced nutrition, sustainable fitness routines, and setting realistic health goals that prioritize overall well-being rather than unattainable standards",
        author = "Redwan Hussain",
        category = "Health",
        view = 1234,
        rating = 3.5,
        image = R.drawable.health
    )
)


@Preview(showSystemUi = true)
@Composable
fun Dhgf(modifier: Modifier = Modifier) {
    ComposablesDesign.ItemCardClickable(
        item = ItemParam(
            name = "Item1", price = 200, description = "item1 description"
        )
    ) {

    }
}


