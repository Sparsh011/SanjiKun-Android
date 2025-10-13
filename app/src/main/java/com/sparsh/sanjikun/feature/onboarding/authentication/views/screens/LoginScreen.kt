package com.sparsh.sanjikun.feature.onboarding.authentication.views.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.sparsh.sanjikun.feature.onboarding.onboarding.views.components.AnimatedLoginContent
import com.sparsh.sanjikun.feature.onboarding.onboarding.views.components.FloatingParticles
import com.sparsh.sanjikun.ui.theme.Purple700
import com.sparsh.sanjikun.ui.theme.Purple800

@Composable
fun LoginScreen(modifier: Modifier = Modifier, onInitiateLogin: () -> Unit) {
    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(
                start = innerPadding.calculateStartPadding
                    (LayoutDirection.Ltr),
                end = innerPadding.calculateEndPadding(
                    LayoutDirection
                        .Ltr
                ),
                bottom = innerPadding.calculateBottomPadding()
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Purple800,
                                Purple700,
                            )
                        )
                    )
                    .padding(top = 100.dp)
            ) {
                FloatingParticles()

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 15.dp),
                    verticalArrangement = Arrangement.Top
                ) {
                    AnimatedLoginContent(onInitiateLogin = onInitiateLogin)
                }
            }
        }
    }
}