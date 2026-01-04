package ru.ikom.root.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import ru.ikom.chat.api.component.ChatComponent
import ru.ikom.root.view.RootContent

fun defaultRootComponentFactory(
    chatComponentFactory: ChatComponent.Factory
) =
    RootComponent.Factory {
        DefaultRootComponent(
            componentContext = it,
            chatComponentFactory = chatComponentFactory,
        )
    }

internal class DefaultRootComponent(
    private val componentContext: ComponentContext,
    private val chatComponentFactory: ChatComponent.Factory
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    val childStack: Value<ChildStack<*, Child>> =
        childStack(
            source = navigation,
            serializer = Config.serializer(),
            initialConfiguration = Config.Chat,
            handleBackButton = true,
            childFactory = ::createChild,
        )

    private fun createChild(config: Config, componentContext: ComponentContext): Child =
        when (config) {
            is Config.Chat -> Child.ChatChild(chatComponentFactory(componentContext))
        }

    @Composable
    override fun Content(modifier: Modifier) {
        RootContent(modifier, this)
    }

    sealed interface Child {
        class ChatChild(val chatComponent: ChatComponent) : Child
    }

    @Serializable
    private sealed interface Config {
        @Serializable
        data object Chat : Config
    }
}