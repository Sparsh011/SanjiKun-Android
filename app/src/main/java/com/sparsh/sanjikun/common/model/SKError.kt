package com.sparsh.sanjikun.common.model

data class SKError(
    val errorCode: Int,
    val errorMessage: String,
    val exception: Throwable? = null
)
