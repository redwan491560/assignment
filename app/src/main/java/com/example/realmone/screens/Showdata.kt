package com.example.realmone.screens

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.realmone.viewmodel.DatabaseViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ShowData() {
    val viewmodel = DatabaseViewModel()


    Scaffold {


    }

}


@Preview(showSystemUi = true)
@Composable
private fun AJ() {
    ShowData()
}