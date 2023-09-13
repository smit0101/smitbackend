package com.smitbackend

import com.smitbackend.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureRouting()
    configureHTTP()
    configureSerialization()
}
