package com.sparsh.sanjikun

import android.app.Application
import com.sparsh.one_piece.den_den_mushi.OnePiece
import com.sparsh.sanjikun.common.network.GrandLineImplementation
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SanjiKunApp : Application() {
    companion object {
        lateinit var app: SanjiKunApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        OnePiece.start(GrandLineImplementation())
    }
}