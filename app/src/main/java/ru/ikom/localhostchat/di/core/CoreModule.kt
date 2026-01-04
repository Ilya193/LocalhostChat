package ru.ikom.localhostchat.di.core

import ru.ikom.core.user_logic.user_data.di.UserLogicModule

interface CoreModule {

    val userLogicModule: UserLogicModule
}