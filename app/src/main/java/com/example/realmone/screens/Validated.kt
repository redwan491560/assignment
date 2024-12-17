package com.example.realmone.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.realmone.ComposablesDesign.Companion.TextDesign
import com.example.realmone.viewmodel.DatabaseViewModel

@Composable
fun Validated(viewModel: DatabaseViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp, 20.dp)
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            TextDesign(text = "Validation Successful")
            Spacer(modifier = Modifier.height(20.dp))
        }

        Card {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    TextDesign(text = "Username: ")
                    TextDesign(text = viewModel.username.value, size = 22)
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    TextDesign(text = "Phone no: ")
                    TextDesign(text = viewModel.phone.value, size = 22)
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    TextDesign(text = "Email: ")
                     TextDesign(text = viewModel.email.value, size = 22)
                }
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    TextDesign(text = "Password: ")
                     TextDesign(text = viewModel.password.value, size = 22)
                }

            }
        }

    }

}


@Preview(showSystemUi = true)
@Composable
private fun Dsjd() {
    Validated(viewModel = DatabaseViewModel())
}