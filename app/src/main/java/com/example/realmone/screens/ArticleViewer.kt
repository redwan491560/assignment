package com.example.realmone.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.realmone.ArticleViewer
import com.example.realmone.ComposablesDesign
import com.example.realmone.R
import com.example.realmone.articleList
import com.example.realmone.volkorn


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ArticleViewerScreen(article: ArticleViewer) {


    var chipsState by remember { mutableIntStateOf(0) }
    val chipsMain = listOf("Articles", "Medicine", "Doctors")


    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, end = 10.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = article.category.toString(),
                    color = Color.Red,
                    fontFamily = volkorn,
                    fontSize = 16.sp
                )
            }
        }
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(top = 40.dp)
        ) {

            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 5.dp),
            ) {

                Text(
                    text = article.title,
                    fontSize = 18.sp,
                    fontFamily = volkorn,
                    maxLines = 1, overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.fillMaxWidth(),
                )
                Text(
                    text = "by- ${article.author}",
                    fontSize = 16.sp,
                    fontFamily = volkorn,
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
                ) {
                    if (article.image != null) {
                        Image(
                            painter = painterResource(id = article.image),
                            contentDescription = null,
                            modifier = Modifier
                                .size(300.dp, 180.dp)
                                .clip(RoundedCornerShape(8.dp)),
                            alignment = Alignment.Center,
                            contentScale = ContentScale.Crop
                        )
                    } else {
                        Column(
                            Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.image_not_found),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(120.dp)
                                    .padding(15.dp)
                                    .clip(RoundedCornerShape(8.dp)),
                                alignment = Alignment.Center,
                                contentScale = ContentScale.Crop
                            )
                            ComposablesDesign.TextDesign(text = "Image not available")
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = article.description,
                    fontSize = 14.sp,
                    fontFamily = volkorn,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Justify,
                )
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun AHdggd() {
    ArticleViewerScreen(articleList[0])
}

