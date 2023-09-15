package com.smitbackend.route


import com.smitbackend.data.userCollection
import com.smitbackend.model.User
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.w3c.dom.html.HTMLAnchorElement

fun Route.listUsers() {
    get {
      val result =   userCollection.insertOne(User("Raj","Kalkani","rajkalkani9099@gmail.com")).wasAcknowledged()
      call.respond("Hey How are you ${result}")
    }
}

fun Route.addUser(){
    post ("/add/user"){

    }

}
