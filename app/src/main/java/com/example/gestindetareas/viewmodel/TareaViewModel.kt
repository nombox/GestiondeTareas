package com.example.gestindetareas.viewmodel

import androidx.lifecycle.ViewModel
import androidx.room.util.copy
import com.example.gestindetareas.model.TareaUiState
import com.tuempresa.gestiontareas.data.DataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TareaViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(TareaUiState())
    val uiState : StateFlow<TareaUiState> = _uiState.asStateFlow()

    //Inicializo la lista de tareas vacías en base al DataSource obtenido
    init{
        cargarTareasIniciales()

    }

    fun cargarTareasIniciales(){
        //Cargo las tareas del DataSource en una variable local
        val tareasPrimeras = DataSource.listaTareas

        //Guardo la información de las tareas pendientes
        val numPendientes = tareasPrimeras.count{!it.completado}

        //Pasandosela al _uiState
        _uiState.value = _uiState.value.copy(tareas = tareasPrimeras, contador = numPendientes)

    }

    fun cambiarEstadoTareas(id:Int){
        // Pendiente: Lógica para buscar la tarea, invertir su estado, usando .map { } para listas y el .copy() del estado

        // recalcular pendientes y emitir el nuevo UiState usando .copy()

    }
}