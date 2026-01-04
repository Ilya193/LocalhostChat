package ru.ikom.auth.impl.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import kotlinx.coroutines.launch
import ru.ikom.auth.api.component.AuthComponent
import ru.ikom.auth.impl.view.AuthContent
import ru.ikom.core.user_logic.user_domain.UserRepository

fun defaultAuthComponentFactory(
    userRepository: UserRepository
) =
    AuthComponent.Factory { componentContext, onOpenChat ->
        DefaultAuthComponent(
            componentContext = componentContext,
            userRepository = userRepository,
            onOpenChat = onOpenChat,
        )
    }

internal class DefaultAuthComponent(
    private val componentContext: ComponentContext,
    private val userRepository: UserRepository,
    private val onOpenChat: () -> Unit,
) : AuthComponent, ComponentContext by componentContext {

    private val scope = coroutineScope()

    init {
        scope.launch {
            userRepository.auth()

            onOpenChat()
        }
    }

    @Composable
    override fun Content(modifier: Modifier) {
        AuthContent(modifier, this)
    }
}