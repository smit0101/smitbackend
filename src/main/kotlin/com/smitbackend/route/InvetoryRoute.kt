package com.smitbackend.route

import com.smitbackend.model.InventoryItem
import com.smitbackend.service.addInventoryItem
import com.smitbackend.service.getAllInventoryItems
import com.smitbackend.service.getInventoryItemByName
import com.smitbackend.service.updateInventoryItemByName
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.getInventoryItems(){
    get("/api/items"){
        val inventoryItems = getAllInventoryItems()
        call.respond(inventoryItems)
    }
}

fun Route.getInventoryItemByName(){
    get("/api/item/{name}"){
        val name = call.parameters["name"]
        if (name != null) {
            val item = getInventoryItemByName(name)
            if (item != null) {
                call.respond(item)
            } else {
                call.respond(HttpStatusCode.NotFound, "Item not found")
            }
        } else {
            call.respond(HttpStatusCode.BadRequest, "Invalid item name")
        }
    }
}

fun Route.addInventoryItem(){
    post("/api/additem") {
        // Receive a new inventory item and add it
        val newItem = call.receive<InventoryItem>()
        val isAdded = addInventoryItem(newItem)
        if (isAdded) {
            call.respond(newItem)
            call.respond(HttpStatusCode.Created, "Item added successfully")
        } else {
            call.respond(HttpStatusCode.BadRequest, "Item with the same name already exists")
        }
    }
}

fun Route.updateItemByName(){
    put("/api/update/item/{name}"){
        val name = call.parameters["name"]
        if (name != null) {
            val updatedItem = call.receive<InventoryItem>()
            val isUpdated = updateInventoryItemByName(name, updatedItem)
            if (isUpdated) {
                call.respond(updatedItem)
                call.respond(HttpStatusCode.OK, "Item updated successfully")
            } else {
                call.respond(HttpStatusCode.NotFound, "Item not found")
            }
        } else {
            call.respond(HttpStatusCode.BadRequest, "Invalid item name")
        }
    }
}