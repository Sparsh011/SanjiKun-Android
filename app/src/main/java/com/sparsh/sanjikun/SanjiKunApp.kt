package com.sparsh.sanjikun

import android.app.Application

class SanjiKunApp: Application() {
    companion object {
        lateinit var app: SanjiKunApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        app = this

    }
}