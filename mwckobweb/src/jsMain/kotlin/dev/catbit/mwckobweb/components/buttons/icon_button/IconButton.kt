package dev.catbit.mwckobweb.components.buttons.icon_button

import androidx.compose.runtime.Composable
import dev.catbit.mwckobweb.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.px

@Composable
fun IconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    selected: Boolean = false,
    iconColor: CSSColorValue = MaterialTheme.colorScheme.onSurfaceVariant,
    shape: CSSLengthOrPercentageNumericValue = MaterialTheme.shape.full,
    iconSize: CSSLengthOrPercentageNumericValue = 24.px,
    content: @Composable () -> Unit
) {
    BaseIconButton(
        modifier = modifier.styleModifier {
            property("--md-icon-button-icon-color", iconColor)
            property("--md-icon-button-state-layer-shape", shape)
            property("--md-icon-button-icon-size", iconSize)
        },
        buttonStyle = "md-icon-button",
        onClick = onClick,
        enabled = enabled,
        selected = selected,
        iconSize = iconSize,
        content = content,
    )
}