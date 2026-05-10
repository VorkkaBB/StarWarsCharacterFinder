package com.gmail.vorkka.dev.starwarscharacterfinder

sealed interface UiState {

    object Loading : UiState

    data class Success(val characters: List<Character>) : UiState

    data class Error(val message: String) : UiState
}