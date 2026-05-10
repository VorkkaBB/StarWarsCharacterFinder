package com.gmail.vorkka.dev.starwarscharacterfinder

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    private val repository = CharacterRepository()

    var uiState by mutableStateOf<UiState>(UiState.Loading)
        private set

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        viewModelScope.launch {
            uiState = UiState.Loading
            try {
                val response = repository.getCharacters()
                uiState = UiState.Success(response)
            } catch (e: Exception) {
                uiState = UiState.Error("Error de conexión: ${e.localizedMessage}")
            }
        }
    }
}