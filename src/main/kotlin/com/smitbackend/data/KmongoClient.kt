package com.smitbackend.data

import com.smitbackend.model.User
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val kmongoClient = KMongo.createClient(System.getenv("MONGO_URL")).coroutine
val userDatabase = kmongoClient.getDatabase("USER")
val userCollection = userDatabase.getCollection<User>()