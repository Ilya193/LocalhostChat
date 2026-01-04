package ru.ikom.localhostchat.platform

import ru.ikom.core.common.platform.PermissionsManager

class NoOpPermissionsManager : PermissionsManager {
    override fun checkRecordAudio(): Boolean {
        TODO("Not yet implemented")
    }

    override fun launchRecordAudio(callback: (result: Boolean) -> Unit) {
        TODO("Not yet implemented")
    }

    override suspend fun suspendLaunchRecordAudio(): Boolean {
        TODO("Not yet implemented")
    }
}