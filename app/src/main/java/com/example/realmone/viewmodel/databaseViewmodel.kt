package com.example.realmone.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

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


//    // Inserting a student into the database
//    fun insertStudent(student: Student) {
//        viewModelScope.launch {
//            Database.realm.write {
//                copyToRealm(student)
//            }
//        }
//    }
//
//    // RealmResults should be a LiveData or State
//    private val _students = mutableStateOf<List<Student>>(emptyList())
//    val students: MutableState<List<Student>> = _students
//
//    // Function to load students from the database
//    fun getStudentList() {
//        viewModelScope.launch {
//            val result = Database.realm.query<Student>().find()
//            _students.value = result.toList() // Convert RealmResults to a List
//        }
//    }

}
