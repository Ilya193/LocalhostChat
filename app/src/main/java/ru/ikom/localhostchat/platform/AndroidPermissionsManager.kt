package ru.ikom.localhostchat.platform

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import ru.ikom.core.common.platform.PermissionsManager

class AndroidPermissionsManager(
    private val applicationContext: Context
) : PermissionsManager {

    override fun checkRecordAudio(): Boolean {
        return ContextCompat.checkSelfPermission(
            applicationContext,
            android.Manifest.permission.RECORD_AUDIO
        ) == PackageManager.PERMISSION_GRANTED
    }
}