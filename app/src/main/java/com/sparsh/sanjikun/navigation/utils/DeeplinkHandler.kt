package com.sparsh.sanjikun.navigation.utils

import com.sparsh.sanjikun.common.util.log
import com.sparsh.sanjikun.navigation.screens.GitHubReposScreen
import com.sparsh.sanjikun.navigation.screens.InnerHostScreen
import com.sparsh.sanjikun.navigation.screens.LoginScreen
import com.sparsh.sanjikun.navigation.screens.OnboardingScreen
import com.sparsh.sanjikun.navigation.screens.ProfileScreen
import com.sparsh.sanjikun.navigation.screens.Screen
import com.sparsh.sanjikun.navigation.screens.VoiceChatScreen

object DeeplinkHandler {
    fun process(deeplink: String?): Screen? {
        val screen = deeplink.map()
        if (screen == null) {
            deeplink.log(method = "Processing deeplink")
            return null
        }

        return screen
    }

    private fun String?.map(): Screen? {
        return when {
            isNullOrBlank() -> null
            startsWith("skun://profile_screen") -> {
                ProfileScreen
            }

            startsWith("skun://voice_chat_screen") -> {
                VoiceChatScreen
            }

            startsWith("skun://github_repos_screen") -> {
                GitHubReposScreen
            }

            startsWith("skun://login_screen") -> {
                LoginScreen
            }

            startsWith("skun://onboarding_screen") -> {
                OnboardingScreen
            }

            startsWith("skun://inner_host_screen") -> {
                InnerHostScreen
            }

            else -> {
                null
            }
        }
    }
}