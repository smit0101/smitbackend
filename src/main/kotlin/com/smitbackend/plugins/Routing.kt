package com.smitbackend.plugins



import com.smitbackend.route.*
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        getInventoryItems()
        getInventoryItemByName()
        addInventoryItem()
        updateItemByName()
        getRecords()
        getRecordByDate()
        addRecord()

    }
}
