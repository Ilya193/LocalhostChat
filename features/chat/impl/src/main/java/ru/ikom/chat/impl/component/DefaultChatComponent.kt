package ru.ikom.chat.impl.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext
import ru.ikom.chat.api.component.ChatComponent
import ru.ikom.chat.impl.view.ChatContent

fun defaultChatComponentFactory() =
    ChatComponent.Factory {
        DefaultChatComponent(
            componentContext = it
        )
    }

class DefaultChatComponent(
    private val componentContext: ComponentContext,
) : ChatComponent, ComponentContext by componentContext {

    @Composable
    override fun Content(modifier: Modifier) {
        ChatContent(modifier, this)
    }
}