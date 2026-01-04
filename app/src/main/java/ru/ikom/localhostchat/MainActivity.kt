package ru.ikom.localhostchat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.defaultComponentContext
import ru.ikom.localhostchat.app.App
import ru.ikom.localhostchat.di.AppContainer
import ru.ikom.localhostchat.platform.AndroidPermissionsManager
import ru.ikom.localhostchat.ui.theme.LocalhostChatTheme

class MainActivity : ComponentActivity() {

    private val appContainer: AppContainer by lazy(LazyThreadSafetyMode.NONE) {
        (applicationContext as App).appContainer
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        appContainer.permissionsManager = AndroidPermissionsManager(this)

        // configChanges was changed
        val component = appContainer.featuresProvider
            .provideRootComponentFactory().invoke(defaultComponentContext())

        setContent {
            LocalhostChatTheme {
                component.Content(modifier = Modifier.fillMaxSize())
            }
        }
    }
}