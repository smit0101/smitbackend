package com.smitbackend.route

import com.smitbackend.service.getAllRecords
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getRecords(){
    get("/api/records"){
        val records = getAllRecords()
        call.respond(records)
    }
}

fun Route.getRecordByDate(){
    get("/api/record/{date}"){
        val date = call.parameters["date"]
        if (date != null) {
            val recordsByDate = com.smitbackend.service.getRecordByDate(date)
            if(recordsByDate != null) {
                call.respond(recordsByDate)
            }else{
                call.respond(HttpStatusCode.NotFound, "Record not found")
            }
        } else {
            call.respond(HttpStatusCode.BadRequest, "Invalid date")
        }
    }
}

fun Route.addRecord(){
    post("/api/add/record"){
        val newRecord:com.smitbackend.model.Record = call.receive<com.smitbackend.model.Record>()
        val isAdded = com.smitbackend.service.addRecord(newRecord)
        if (isAdded) {
            call.respond(newRecord)
            call.respond(HttpStatusCode.Created, "Record added successfully")
        } else {
            call.respond(HttpStatusCode.BadRequest, "Record already exists for this date")
        }
    }
}

