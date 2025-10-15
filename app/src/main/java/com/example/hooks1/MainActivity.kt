package com.example.hooks1

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate ejecutado")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart ejecutado")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume ejecutado")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause ejecutado")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop ejecutado")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart ejecutado")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy ejecutado")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState ejecutado")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState ejecutado")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d(TAG, "onConfigurationChanged ejecutado")
    }
}
