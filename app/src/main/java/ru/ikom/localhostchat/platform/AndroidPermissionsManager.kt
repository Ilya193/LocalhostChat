package ru.ikom.localhostchat.platform

import android.content.pm.PackageManager
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import kotlinx.coroutines.suspendCancellableCoroutine
import ru.ikom.core.common.platform.PermissionsManager
import kotlin.coroutines.resume

class AndroidPermissionsManager(
    private val activity: ComponentActivity
) : PermissionsManager {

    override fun checkRecordAudio(): Boolean {
        return ContextCompat.checkSelfPermission(
            activity,
            android.Manifest.permission.RECORD_AUDIO
        ) == PackageManager.PERMISSION_GRANTED
    }

    override fun launchRecordAudio(callback: (result: Boolean) -> Unit) {
        activity.registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            callback(it)
        }
    }

    override suspend fun suspendLaunchRecordAudio(): Boolean =
        suspendCancellableCoroutine { cont ->
            val callback = ActivityResultCallback<Boolean> { result ->
                if (cont.isActive) {
                    cont.resume(result)
                }
            }

            val result =
                activity.registerForActivityResult(
                    contract = ActivityResultContracts.RequestPermission(),
                    callback = callback
                )

            result.launch(android.Manifest.permission.RECORD_AUDIO)

            cont.invokeOnCancellation { result.unregister() }
        }
}