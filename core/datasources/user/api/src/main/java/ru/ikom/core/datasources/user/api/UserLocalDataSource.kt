package ru.ikom.core.datasources.user.api

interface UserLocalDataSource {

    suspend fun saveToken(token: String)

    suspend fun getToken(): String?
}