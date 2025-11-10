package com.sparsh.sanjikun.common.db.datatstore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SanjiKunDS(
    private val context: Context
) {
    private val ACCESS_TOKEN = stringPreferencesKey("sk_access_token")
    private val REFRESH_TOKEN = stringPreferencesKey("sk_refresh_token")

    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "sanjikun_ds")

    val accessToken: Flow<String?> =
        context.dataStore.data.map { preferences ->
            preferences[ACCESS_TOKEN]
        }

    val refreshToken: Flow<String?> =
        context.dataStore.data.map { preferences ->
            preferences[REFRESH_TOKEN]
        }

    suspend fun setAccessToken(token: String) {
        context.dataStore.edit { prefs ->
            prefs[ACCESS_TOKEN] = token
        }
    }

    suspend fun setRefreshToken(token: String) {
        context.dataStore.edit { prefs ->
            prefs[REFRESH_TOKEN] = token
        }
    }
}