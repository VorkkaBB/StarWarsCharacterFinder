package com.gmail.vorkka.dev.starwarscharacterfinder

import retrofit2.http.GET

interface ApiService {
    @GET("people")
    suspend fun getCharacters(): List<Character>
}