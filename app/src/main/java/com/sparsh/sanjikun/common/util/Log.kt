package com.sparsh.sanjikun.common.util

import android.util.Log

fun Any?.log(
    method: String? = null,
    tag: String = "SanjiKun",
) {
    if (this is Exception) {
        Log.e(tag, "${if (method.isNullOrBlank()) "Log" else method}: ${this.message}")
    } else {
        Log.d(tag, "${if (method.isNullOrBlank()) "Log" else method}: ${this.toString()}")
    }
}