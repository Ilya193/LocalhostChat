package ru.ikom.core.datasources.user.impl.di

import android.content.SharedPreferences
import ru.ikom.core.datasources.user.api.UserLocalDataSource
import ru.ikom.core.datasources.user.impl.SharedPreferencesUserLocalDataSource

interface UserDataSourceModule {
    val userLocalDataSource: UserLocalDataSource
}

fun UserDataSourceModule(
    sharedPreferences: SharedPreferences
): UserDataSourceModule =
    object : UserDataSourceModule {

        override val userLocalDataSource: UserLocalDataSource =
            SharedPreferencesUserLocalDataSource(sharedPreferences)
    }