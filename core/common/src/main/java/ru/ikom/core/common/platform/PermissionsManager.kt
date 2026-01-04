package ru.ikom.core.common.platform

interface PermissionsManager {

    fun checkRecordAudio(): Boolean

    fun launchRecordAudio(callback: (result: Boolean) -> Unit)

    suspend fun suspendLaunchRecordAudio(): Boolean
}