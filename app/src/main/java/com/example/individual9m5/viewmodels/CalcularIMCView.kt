package com.example.individual9m5.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.individual9m5.models.IMC
import androidx.compose.runtime.setValue

class CalcularIMCView:ViewModel() {
    var state by mutableStateOf(IMC())
        private set
    fun onValue(value: String, text: String) {
        when (text) {
            "peso" -> state = state.copy(peso = value)
            "edad" -> state = state.copy(edad = value)
            "altura"-> state = state.copy(altura=value)
        }
    }
    fun calcularImc(){
        val peso = state.peso
        val edad = state.edad
        val altura = state.altura
        var imc = 0.0
        if (peso!= "" && altura != "") {
            imc= (peso.toDouble()/(altura.toDouble() *altura.toDouble()))
            state = state.copy(IMC=imc.toString())
        }else{
            state = state.copy(
                showAlert = true
            )
        }
    }

    fun limpiar() {
        state = state.copy(
            peso = "" ,
            edad = "",
            altura = "",
            IMC="")
    }

    fun cancelAlert() {
        state = state.copy(
            showAlert = false
        )
    }
}