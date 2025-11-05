package com.sparsh.sanjikun.common.viewmodel

import androidx.lifecycle.AndroidViewModel
import com.sparsh.sanjikun.SanjiKunApp
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import com.sparsh.one_piece.ui.morgans.UiEvent
import com.sparsh.one_piece.ui.morgans.UiResponseTypes
import com.sparsh.one_piece.ui.morgans.UiState

open class BaseVM : AndroidViewModel(application = SanjiKunApp.app) {
    private val _uiState = MutableStateFlow(
        value = UiState<UiResponseTypes>(isIdle = true)
    )
    open val uiState = _uiState.asStateFlow()

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    open val uiEvent = _uiEvent.asSharedFlow()

    fun updateUiState(newUiState: UiState<UiResponseTypes>) {
        _uiState.value = newUiState
    }

    suspend fun emitEvent(event: UiEvent) {
        _uiEvent.emit(event)
    }
}