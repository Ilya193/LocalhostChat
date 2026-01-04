package ru.ikom.auth.impl.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ru.ikom.auth.impl.component.DefaultAuthComponent

@Composable
internal fun AuthContent(
    modifier: Modifier,
    component: DefaultAuthComponent
) {
    Box(
        modifier = modifier.background(Color.Cyan)
    )
}