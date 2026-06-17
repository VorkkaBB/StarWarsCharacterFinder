package com.gmail.vorkka.dev.starwarscharacterfinder.data.repository

import com.gmail.vorkka.dev.starwarscharacterfinder.data.model.Character
import com.gmail.vorkka.dev.starwarscharacterfinder.data.network.RetrofitInstance

class CharacterRepository {
    suspend fun getCharacters(): List<Character> {
        return RetrofitInstance.api.getCharacters()
    }
}