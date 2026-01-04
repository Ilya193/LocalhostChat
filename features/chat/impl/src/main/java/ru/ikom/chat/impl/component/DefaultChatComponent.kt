package ru.ikom.chat.impl.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import ru.ikom.chat.api.component.ChatComponent
import ru.ikom.chat.impl.view.ChatContent
import ru.ikom.core.common.platform.PermissionsManager

fun defaultChatComponentFactory(
    permissionsManager: PermissionsManager
) =
    ChatComponent.Factory {
        DefaultChatComponent(
            componentContext = it,
            permissionsManager = permissionsManager,
        )
    }

class DefaultChatComponent(
    private val componentContext: ComponentContext,
    private val permissionsManager: PermissionsManager,
) : ChatComponent, ComponentContext by componentContext {

    val state = MutableStateFlow(initialState())

    private val scope = coroutineScope()

    fun onInputMessage(message: String) {
        state.update { it.copy(message = message) }
    }

    fun onClickSend() {
        val state = state.value

        if (state.message.isEmpty()) return
    }

    @Composable
    override fun Content(modifier: Modifier) {
        ChatContent(modifier, this)
    }

    data class State(
        val message: String
    )
}

private fun initialState() =
    DefaultChatComponent.State(
        message = ""
    )