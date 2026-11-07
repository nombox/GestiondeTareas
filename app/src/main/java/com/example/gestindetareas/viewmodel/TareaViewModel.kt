package com.example.gestindetareas.viewmodel

import androidx.lifecycle.ViewModel
import com.example.gestindetareas.model.TareaUiState
import com.tuempresa.gestiontareas.data.DataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TareaViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(TareaUiState())
    val uiState : StateFlow<TareaUiState> = _uiState.asStateFlow()

    //Inicializo la lista de tareas vacías en base al DataSource obtenido
    init{
        cargarTareasIniciales()

    }

    fun cargarTareasIniciales(){
        //Cargo las tareas del DataSource en una variable local
        val tareasPrimarias = DataSource.listaTareas

        //Guardo la información de las tareas pendientes
        val numPendientes = tareasPrimarias.count{!it.completado}

        //Pasandosela al _uiState
        _uiState.value = _uiState.value.copy(tareas = tareasPrimarias, contador = numPendientes)

    }

    fun cambiarEstadoTareas(id:Int){
        //Usando update para aprender a usarlo
        _uiState.update{ estadoActual ->

            val listaNueva = _uiState.value.tareas.map{
                if(it.id == id) it.copy(completado = !it.completado) else it}

            val pendientesNuevos = listaNueva.count{!it.completado}

            estadoActual.copy(tareas = listaNueva, contador = pendientesNuevos)
        }

    }
}