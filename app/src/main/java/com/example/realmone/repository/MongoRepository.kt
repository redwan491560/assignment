package com.example.realmone.repository

import com.example.realmone.realm.Student
import kotlinx.coroutines.flow.Flow
import org.mongodb.kbson.ObjectId

interface MongoRepository {
    fun getData(): Flow<List<Student>>
    fun searchByName(name: String): Flow<List<Student>>
    suspend fun insertStudent(student: Student)
    suspend fun updateStudent(student: Student, gpa: Double, contact: Int, age: Int)
    suspend fun deleteStudent(id: ObjectId)
}