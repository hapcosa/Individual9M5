package com.example.individual9m5.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.individual9m5.components.Alert
import com.example.individual9m5.components.MainButton
import com.example.individual9m5.components.MainTextField
import com.example.individual9m5.components.multibutton
import com.example.individual9m5.components.resultText
import com.example.individual9m5.components.space
import com.example.individual9m5.viewmodels.CalcularIMCView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HomeView(modifier: Modifier,ViewModel:CalcularIMCView) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "IMC", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) {
        ContentHomeView(ViewModel)
    }
}
@Composable
fun ContentHomeView(CalcularIMCView:CalcularIMCView) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var state = CalcularIMCView.state
        resultText(state.IMC+" IMC")
        multibutton()
        space(size = 10.dp)
        MainTextField(value = state.peso, onValueChange = { CalcularIMCView.onValue(it, "peso") }, label = "Peso")
        space(size = 10.dp)
        MainTextField(value = state.altura, onValueChange = {  CalcularIMCView.onValue(it, "altura")}, label = "Altura")
        space(size = 10.dp)
        MainTextField(value = state.edad, onValueChange = { CalcularIMCView.onValue(it, "edad") }, label = "Edad")
        space(size = 10.dp)
        MainButton(text = "Calcular") {
            CalcularIMCView.calcularImc()
        }
        space(size= 10.dp)
        MainButton(text = "Limpiar", color = MaterialTheme.colorScheme.error) {
          CalcularIMCView.limpiar()
        }
        if (state.showAlert) {
            Alert(
                title = "Alerta",
                msj = "ingrese datos",
                confirmText = "Aceptar",
                onConfirmClick = { CalcularIMCView.cancelAlert() }
            ) { }
        }

    }
}