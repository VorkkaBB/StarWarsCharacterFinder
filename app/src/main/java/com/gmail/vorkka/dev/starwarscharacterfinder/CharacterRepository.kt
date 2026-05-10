package com.gmail.vorkka.dev.starwarscharacterfinder

class CharacterRepository {
    suspend fun getCharacters(): List<Character> {
        return RetrofitInstance.api.getCharacters()
    }
}