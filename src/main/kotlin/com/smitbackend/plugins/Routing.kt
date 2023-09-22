package com.smitbackend.plugins



import com.smitbackend.route.addInventoryItem
import com.smitbackend.route.getInventoryItemByName
import com.smitbackend.route.getInventoryItems
import com.smitbackend.route.updateItemByName
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        getInventoryItems()
        getInventoryItemByName()
        addInventoryItem()
        updateItemByName()

    }
}
