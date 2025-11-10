package com.sparsh.sanjikun

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sparsh.sanjikun.navigation.screens.LoginScreen
import com.sparsh.sanjikun.navigation.utils.AppNavigation
import com.sparsh.sanjikun.ui.theme.SanjiKunTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SanjiKunTheme {
                AppNavigation(LoginScreen.deeplink())
            }
        }
    }
}