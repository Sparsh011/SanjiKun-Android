package com.sparsh.sanjikun.feature.onboarding.onboarding.views.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sparsh.sanjikun.ui.theme.Purple500
import kotlinx.coroutines.delay


@Composable
fun AnimatedLoginContent(
    onInitiateLogin: () -> Unit
) {
    val text = "Welcome To \nSanjiKun!"
    var textState by remember {
        mutableStateOf("")
    }
    val infiniteTransition = rememberInfiniteTransition(label = "shimmer")

    val shimmerOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "shimmer"
    )

    LaunchedEffect(Unit) {
        text.indices.forEach { index ->
            delay(80)
            textState = textState + text[index]
        }
    }

    Text(
        text = textState,
        style = TextStyle(
            fontSize = 36.sp,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 2.sp,
            brush = Brush.linearGradient(
                colors = listOf(
                    Color.White,
                    Color(0xFFffeaa7),
                    Color.White
                ),
                start = Offset(shimmerOffset - 200f, 0f),
                end = Offset(shimmerOffset, 100f)
            ),
            shadow = Shadow(
                color = Color(0x80000000),
                offset = Offset(0f, 4f),
                blurRadius = 8f
            )
        ),
        textAlign = TextAlign.Start,
        modifier = Modifier
            .padding(horizontal = 1.dp)
    )

    AnimatedVisibility(
        visible = textState.length >= text.length,
        enter = fadeIn(animationSpec = tween(1000)) +
                slideInVertically(initialOffsetY = { it / 2 })
    ) {
        Column {

            Spacer(Modifier.height(30.dp))

            Text(
                text = "Sign in with your GitHub account to allow SanjiKun become more personalized than ever",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.White.copy(alpha = 0.9f),
                    letterSpacing = 2.sp
                ),
                modifier = Modifier.padding(8.dp),
            )

            Spacer(Modifier.height(100.dp))

            GitHubLoginButton(onInitiateLogin = onInitiateLogin)
        }
    }
}

@Composable
fun GitHubLoginButton(
    onInitiateLogin: () -> Unit
) {
    var isPressed by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.95f else 1f,
        animationSpec = spring(stiffness = Spring.StiffnessHigh),
        label = "scale"
    )

    Button(
        onClick = onInitiateLogin,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .scale(scale)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        isPressed = true
                        tryAwaitRelease()
                        isPressed = false
                    }
                )
            },
        colors = ButtonDefaults.buttonColors(
            containerColor = Purple500.copy(alpha = 0.85f)
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "GitHub",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "Continue with GitHub",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }
    }
}

@Composable
fun FloatingParticles() {
    val particles = remember {
        List(15) {
            ParticleState(
                x = (0..100).random().toFloat(),
                y = (0..100).random().toFloat(),
                size = (4..12).random().dp,
                duration = (3000..10000).random()
            )
        }
    }

    particles.forEach { particle ->
        FloatingParticle(particle)
    }
}

data class ParticleState(
    val x: Float,
    val y: Float,
    val size: Dp,
    val duration: Int
)

@Composable
fun FloatingParticle(particle: ParticleState) {
    val infiniteTransition = rememberInfiniteTransition(label = "particle")

    val offsetY by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = -100f,
        animationSpec = infiniteRepeatable(
            animation = tween(particle.duration, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "offsetY"
    )

    val alpha by infiniteTransition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.6f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "alpha"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .offset(
                    x = (particle.x * 0.01f * LocalConfiguration.current.screenWidthDp).dp,
                    y = (particle.y * 0.01f * LocalConfiguration.current.screenHeightDp).dp + offsetY.dp
                )
                .size(particle.size)
                .background(
                    color = Color.White.copy(alpha = alpha),
                    shape = CircleShape
                )
        )
    }
}
