package com.sgallego.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.*

fun Application.configureRouting() {
    routing {
        get("") {
            call.respondText("Goodbye World!")
        }
        htmlRoutes()

    }
}

private fun Routing.htmlRoutes() {
    route("html") {
        get {
            call.respondHtml(status = HttpStatusCode.OK) {
                head {
                    title { +"Hello Ktor" }
                }
                body {
                    h1 { +"This is an h1" }
                    p { +"This is a paragraph" }
                    div {
                        a(href = "html/clicked") { +"Click me" }
                    }
                }
            }
        }
        get("clicked") {
            call.respondHtml {
                head {
                    title { +"Clicked" }
                }
                body {
                    h1 { +"Button clicked" }
                }
            }
        }
    }
}
