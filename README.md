# 📝 Gestión de Tareas - Práctica de Android App

Aplicación móvil nativa para Android desarrollada con **Kotlin** y **Jetpack Compose**. Este proyecto es la implementación técnica de un diseño de interfaz (UI/UX) creado en Figma, enfocado en aplicar buenas prácticas de desarrollo, arquitectura moderna reactiva y distribución en la nube.

## ✨ Características Principales

*   **Lista Dinámica:** Renderizado eficiente de tareas utilizando `LazyColumn` para listas con múltiples elementos.
*   **Gestión de Estado en Tiempo Real:** Cabecera personalizada (`TopAppBar`) que incluye un contador dinámico que se actualiza al instante según el estado de las tareas.
*   **Interacción y Estilos Dinámicos:** Tarjetas interactivas que mutan su diseño (colores, fondos e iconos nativos) al hacer clic, alternando entre los estados *Completada* y *Pendiente*.
*   **Flujo de Datos Unidireccional (UDF):** Implementación estricta de *State Hoisting* (Elevación de estado), asegurando que los componentes visuales sean *stateless* (sin estado) y delegando la lógica de negocio al ViewModel.

## 🛠️ Tecnologías y Arquitectura

*   **Lenguaje:** Kotlin
*   **UI Toolkit:** Jetpack Compose
*   **Diseño:** Material Design 3 (Scaffold, TopAppBar, Cards, Icons)
*   **Arquitectura:** MVVM (Model-View-ViewModel)
*   **Gestión de Estado:** `StateFlow` y Clases de Estado (`UiState`)
*   **Despliegue:** Firebase App Distribution

## 🏗️ Estructura del Proyecto

El proyecto está modularizado siguiendo los estándares de la arquitectura MVVM para garantizar un código escalable y limpio:

*   `/data`: Modelos de datos crudos (`Tarea.kt`) y orígenes de datos (`DataSource.kt`).
*   `/model`: Clases de representación de estado visual (`TareaUiState.kt`).
*   `/viewmodel`: Lógica de negocio y gestión reactiva del estado mediante `MutableStateFlow`.
*   `/ui`: Pantalla principal y subcarpeta `/components` con piezas visuales reutilizables e independientes (`Tarjeta`, `Cabecera`, etc.).

## 🚀 Despliegue (Firebase)

El proyecto cuenta con integración en **Firebase App Distribution**. La aplicación ha sido empaquetada y firmada como un `APK` de lanzamiento (`release`), permitiendo la distribución ágil a *testers* directamente desde la consola de Firebase sin necesidad de pasar por Google Play.

## 📱 Capturas de Pantalla
*(Añade aquí un par de capturas de pantalla de tu emulador mostrando las tareas pendientes y completadas)*

<div align="center">
  <img src="ruta_a_tu_imagen_1.png" width="250" />
  &nbsp;&nbsp;&nbsp;&nbsp;
  <img src="ruta_a_tu_imagen_2.png" width="250" />
</div>

---
**Autor:** Sebastian Eduardo Vargas Mariño[cite: 5]
