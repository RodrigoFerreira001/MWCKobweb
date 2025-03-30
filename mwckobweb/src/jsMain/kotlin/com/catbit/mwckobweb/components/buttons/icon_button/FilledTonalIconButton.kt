package com.catbit.mwckobweb.components.buttons.icon_button

import androidx.compose.runtime.Composable
import com.catbit.mwckobweb.components.buttons.icon_button.BaseIconButton
import com.varabyte.kobweb.compose.ui.Modifier

@Composable
fun FilledTonalIconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    content: @Composable () -> Unit
) {
    BaseIconButton(
        modifier = modifier,
        buttonStyle = "md-filled-tonal-icon-button",
        onClick = onClick,
        enabled = enabled,
        content = content,
    )
}