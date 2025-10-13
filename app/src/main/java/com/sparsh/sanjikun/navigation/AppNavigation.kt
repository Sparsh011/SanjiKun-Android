package com.sparsh.sanjikun.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.sparsh.sanjikun.feature.onboarding.authentication.views.screens.LoginScreen
import com.sparsh.sanjikun.feature.onboarding.onboarding.views.screens.OnboardingScreen
import com.sparsh.sanjikun.navigation.screens.LoginScreen
import com.sparsh.sanjikun.navigation.screens.OnboardingScreen

@Composable
fun AppNavigation() {
    val backStack = remember {
        mutableStateListOf<Any>(
            LoginScreen
        )
    }

    NavDisplay(
        backStack = backStack,
        onBack = {
            backStack.removeLastOrNull()
        },
        entryProvider = { key ->
            when (key) {
                is LoginScreen -> NavEntry(key) {
                    LoginScreen(onInitiateLogin = {

                    })
                }

                is OnboardingScreen -> NavEntry(key) {
                    OnboardingScreen()
                }

                else -> NavEntry(Unit) { Text("Unknown route") }
            }
        }
    )
}