package com.smitbackend.model

import kotlinx.serialization.Serializable
import org.bson.types.ObjectId
@Serializable
data class User(val firstName:String, val lastName:String, val email:String)



