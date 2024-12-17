package com.example.realmone.screens

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
import com.example.realmone.ArticleViewer
import com.example.realmone.ComposablesDesign
import com.example.realmone.articleList
import com.example.realmone.volkorn

@Composable
fun SixthScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(top = 30.dp, start = 10.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            ComposablesDesign.TextDesign(text = "Article", selected = true)
            ComposablesDesign.TextDesign(text = "News")
            ComposablesDesign.TextDesign(text = "Journals")
        }
        Spacer(modifier = Modifier.height(15.dp))
        articleList.forEach {
            ArticleDesign(
                articleViewer = it
            ) {
                navController.navigate(
                    ArticleViewer(
                        title = it.title,
                        description = it.description,
                        author = it.author,
                        image = it.image,
                        view = it.view,
                        rating = it.rating,
                        category = it.category
                    )
                )
            }
        }
    }
}


@Composable
fun ArticleDesign(articleViewer: ArticleViewer, onClick: () -> Unit) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 5.dp)
            .systemBarsPadding()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick() },
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(Color(0xfffffff0))
        ) {
            Column(
                Modifier.padding(10.dp, 8.dp), verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(text = articleViewer.title, fontSize = 16.sp, fontFamily = volkorn)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "By: ${articleViewer.author}",
                        fontSize = 14.sp,
                        fontFamily = volkorn
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "views: ${articleViewer.view}",
                            fontSize = 14.sp,
                            fontFamily = volkorn
                        )
                    }
                }
            }

        }

    }

}


@Preview(showSystemUi = true)
@Composable
private fun SBDG() {
    SixthScreen(navController = rememberNavController())
}