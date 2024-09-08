package com.example.realmone.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.realmone.Screens
import com.example.realmone.realm.Student
import com.example.realmone.viewmodel.DatabaseViewModel
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navHostController: NavHostController) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    val viewModel = DatabaseViewModel()

    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var contact by remember { mutableStateOf("") }

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
        ) {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Local Database using Realm")
                Spacer(modifier = Modifier.width(30.dp))
                Image(
                    imageVector = Icons.Outlined.Done,
                    contentDescription = null,
                    Modifier.clickable {
                        scope.launch {
                            navHostController.navigate(Screens.ShowDB.name)
                        }
                    }
                )
            }
            Spacer(modifier = Modifier.height(60.dp))
            Column(
                Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text(text = "Name") }
                )

                OutlinedTextField(
                    value = age,
                    onValueChange = { age = it },
                    label = { Text(text = "Age") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                OutlinedTextField(
                    value = contact,
                    onValueChange = { contact = it },
                    label = { Text(text = "Contact") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                Spacer(modifier = Modifier.height(30.dp))
                OutlinedButton(onClick = {
                    if (name.isEmpty() || age.isEmpty() || contact.isEmpty() ) {
                        Toast.makeText(context, "Fill all the fields", Toast.LENGTH_SHORT).show()
                    } else {
                        try {
                            val ageInt = age.toInt()
                            val contactInt = contact.toInt()

                            val std = Student().apply {
                                this.name = name
                                this.age = ageInt
                                this.contact = contactInt
                            }
                            viewModel.insertStudent(std)
                            Toast.makeText(context, "Student added successfully", Toast.LENGTH_SHORT).show()
                        } catch (e: NumberFormatException) {
                            Toast.makeText(context, "Invalid input in numeric fields", Toast.LENGTH_SHORT).show()
                        }
                    }

                }) {
                    Image(imageVector = Icons.Outlined.Add, contentDescription = null)
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewMainScreen() {
    MainScreen(navHostController = rememberNavController())
}
