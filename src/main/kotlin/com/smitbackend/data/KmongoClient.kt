package com.smitbackend.data

import com.smitbackend.model.InventoryItem
import com.smitbackend.model.Record
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val kmongoClient = KMongo.createClient(System.getenv("MONGO_URL")).coroutine
val inventoryDatabase = kmongoClient.getDatabase("InventoryItems")
val recordsDatabase = kmongoClient.getDatabase("Records")
val inventoryItemCollection = inventoryDatabase.getCollection<InventoryItem>()
val recordsCollection = recordsDatabase.getCollection<Record>()