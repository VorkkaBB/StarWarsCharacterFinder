package com.gmail.vorkka.dev.starwarscharacterfinder.data.network

import com.gmail.vorkka.dev.starwarscharacterfinder.data.model.Character
import retrofit2.http.GET

interface ApiService {
    @GET("people")
    suspend fun getCharacters(): List<Character>
}