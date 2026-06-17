package com.gmail.vorkka.dev.starwarscharacterfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gmail.vorkka.dev.starwarscharacterfinder.ui.screens.CharacterScreen
import com.gmail.vorkka.dev.starwarscharacterfinder.ui.viewmodel.CharacterViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val characterViewModel: CharacterViewModel = viewModel()

            CharacterScreen(viewModel = characterViewModel)
        }
    }
}