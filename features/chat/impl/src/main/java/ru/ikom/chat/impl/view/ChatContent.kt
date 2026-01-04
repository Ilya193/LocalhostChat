package ru.ikom.chat.impl.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.ikom.chat.impl.component.DefaultChatComponent

@Composable
internal fun ChatContent(
    modifier: Modifier = Modifier,
    component: DefaultChatComponent
) {
    Box(
        modifier = modifier
            .imePadding()
            .systemBarsPadding()
            .padding(horizontal = 16.dp)
    ) {
        val state = component.state.collectAsStateWithLifecycle()

        InputContent(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .wrapContentHeight(),
            message = state.value.message,
            isVisibleSend = state.value.message.isNotEmpty(),
            onInputMessage = component::onInputMessage,
            onClickSend = component::onClickSend,
        )
    }
}

@Composable
private fun InputContent(
    modifier: Modifier = Modifier,
    message: String,
    isVisibleSend: Boolean,
    onInputMessage: (String) -> Unit,
    onClickSend: () -> Unit,
) {
    Row(
        modifier = modifier
    ) {
        InputMessageContent(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            message = message,
            isVisibleSend = isVisibleSend,
            onInput = onInputMessage,
            onClickSend = onClickSend,
        )
    }
}

@Preview(device = "spec:width=2340px,height=1080px,dpi=394,isRound=false,chinSize=0px,orientation=landscape")
@Composable
private fun PreviewInputContent() {
    Box(
        modifier = Modifier.size(300.dp)
    ) {
        InputContent(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .wrapContentHeight(),
            message = "preview",
            isVisibleSend = true,
            onInputMessage = {},
            onClickSend = {},
        )
    }
}