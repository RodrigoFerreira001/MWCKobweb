package com.catbit.mwckobweb.components.buttons.common_buttons

import androidx.compose.runtime.Composable
import com.catbit.mwckobweb.components.buttons.common_buttons.BaseButton
import com.varabyte.kobweb.compose.foundation.layout.RowScope
import com.varabyte.kobweb.compose.ui.Modifier

@Composable
fun FilledButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit
) {
    BaseButton(
        modifier = modifier,
        onClick = onClick,
        buttonStyle = "md-filled-button",
        enabled = enabled,
        content = content
    )
}