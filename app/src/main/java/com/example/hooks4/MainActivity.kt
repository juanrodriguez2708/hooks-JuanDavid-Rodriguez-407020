package com.example.hooks4

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.hooks4.ui.theme.Hooks4Theme

class MainActivity : ComponentActivity() {

    companion object {
        const val FULL_NAME_KEY = "FULL_NAME_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Hooks4Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(onNavigate = { fullName ->
                        val intent = Intent(this, WelcomeActivity::class.java)
                        intent.putExtra(FULL_NAME_KEY, fullName)
                        startActivity(intent)
                    })
                }
            }
        }
    }
}

@Composable
fun MainScreen(onNavigate: (String) -> Unit) {
    var fullName by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Ejercicio 2.04 - Envío de datos con Intent",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = fullName,
            onValueChange = { fullName = it },
            label = { Text("Ingresa tu nombre completo") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                if (fullName.text.isNotBlank()) {
                    onNavigate(fullName.text)
                }
            }
        ) {
            Text("Ir a pantalla de bienvenida")
        }
    }
}
