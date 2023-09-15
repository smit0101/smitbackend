package com.smitbackend.data

import com.smitbackend.model.User
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val kmongoClient = KMongo.createClient("mongodb+srv://smit:9099850857@cluster0.b6lha1g.mongodb.net/?retryWrites=true&w=majority").coroutine
val userDatabase = kmongoClient.getDatabase("USER")
val userCollection = userDatabase.getCollection<User>()