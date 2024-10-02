package com.example.realmone.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
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
            .padding(
                10.dp, 20.dp
            )
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            TextDesign(text = "You have been validated")
            Spacer(modifier = Modifier.height(20.dp))
        }
        Column(
            Modifier
                .fillMaxWidth()
                .padding(20.dp, 10.dp)) {
            Row {
                TextDesign(text = "Username: ")
                TextDesign(text = viewModel.username.value)
            }
            Row {
                TextDesign(text = "Phone no: ")
                TextDesign(text = viewModel.phone.value)
            }
            Row {
                TextDesign(text = "Email: ")
                TextDesign(text = viewModel.email.value)
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row {
                TextDesign(text = "Password: ")
                TextDesign(text = viewModel.password.value)
            }

        }

    }

}


@Preview(showSystemUi = true)
@Composable
private fun Dsjd() {
    Validated(viewModel = DatabaseViewModel())
}