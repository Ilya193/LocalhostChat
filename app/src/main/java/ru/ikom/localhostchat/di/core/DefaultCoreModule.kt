package ru.ikom.localhostchat.di.core

import android.content.Context
import android.content.SharedPreferences
import ru.ikom.core.datasources.user.impl.di.UserDataSourceModule
import ru.ikom.core.user_logic.user_data.di.UserLogicModule

private const val KEY_VALUE_STORAGE_NAME = "spkvadw"

class DefaultCoreModule(
    private val applicationContext: Context
) : CoreModule {

    private val sharedPreferences: SharedPreferences by lazy {
        applicationContext.getSharedPreferences(KEY_VALUE_STORAGE_NAME, Context.MODE_PRIVATE)
    }

    private val userDataSourceModule: UserDataSourceModule by lazy {
        UserDataSourceModule(
            sharedPreferences = sharedPreferences
        )
    }

    override val userLogicModule: UserLogicModule by lazy {
        UserLogicModule(
            userLocalDataSource = userDataSourceModule.userLocalDataSource
        )
    }
}