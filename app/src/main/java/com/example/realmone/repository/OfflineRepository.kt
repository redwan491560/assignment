package com.example.realmone.repository

import android.util.Log
import com.example.realmone.realm.Student
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.mongodb.kbson.ObjectId

//class OfflineRepository(private val realm: Realm) : MongoRepository {
//    override fun getData(): Flow<List<Student>> {
//        return realm.query<Student>().asFlow().map { it.list }
//    }
//
//    override fun searchByName(name: String): Flow<List<Student>> {
//        return realm.query<Student>(query = "name CONTAINS[c] $0", name).asFlow().map { it.list }
//    }
//
//    override suspend fun insertStudent(student: Student) {
//        realm.write {
//            copyToRealm(student)
//        }
//    }
//
//    override suspend fun updateStudent(student: Student, gpa: Double, contact: Int, age: Int) {
//        realm.write {
//            val std: Student? =
//                realm.query<Student>(query = "_id == $0", student._id).first().find()
//            std?.gpa = gpa
//            std?.contact = contact
//            std?.age = age
//        }
//    }
//
//    override suspend fun deleteStudent(id: ObjectId) {
//        realm.write {
//            val std: Student? = realm.query<Student>(query = "_id == $0", id).first().find()
//            try {
//                std?.let { delete(it) }
//            } catch (e: Exception) {
//                Log.d("OfflineRepository", "${e.message}")
//            }
//        }
//    }
//}
