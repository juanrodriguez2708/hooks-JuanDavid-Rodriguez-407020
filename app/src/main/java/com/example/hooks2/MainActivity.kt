package com.example.hooks2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hooks2.ui.theme.Hooks2Theme
import kotlin.random.Random
import androidx.compose.ui.res.stringResource


class MainActivity : ComponentActivity() {

    companion object {
        private const val RANDOM_NUMBER = "RANDOM_NUMBER"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            Hooks2Theme {
                var randomNumber by rememberSaveable() { mutableStateOf(0) }

                // Restaurar valor guardado (solo si viene de Bundle)
                if (savedInstanceState != null && randomNumber == 0) {
                    randomNumber = savedInstanceState.getInt(RANDOM_NUMBER, 0)
                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(onClick = {
                            randomNumber = Random.nextInt(0, 1000)
                        }) {
                            Text(text = "Generar número aleatorio", fontSize = 18.sp)
                        }

                        Text(
                            text = stringResource(id = R.string.random_number_message, randomNumber),
                            fontSize = 20.sp,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                    }
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Ya no hace falta si usas rememberSaveable, pero lo dejamos por compatibilidad
        // Esto guardará el número en el Bundle cuando se destruya la actividad
        val currentValue = 0 // Puedes guardarlo si lo usas fuera del setContent
        outState.putInt(RANDOM_NUMBER, currentValue)
    }
}
