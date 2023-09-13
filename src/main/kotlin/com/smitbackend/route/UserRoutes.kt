package com.smitbackend.route


import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.listUsers() {
    get {
       call.respondText("<H1>Hey there</H1>")
    }
}
