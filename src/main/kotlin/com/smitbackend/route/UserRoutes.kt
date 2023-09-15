package com.smitbackend.route


import com.smitbackend.data.userCollection
import com.smitbackend.model.User
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.w3c.dom.html.HTMLAnchorElement

fun Route.listUsers() {
    get {
      call.respond("Hey How are you")
    }
}

fun Route.addUser(){
    post ("/add/user"){

    }

}
