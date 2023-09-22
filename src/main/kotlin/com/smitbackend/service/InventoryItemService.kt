package com.smitbackend.service

import com.smitbackend.data.inventoryItemCollection
import com.smitbackend.model.InventoryItem
import org.litote.kmongo.eq
import org.litote.kmongo.set
import org.litote.kmongo.setTo


suspend fun getAllInventoryItems()= inventoryItemCollection.find().toList()

suspend fun addInventoryItem(inventoryItem:InventoryItem)= inventoryItemCollection.insertOne(inventoryItem).wasAcknowledged()

suspend fun getInvetoryItemByName(name:String)= inventoryItemCollection.findOne(InventoryItem::name eq name)

suspend fun updateInventoryItemByName(itemName: String, updatedItem: InventoryItem): Boolean {
    // Find the item by name
    val existingItem = inventoryItemCollection.findOne(InventoryItem::name eq itemName)

    if (existingItem != null) {
        // Update the properties of the existing item with the values from updatedItem
        val updatedFields = setOf(
            InventoryItem::openingQuantity setTo updatedItem.openingQuantity,
            InventoryItem::closingQuantity setTo updatedItem.closingQuantity,
            InventoryItem::unitOfMeasurement setTo updatedItem.unitOfMeasurement,
            InventoryItem::expiryDate setTo updatedItem.expiryDate,
            InventoryItem::dateMade setTo updatedItem.dateMade
        )

        // Update the item in the collection
        inventoryItemCollection.updateOne(InventoryItem::name eq itemName, set(*updatedFields.toTypedArray()))
        return true
    } else {
        return false // Item not found, no update performed
    }
}