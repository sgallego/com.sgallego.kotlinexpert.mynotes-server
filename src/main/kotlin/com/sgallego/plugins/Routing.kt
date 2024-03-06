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
            call.respondText("Hello World!")
        }
        get("/html") {
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
        get("/html/clicked") {
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
