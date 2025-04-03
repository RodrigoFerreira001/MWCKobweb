package dev.catbit.kobwebmaterial.components.buttons.common_buttons

import androidx.compose.runtime.Composable
import dev.catbit.kobwebmaterial.foundation.text.FontFamily
import dev.catbit.kobwebmaterial.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.foundation.layout.RowScope
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.CSSColorValue

@Composable
fun FilledTonalButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    containerColor: CSSColorValue = MaterialTheme.colorScheme.secondaryContainer,
    contentColor: CSSColorValue = MaterialTheme.colorScheme.onSecondaryContainer,
    shape: CSSLengthOrPercentageNumericValue = MaterialTheme.shape.full,
    font: FontFamily? = MaterialTheme.typography.labelLarge.fontFamily,
    content: @Composable RowScope.() -> Unit
) {
    BaseButton(
        modifier = modifier.styleModifier {
            property("--md-filled-tonal-button-container-color", containerColor)
            property("--md-filled-tonal-button-container-shape", shape)
            property("--md-filled-tonal-button-label-text-color", contentColor)
            font?.let { property("--md-filled-tonal-button-label-text-font", font.name) }
        },
        onClick = onClick,
        buttonStyle = "md-filled-tonal-button",
        enabled = enabled,
        content = content
    )
}