package com.smitbackend.service

import com.smitbackend.data.recordsCollection
import com.smitbackend.model.Record
import org.litote.kmongo.eq

suspend fun getAllRecords()= recordsCollection.find().toList()

suspend fun addRecord(record:Record):Boolean {
    val existingRecord = recordsCollection.findOne(Record::date eq record.date)
    if (existingRecord != null) {
        return false
    }
    val result = recordsCollection.insertOne(record)
    return result.wasAcknowledged()
}

suspend fun getRecordByDate(date:String) = recordsCollection.findOne(Record::date eq date)


