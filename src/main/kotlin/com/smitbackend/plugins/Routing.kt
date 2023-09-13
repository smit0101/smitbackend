package com.smitbackend.plugins


import com.smitbackend.route.listUsers
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        listUsers()

    }
}
