package ru.ikom.core.user_logic.user_domain

interface UserRepository {

    suspend fun auth(): Result<Unit>
}