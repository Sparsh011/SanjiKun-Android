package com.sparsh.sanjikun.common.model

import android.widget.Toast

sealed class UiEvent {
    data class ShowToast(val message: String, val length: Int = Toast.LENGTH_SHORT): UiEvent()
    data object ShowLoader: UiEvent()
    data class Navigate(val route: String): UiEvent()
}
