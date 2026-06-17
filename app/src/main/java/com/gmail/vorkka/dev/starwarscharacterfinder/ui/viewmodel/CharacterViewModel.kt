package com.gmail.vorkka.dev.starwarscharacterfinder.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gmail.vorkka.dev.starwarscharacterfinder.data.repository.CharacterRepository
import com.gmail.vorkka.dev.starwarscharacterfinder.ui.state.UiState
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    private val repository = CharacterRepository()

    var uiState by mutableStateOf<UiState>(UiState.Loading)
        private set

    var searchQuery by mutableStateOf("")
        private set

    init {
        fetchCharacters()
    }

    fun onSearchQueryChange(newQuery: String) {
        searchQuery = newQuery
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