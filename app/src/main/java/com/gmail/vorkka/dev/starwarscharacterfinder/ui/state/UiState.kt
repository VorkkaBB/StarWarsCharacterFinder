package com.gmail.vorkka.dev.starwarscharacterfinder.ui.state

import com.gmail.vorkka.dev.starwarscharacterfinder.data.model.Character

sealed interface UiState {
    object Loading : UiState
    data class Success(val characters: List<Character>) : UiState
    data class Error(val message: String) : UiState
}