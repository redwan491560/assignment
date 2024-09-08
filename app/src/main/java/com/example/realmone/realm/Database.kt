package com.example.realmone.realm

import com.example.realmone.repository.MongoRepository
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

object Database {

    private val config = RealmConfiguration.create(schema = setOf(Student::class))

    val realm: Realm = Realm.open(config)

//    fun realmInstance(): Realm {
//        val config = RealmConfiguration.Builder(
//            schema = setOf(Student::class)
//        ).compactOnLaunch().build()
//
//        return Realm.open(config)
//    }

//    fun repository (realm: Realm): MongoRepository {
//        return OfflineRepository(realm)
//    }


}