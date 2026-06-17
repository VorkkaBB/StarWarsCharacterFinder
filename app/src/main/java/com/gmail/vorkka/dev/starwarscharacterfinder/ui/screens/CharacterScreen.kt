package com.gmail.vorkka.dev.starwarscharacterfinder.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.gmail.vorkka.dev.starwarscharacterfinder.data.model.Character
import com.gmail.vorkka.dev.starwarscharacterfinder.ui.viewmodel.CharacterViewModel
import com.gmail.vorkka.dev.starwarscharacterfinder.R
import com.gmail.vorkka.dev.starwarscharacterfinder.ui.state.UiState

val SwYellow = Color(0xFFFFE81F)
val SwBlack = Color(0xFF000000)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterScreen(viewModel: CharacterViewModel) {
    val state = viewModel.uiState
    val searchQuery = viewModel.searchQuery

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.sables),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            "PERSONAJES - STAR WARS",
                            color = SwYellow,
                            fontWeight = FontWeight.ExtraBold
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Black.copy(alpha = 0.6f)
                    )
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { viewModel.onSearchQueryChange(it) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    placeholder = { Text("Buscar personaje...", color = Color.LightGray) },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Buscar", tint = SwYellow) },
                    trailingIcon = {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(onClick = { viewModel.onSearchQueryChange("") }) {
                                Icon(Icons.Default.Clear, contentDescription = "Limpiar", tint = SwYellow)
                            }
                        }
                    },
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = SwYellow,
                        unfocusedBorderColor = SwYellow.copy(alpha = 0.5f),
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        cursorColor = SwYellow,
                        focusedContainerColor = SwBlack.copy(alpha = 0.7f),
                        unfocusedContainerColor = SwBlack.copy(alpha = 0.7f)
                    ),
                    shape = RoundedCornerShape(12.dp)
                )

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    when (state) {
                        is UiState.Loading -> {
                            CircularProgressIndicator(color = SwYellow)
                        }
                        is UiState.Success -> {
                            val filteredCharacters = state.characters.filter { character ->
                                character.name.contains(searchQuery, ignoreCase = true)
                            }

                            if (filteredCharacters.isEmpty()) {
                                Surface(
                                    color = Color.Black.copy(alpha = 0.8f),
                                    shape = RoundedCornerShape(8.dp)
                                ) {
                                    Text(
                                        text = "No se encontraron personajes",
                                        color = SwYellow,
                                        modifier = Modifier.padding(16.dp),
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            } else {
                                CharacterList(characters = filteredCharacters)
                            }
                        }
                        is UiState.Error -> {
                            Surface(
                                color = Color.Black.copy(alpha = 0.8f),
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Text(
                                    text = state.message,
                                    color = Color.Red,
                                    modifier = Modifier.padding(16.dp),
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CharacterList(characters: List<Character>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(characters) { character ->
            CharacterCard(character = character)
        }
    }
}

@Composable
fun CharacterCard(character: Character) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = SwYellow.copy(alpha = 0.5f),
                shape = RoundedCornerShape(12.dp)
            ),
        colors = CardDefaults.cardColors(
            containerColor = SwBlack.copy(alpha = 0.85f)
        ),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = character.getImageUrl(),
                contentDescription = "Foto de ${character.name}",
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
                    .border(2.dp, SwYellow, CircleShape),
                contentScale = ContentScale.Crop,
                error = ColorPainter(Color.Red),
                placeholder = ColorPainter(Color.DarkGray)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = character.name.uppercase(),
                color = Color.White,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}