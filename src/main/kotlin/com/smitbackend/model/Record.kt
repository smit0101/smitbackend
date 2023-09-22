package com.smitbackend.model

import kotlinx.serialization.Serializable

@Serializable
data class Record(val date:String,val inventoryItems:List<InventoryItem>)
