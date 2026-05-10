package com.gmail.vorkka.dev.starwarscharacterfinder

import kotlin.math.abs

data class Character(
    val name: String
) {
    val imageUrl: String
        get() = "https://picsum.photos/200/200?random=${abs(name.hashCode())}"
}