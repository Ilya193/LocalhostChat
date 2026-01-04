package ru.ikom.chat.impl.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import ru.ikom.chat.impl.R

@Composable
internal fun InputMessageContent(
    modifier: Modifier = Modifier,
    message: String,
    isVisibleSend: Boolean,
    onInput: (newMessage: String) -> Unit,
    onClickSend: () -> Unit,
) {
    val textFieldState = rememberTextFieldState()

    LaunchedEffect(Unit) {
        snapshotFlow { textFieldState.text.toString() }
            .distinctUntilChanged()
            .collectLatest {
                onInput(it)
            }
    }

    LaunchedEffect(message) {
        if (message != textFieldState.text.toString()) {
            textFieldState.edit {
                replace(0, length, message)
            }
        }
    }

    OutlinedTextField(
        modifier = modifier,
        state = textFieldState,
        trailingIcon = {
            AnimatedVisibility(
                visible = isVisibleSend,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Image(
                    modifier = Modifier
                        .size(32.dp)
                        .clickable(
                            interactionSource = null,
                            indication = null,
                            onClick = onClickSend
                        ),
                    painter = painterResource(R.drawable.ic_send),
                    colorFilter = ColorFilter.tint(Color.Blue),
                    contentDescription = "send",
                )
            }
        }
    )
}