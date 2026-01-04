package ru.ikom.root.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import ru.ikom.auth.api.component.AuthComponent
import ru.ikom.chat.api.component.ChatComponent
import ru.ikom.root.component.DefaultRootComponent.Child.*
import ru.ikom.root.view.RootContent

fun defaultRootComponentFactory(
    authComponentFactory: AuthComponent.Factory,
    chatComponentFactory: ChatComponent.Factory,
) =
    RootComponent.Factory {
        DefaultRootComponent(
            componentContext = it,
            authComponentFactory = authComponentFactory,
            chatComponentFactory = chatComponentFactory,
        )
    }

internal class DefaultRootComponent(
    private val componentContext: ComponentContext,
    private val authComponentFactory: AuthComponent.Factory,
    private val chatComponentFactory: ChatComponent.Factory,
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    val childStack: Value<ChildStack<*, Child>> =
        childStack(
            source = navigation,
            serializer = Config.serializer(),
            initialConfiguration = Config.Auth,
            handleBackButton = true,
            childFactory = ::createChild,
        )

    private fun createChild(config: Config, componentContext: ComponentContext): Child =
        when (config) {
            is Config.Auth -> AuthChild(authComponentFactory(componentContext))
            is Config.Chat -> ChatChild(chatComponentFactory(componentContext))
        }

    @Composable
    override fun Content(modifier: Modifier) {
        RootContent(modifier, this)
    }

    sealed interface Child {
        class AuthChild(val authComponent: AuthComponent) : Child
        class ChatChild(val chatComponent: ChatComponent) : Child
    }

    @Serializable
    private sealed interface Config {
        @Serializable
        data object Auth : Config

        @Serializable
        data object Chat : Config
    }
}