package com.example.gestindetareas.model

import com.example.gestindetareas.data.Tarea

data class TareaUiState(val tareas:List<Tarea> = emptyList(), val contador:Int = 0)