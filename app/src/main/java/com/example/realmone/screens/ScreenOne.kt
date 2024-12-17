package com.example.realmone.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.realmone.R
import com.example.realmone.volkorn

@Preview(showSystemUi = true)
@Composable
fun FirstScreen(modifier: Modifier = Modifier) {

    var img by remember { mutableIntStateOf(R.drawable.img) }
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedCard(
                    elevation = CardDefaults.cardElevation(10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.img),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(15.dp)
                            .size(100.dp),
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Leading",
                    textDecoration = TextDecoration.Underline,
                    fontFamily = volkorn,
                    fontSize = 18.sp
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedCard(
                    elevation = CardDefaults.cardElevation(10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.metro),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(15.dp)
                            .size(100.dp),
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Metropolitan",
                    textDecoration = TextDecoration.Underline,
                    fontFamily = volkorn,
                    fontSize = 18.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(50.dp))

        Column(
            modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            img.run {
                Image(
                    painter = painterResource(id = (if (img == R.drawable.img) img else R.drawable.metro)),
                    contentDescription = null,
                    Modifier.size(120.dp)
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.padding(top = 20.dp)
            ) {
                Text(
                    text = "Leading", Modifier.clickable {
                        img = R.drawable.img
                        Toast.makeText(context, "Leading University", Toast.LENGTH_SHORT).show()
                    },
                    fontFamily = volkorn,
                    fontSize = 18.sp
                )
                Text(
                    text = "Metro",
                    Modifier.clickable {
                        img = R.drawable.metro
                        Toast.makeText(context, "Metropolitan University", Toast.LENGTH_SHORT).show()
                    },
                    fontFamily = volkorn,
                    fontSize = 18.sp
                )
            }
        }

    }
}