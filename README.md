# Star Wars Character Finder 🌌

Una aplicación Android nativa desarrollada con Kotlin y Jetpack Compose que consume la API de SWAPI para mostrar un catálogo de personajes de Star Wars. Implementa arquitectura MVVM, carga de imágenes asíncrona y un sistema de filtrado en tiempo real.

## 🚀 Tecnologías y Herramientas

- **Kotlin:** Lenguaje principal del proyecto.
- **Jetpack Compose:** Herramienta moderna para la creación de interfaces de usuario (UI) declarativas.
- **Retrofit & Gson:** Cliente HTTP seguro para el consumo de la API REST y serialización de datos JSON.
- **Coroutines:** Manejo de peticiones de red asíncronas para mantener la fluidez de la interfaz.
- **Coil:** Librería optimizada para la carga y renderizado de imágenes desde internet.
- **Arquitectura MVVM:** Separación limpia entre la capa de datos, la lógica de negocio y la interfaz de usuario.

## 📱 Funcionamiento de la App

<p align="center">
  <img width="250" alt="vid_unidad5_borja" src="https://github.com/user-attachments/assets/80c1f6f3-2f2a-4d73-bfdb-443e8e85a9da" />
</p>

## 📂 Estructura del Proyecto

El código está organizado en paquetes por capas lógicas para facilitar su mantenimiento y escalabilidad. Haz clic en los archivos para ir directamente a su código fuente:

📦 `app/src/main/java/com/gmail/vorkka/dev/starwarscharacterfinder/`
<br>
┣ 📂 **`data/`** *(Capa de obtención y estructuración de datos)*
┃ ┣ 📂 `model/`
┃ ┃ ┗ 📜 [Character.kt](app/src/main/java/com/gmail/vorkka/dev/starwarscharacterfinder/data/model/Character.kt) - *Data class con la URL generada para Picsum.*
┃ ┣ 📂 `network/`
┃ ┃ ┣ 📜 [ApiService.kt](app/src/main/java/com/gmail/vorkka/dev/starwarscharacterfinder/data/network/ApiService.kt) - *Definición de endpoints de Retrofit.*
┃ ┃ ┗ 📜 [RetrofitInstance.kt](app/src/main/java/com/gmail/vorkka/dev/starwarscharacterfinder/data/network/RetrofitInstance.kt) - *Configuración del cliente HTTP.*
┃ ┗ 📂 `repository/`
┃ ┃ ┗ 📜 [CharacterRepository.kt](app/src/main/java/com/gmail/vorkka/dev/starwarscharacterfinder/data/repository/CharacterRepository.kt) - *Puente de abstracción para obtener los datos.*
<br>
┣ 📂 **`ui/`** *(Capa de interfaz gráfica y lógica de presentación)*
┃ ┣ 📂 `screens/`
┃ ┃ ┗ 📜 [CharacterScreen.kt](app/src/main/java/com/gmail/vorkka/dev/starwarscharacterfinder/ui/screens/CharacterScreen.kt) - *UI en Compose con barra de búsqueda y lista.*
┃ ┣ 📂 `state/`
┃ ┃ ┗ 📜 [UiState.kt](app/src/main/java/com/gmail/vorkka/dev/starwarscharacterfinder/ui/state/UiState.kt) - *Interfaz sellada (Sealed interface) para los estados Loading, Success y Error.*
┃ ┗ 📂 `viewmodel/`
┃ ┃ ┗ 📜 [CharacterViewModel.kt](app/src/main/java/com/gmail/vorkka/dev/starwarscharacterfinder/ui/viewmodel/CharacterViewModel.kt) - *Gestión del estado de la vista y corrutinas.*
