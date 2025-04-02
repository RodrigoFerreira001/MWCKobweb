package dev.catbit.mwckobweb.components.chip

import androidx.compose.runtime.Composable
import dev.catbit.mwckobweb.foundation.text.FontFamily
import dev.catbit.mwckobweb.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.px

@Composable
fun AssistChip(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    outlineColor: CSSColorValue = MaterialTheme.colorScheme.outline,
    contentColor: CSSColorValue = MaterialTheme.colorScheme.onSurface,
    iconSize: CSSLengthOrPercentageNumericValue = 18.px,
    shape: CSSLengthOrPercentageNumericValue = MaterialTheme.shape.small,
    font: FontFamily? = MaterialTheme.typography.labelLarge.fontFamily,
    icon: (@Composable () -> Unit)? = null
) {
    BaseChip(
        modifier = modifier
            .styleModifier {
                property("--md-assist-chip-outline-color", outlineColor)
                property("--md-assist-chip-container-shape", shape)
                property("--md-assist-chip-icon-size", iconSize)
                property("--md-assist-chip-label-text-color", contentColor)
                font?.let { property("--md-assist-chip-label-text-font", font.name) }
            },
        label = label,
        onClick = onClick,
        iconSize = iconSize,
        chipStyle = "md-assist-chip",
        enabled = enabled,
        icon = icon
    )
}