package ru.ikom.core.user_logic.user_data

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import ru.ikom.core.datasources.user.api.UserLocalDataSource
import ru.ikom.core.user_logic.user_domain.UserRepository
import java.util.UUID

class DefaultUserRepository(
    private val userLocalDataSource: UserLocalDataSource
) : UserRepository {

    override suspend fun auth(): Result<Unit> {
        try {
            val token = userLocalDataSource.getToken()

            if (token != null) {
                return Result.success(Unit)
            }

            val newToken = UUID.randomUUID().toString()
            userLocalDataSource.saveToken(newToken)

            delay(1500)

            return Result.success(Unit)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }
}