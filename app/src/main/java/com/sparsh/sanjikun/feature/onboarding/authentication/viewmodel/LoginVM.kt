package com.sparsh.sanjikun.feature.onboarding.authentication.viewmodel

import com.sparsh.one_piece.ui.morgans.UiEvent
import com.sparsh.one_piece.ui.morgans.UiResponseTypes
import com.sparsh.one_piece.ui.morgans.UiState
import com.sparsh.sanjikun.common.viewmodel.BaseVM
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

class LoginVM : BaseVM() {
    override val uiState: StateFlow<UiState<UiResponseTypes>>
        get() = super.uiState

    override val uiEvent: SharedFlow<UiEvent>
        get() = super.uiEvent


    fun initiateGitHubAuth() {

    }

}