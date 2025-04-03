package dev.catbit.kobwebmaterial.components.buttons.icon_button

import androidx.compose.runtime.Composable
import dev.catbit.kobwebmaterial.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.px

@Composable
fun FilledTonalIconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    selected: Boolean = false,
    selectedColor: CSSColorValue = MaterialTheme.colorScheme.primary,
    shape: CSSLengthOrPercentageNumericValue = MaterialTheme.shape.full,
    iconSize: CSSLengthOrPercentageNumericValue = 24.px,
    content: @Composable () -> Unit
) {
    BaseIconButton(
        modifier = modifier
            .styleModifier {
            property("--md-filled-tonal-icon-button-selected-container-color", selectedColor)
            property("--md-filled-tonal-icon-button-container-shape", shape)
            property("--md-filled-tonal-icon-button-icon-size", iconSize)
        },
        onClick = onClick,
        buttonStyle = "md-filled-tonal-icon-button",
        enabled = enabled,
        selected = selected,
        content = content,
        iconSize = iconSize,
    )
}