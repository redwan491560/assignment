package com.example.realmone.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.realmone.realm.Database
import com.example.realmone.realm.Student
import io.realm.kotlin.ext.query
import kotlinx.coroutines.launch

class DatabaseViewModel : ViewModel() {

//    private var db = Database.realm
//
//    fun insertStudent(student: Student) {
//        viewModelScope.launch {
//            db.writeBlocking {
//                copyToRealm(Student())
//            }
//        }
//    }
//
//
//    private var listOfStudent: RealmResults<Student> = db.query<Student>().find()
//
//
//    fun getStudentList(): RealmResults<Student> {
//        return listOfStudent
//    }

    private var db = Database.realm

    // Inserting a student into the database
    fun insertStudent(student: Student) {
        viewModelScope.launch {
            db.write {
                copyToRealm(student)
            }
        }
    }

    // RealmResults should be a LiveData or State
    private val _students = mutableStateOf<List<Student>>(emptyList())
    val students: MutableState<List<Student>> = _students

    // Function to load students from the database
    fun getStudentList() {
        viewModelScope.launch {
            val result = db.query<Student>().find()
            _students.value = result.toList() // Convert RealmResults to a List
        }
    }

}
