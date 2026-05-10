package com.gmail.vorkka.dev.starwarscharacterfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val characterViewModel: CharacterViewModel = viewModel()

            CharacterScreen(viewModel = characterViewModel)
        }
    }
}