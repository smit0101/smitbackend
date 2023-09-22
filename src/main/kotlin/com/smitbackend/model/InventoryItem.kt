package com.smitbackend.model

import kotlinx.serialization.Serializable

@Serializable data class InventoryItem(
    val name: String,
    val openingQuantity: Double,
    val closingQuantity: Double,
    val unitOfMeasurement: String,
    val expiryDate: String,
    val dateMade: String,
)