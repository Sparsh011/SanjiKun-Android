package com.sparsh.sanjikun.navigation.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.sparsh.sanjikun.feature.onboarding.authentication.views.screens.LoginScreen
import com.sparsh.sanjikun.feature.onboarding.onboarding.views.screens.OnboardingScreen
import com.sparsh.sanjikun.navigation.screens.LoginScreen
import com.sparsh.sanjikun.navigation.screens.OnboardingScreen

@Composable
fun AppNavigation(deeplink: String) {
    val backStack = remember {
        mutableStateListOf(
            deeplink
        )
    }

    NavDisplay(
        backStack = backStack,
        onBack = {
            backStack.removeLastOrNull()
        },
        entryProvider = { key ->
            val screen = DeeplinkHandler.process(key)
            when (screen) {
                is LoginScreen -> NavEntry(key) {
                    LoginScreen(
                        onInitiateLogin = {

                        }
                    )
                }

                is OnboardingScreen -> NavEntry(key) {
                    OnboardingScreen()
                }

                else -> NavEntry(screen?.deeplink().toString()) {
                    InvalidRouteScreen(
                        route =
                            screen?.deeplink(), onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }
            }
        }
    )
}

@Composable
fun InvalidRouteScreen(route: String?, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        onBack()
                    }
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Text("Something Went Wrong! ${route}")
        }
    }
}