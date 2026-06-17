package com.gmail.vorkka.dev.starwarscharacterfinder.data.model

import kotlinx.serialization.Serializable
import kotlin.math.abs

@Serializable
data class Character(
    val name: String,
    val url: String
) {
    fun getImageUrl(): String {
        return "https://picsum.photos/200/200?random=${abs(name.hashCode())}"
    }
}