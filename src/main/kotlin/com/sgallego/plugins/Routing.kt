package com.sgallego.plugins

import com.sgallego.repositories.NotesRepository
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        route("/notes"){
            get {
                call.respond(NotesRepository.getAll())
            }
        }

    }
}

