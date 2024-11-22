package com.example.realmone.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.realmone.ComposablesDesign.Companion.ItemCard
import com.example.realmone.viewmodel.DatabaseViewModel


@Composable
fun FourthScreen(viewModel: DatabaseViewModel) {
    val list = viewModel.itemslist
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .systemBarsPadding()
            .verticalScroll(rememberScrollState())
    ) {
        list.forEach {
            ItemCard(item = it)
        }

    }

}


@Preview(showSystemUi = true)
@Composable
private fun SJfdf() {
    FourthScreen(viewModel = DatabaseViewModel())
}