package com.sgallego.models

import kotlinx.serialization.Serializable

@Serializable
data class Note(
    val title: String,
    val description: String,
    val type: Type
) {

    enum class Type {
        TEXT, AUDIO
    }

}