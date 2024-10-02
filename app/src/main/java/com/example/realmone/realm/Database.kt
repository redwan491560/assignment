package com.example.realmone.realm

import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

object Database {

    private val config = RealmConfiguration.create(schema = setOf(Student::class))

    val realm: Realm = Realm.open(config)

}