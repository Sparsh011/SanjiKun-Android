package com.sparsh.sanjikun.common.model

data class UiState <T> (
    val data: T? = null,
    val isLoading: Boolean = false,
    val isIdle: Boolean = false,
    val error: SKError? = null
)