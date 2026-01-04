package ru.ikom.root.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import ru.ikom.root.component.DefaultRootComponent

@Composable
internal fun RootContent(
    modifier: Modifier = Modifier,
    component: DefaultRootComponent
) {
    Box(
        modifier = modifier
    ) {
        Children(
            component.childStack
        ) {
            when (val child = it.instance) {
                is DefaultRootComponent.Child.AuthChild -> child.authComponent.Content(Modifier.fillMaxSize())
                is DefaultRootComponent.Child.ChatChild -> child.chatComponent.Content(Modifier.fillMaxSize())
            }
        }
    }
}