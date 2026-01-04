package ru.ikom.auth.impl.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext
import ru.ikom.auth.api.component.AuthComponent
import ru.ikom.auth.impl.view.AuthContent

fun defaultAuthComponentFactory() =
    AuthComponent.Factory {
        DefaultAuthComponent(
            componentContext = it
        )
    }

internal class DefaultAuthComponent(
    private val componentContext: ComponentContext
) : AuthComponent, ComponentContext by componentContext {

    @Composable
    override fun Content(modifier: Modifier) {
        AuthContent(modifier, this)
    }
}