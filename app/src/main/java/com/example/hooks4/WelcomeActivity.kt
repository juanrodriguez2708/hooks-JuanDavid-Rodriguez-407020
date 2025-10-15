package com.example.hooks4

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hooks4.MainActivity.Companion.FULL_NAME_KEY
import com.example.hooks4.ui.theme.Hooks4Theme  // ✅ tu tema correcto

class WelcomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Hooks4Theme {  // ✅ cambiamos el tema inexistente por el tuyo real
                WelcomeScreen(intent)
            }
        }
    }
}

@Composable
private fun WelcomeScreen(intent: Intent) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            val fullName = intent.getStringExtra(FULL_NAME_KEY) ?: ""
            val welcomeText = stringResource(R.string.welcome_text, fullName)

            Text(
                textAlign = TextAlign.Center,
                text = welcomeText,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    val intent = Intent().apply {
        putExtra(FULL_NAME_KEY, "Alex Forrester")
    }
    Hooks4Theme {
        WelcomeScreen(intent)
    }
}
