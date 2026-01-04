package ru.ikom.core.datasources.user.impl

import android.content.SharedPreferences
import androidx.core.content.edit
import ru.ikom.core.datasources.user.api.UserLocalDataSource

class SharedPreferencesUserLocalDataSource(
    private val sharedPreferences: SharedPreferences
) : UserLocalDataSource {

    override suspend fun saveToken(token: String) {
        sharedPreferences.edit {
            putString(TOKEN_KEY, token)
        }
    }

    override suspend fun getToken(): String? {
        return sharedPreferences.getString(TOKEN_KEY, null)
    }
}

private const val TOKEN_KEY = "qweobsdfasdf"