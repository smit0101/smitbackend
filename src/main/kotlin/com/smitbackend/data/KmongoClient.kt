package com.smitbackend.data

import com.smitbackend.model.InventoryItem
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val kmongoClient = KMongo.createClient(System.getenv("MONGO_URL")).coroutine
val inventoryDatabase = kmongoClient.getDatabase("InventoryItems")

val inventoryItemCollection = inventoryDatabase.getCollection<InventoryItem>()