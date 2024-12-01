package com.bootcamp.ejercicio4app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.bootcamp.ejercicio4app.navigation.NewsNavegation
import com.bootcamp.ejercicio4app.ui.theme.Ejercicio4AppTheme
import com.bootcamp.ejercicio4app.viewModel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: NewsViewModel by viewModels()
        setContent {
            Ejercicio4AppTheme {
                NewsNavegation(viewModel) }
        }
    }
}