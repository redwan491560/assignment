package com.example.realmone.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.realmone.Item

class DatabaseViewModel : ViewModel() {


    var phone = mutableStateOf("")
    var username = mutableStateOf("")
    var email = mutableStateOf("")
    var password = mutableStateOf("")

    private val passwordRegex =
        "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{8,}$".toRegex()

    private val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex()
    private val contactRegex = "^01\\d{9}$".toRegex()

    fun validatePass(pass: String): Boolean {
        return pass.matches(passwordRegex)
    }

    fun validateEmail(email: String): Boolean {
        return email.matches(emailRegex)
    }

    fun validateContact(contact: String): Boolean {
        return contact.matches(contactRegex)
    }

    val itemslist = mutableListOf(
        Item(
            name = "item1",
            description = "description1",
            price = 100,
            image = "https://cdn-icons-png.flaticon.com/128/743/743007.png"
        ),
        Item(
            name = "item2",
            description = "description2",
            price = 200,
            image = "https://cdn-icons-png.flaticon.com/128/10389/10389920.png"
        ),
        Item(
            name = "item3",
            description = "description3",
            price = 300,
            image = "https://cdn-icons-png.flaticon.com/128/3306/3306988.png"
        ),
        Item(
            name = "item4",
            description = "description4",
            price = 400,
            image = "https://cdn-icons-png.flaticon.com/128/8568/8568236.png"
        ),
        Item(
            name = "item5",
            description = "description5",
            price = 500,
            image = "https://cdn-icons-png.flaticon.com/128/10469/10469224.png"
        ), Item(
            name = "item1",
            description = "description1",
            price = 100,
            image = "https://cdn-icons-png.flaticon.com/128/743/743007.png"
        ),
        Item(
            name = "item2",
            description = "description2",
            price = 200,
            image = "https://cdn-icons-png.flaticon.com/128/10389/10389920.png"
        ),
        Item(
            name = "item3",
            description = "description3",
            price = 300,
            image = "https://cdn-icons-png.flaticon.com/128/3306/3306988.png"
        ),
        Item(
            name = "item4",
            description = "description4",
            price = 400,
            image = "https://cdn-icons-png.flaticon.com/128/8568/8568236.png"
        ),
        Item(
            name = "item5",
            description = "description5",
            price = 500,
            image = "https://cdn-icons-png.flaticon.com/128/10469/10469224.png"
        ), Item(
            name = "item1",
            description = "description1",
            price = 100,
            image = "https://cdn-icons-png.flaticon.com/128/743/743007.png"
        ),
        Item(
            name = "item2",
            description = "description2",
            price = 200,
            image = "https://cdn-icons-png.flaticon.com/128/10389/10389920.png"
        ),
        Item(
            name = "item3",
            description = "description3",
            price = 300,
            image = "https://cdn-icons-png.flaticon.com/128/3306/3306988.png"
        ),
        Item(
            name = "item4",
            description = "description4",
            price = 400,
            image = "https://cdn-icons-png.flaticon.com/128/8568/8568236.png"
        ),
        Item(
            name = "item5",
            description = "description5",
            price = 500,
            image = "https://cdn-icons-png.flaticon.com/128/10469/10469224.png"
        ), Item(
            name = "item1",
            description = "description1",
            price = 100,
            image = "https://cdn-icons-png.flaticon.com/128/743/743007.png"
        ),
        Item(
            name = "item2",
            description = "description2",
            price = 200,
            image = "https://cdn-icons-png.flaticon.com/128/10389/10389920.png"
        ),
        Item(
            name = "item3",
            description = "description3",
            price = 300,
            image = "https://cdn-icons-png.flaticon.com/128/3306/3306988.png"
        ),
        Item(
            name = "item4",
            description = "description4",
            price = 400,
            image = "https://cdn-icons-png.flaticon.com/128/8568/8568236.png"
        ),
        Item(
            name = "item5",
            description = "description5",
            price = 500,
            image = "https://cdn-icons-png.flaticon.com/128/10469/10469224.png"
        )
    )


}