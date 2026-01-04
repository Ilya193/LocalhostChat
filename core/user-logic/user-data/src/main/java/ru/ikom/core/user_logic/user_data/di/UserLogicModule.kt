package ru.ikom.core.user_logic.user_data.di

import ru.ikom.core.datasources.user.api.UserLocalDataSource
import ru.ikom.core.user_logic.user_data.DefaultUserRepository
import ru.ikom.core.user_logic.user_domain.UserRepository

interface UserLogicModule {
    val userRepository: UserRepository
}

fun UserLogicModule(
    userLocalDataSource: UserLocalDataSource
): UserLogicModule =
    object : UserLogicModule {

        override val userRepository: UserRepository =
            DefaultUserRepository(userLocalDataSource)
    }