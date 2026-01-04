package ru.ikom.auth.api.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext

interface AuthComponent {

    @Composable
    fun Content(modifier: Modifier)

    fun interface Factory {
        operator fun invoke(
            componentContext: ComponentContext,
            onOpenChat: () -> Unit,
        ): AuthComponent
    }
}