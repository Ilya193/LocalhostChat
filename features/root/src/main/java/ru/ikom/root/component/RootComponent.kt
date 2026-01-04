package ru.ikom.root.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext

interface RootComponent {

    @Composable
    fun Content(modifier: Modifier)

    fun interface Factory {
        operator fun invoke(componentContext: ComponentContext): RootComponent
    }
}