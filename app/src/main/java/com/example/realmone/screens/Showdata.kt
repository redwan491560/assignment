package com.example.realmone.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.realmone.viewmodel.DatabaseViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ShowData() {
    val viewmodel = DatabaseViewModel()

    LaunchedEffect(Unit) {
        viewmodel.getStudentList()
    }


    Scaffold {

        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.fillMaxWidth().systemBarsPadding()
        ) {
            viewmodel.students.value.forEach {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Text(text = it.name)
                    Text(text = it.age.toString())
                    Text(text = it.contact.toString())
                }
            }
        }

    }

}

@Preview(showSystemUi = true)
@Composable
private fun AJ() {
    ShowData()
}