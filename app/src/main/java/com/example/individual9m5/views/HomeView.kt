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
import com.example.individual9m5.components.MainButton
import com.example.individual9m5.components.MainTextField
import com.example.individual9m5.components.multibutton
import com.example.individual9m5.components.space

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HomeView(modifier: Modifier) {
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
        ContentHomeView()
    }
}
@Composable
fun ContentHomeView() {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var peso by remember {
            mutableStateOf("")
        }
        var altura by remember {
            mutableStateOf("")
        }
        var edad by remember {
            mutableStateOf("")
        }
        multibutton()
        space(size = 10.dp)
        MainTextField(value = peso, onValueChange = { peso = it }, label = "peso")
        space(size = 10.dp)
        MainTextField(value = altura, onValueChange = { altura = it }, label = "peso")
        space(size = 10.dp)
        MainTextField(value = edad, onValueChange = { edad = it }, label = "peso")
        space(size = 10.dp)
        MainButton(text = "Calcular") {
            
        }

    }
}