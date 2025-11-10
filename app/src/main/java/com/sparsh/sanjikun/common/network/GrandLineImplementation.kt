package com.sparsh.sanjikun.common.network

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.sparsh.one_piece.den_den_mushi.GrandLine
import com.sparsh.sanjikun.BuildConfig
import com.sparsh.sanjikun.SanjiKunApp
import okhttp3.Interceptor

class GrandLineImplementation : GrandLine {
    override fun getBaseUrl(): String {
        return BuildConfig.BASE_URL
    }

    override fun getTimeout(): Long {
        return 30
    }

    override fun getInterceptors(): List<Interceptor> {
        return listOf(
            ChuckerInterceptor(SanjiKunApp.app)
        )
    }

    override fun getStaticHeaders(): Map<String, String> {
        return emptyMap()
    }

    override fun getRuntimeHeaders(): Map<String, String> {
        return emptyMap()
    }
}