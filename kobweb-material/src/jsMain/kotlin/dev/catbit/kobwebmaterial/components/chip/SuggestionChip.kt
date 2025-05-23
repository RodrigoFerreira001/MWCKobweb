package dev.catbit.kobwebmaterial.components.chip

import androidx.compose.runtime.Composable
import dev.catbit.kobwebmaterial.foundation.text.FontFamily
import dev.catbit.kobwebmaterial.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.CSSColorValue

@Composable
fun SuggestionChip(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    outlineColor: CSSColorValue = MaterialTheme.colorScheme.outline,
    contentColor: CSSColorValue = MaterialTheme.colorScheme.onSurface,
    shape: CSSLengthOrPercentageNumericValue = MaterialTheme.shape.small,
    font: FontFamily? = MaterialTheme.typography.labelLarge.fontFamily,
) {
    BaseChip(
        modifier = modifier
            .styleModifier {
                property("--md-suggestion-chip-outline-color", outlineColor)
                property("--md-suggestion-chip-container-shape", shape)
                property("--md-suggestion-chip-label-text-color", contentColor)
                font?.let { property("--md-suggestion-chip-label-text-font", font.name) }
            },
        label = label,
        onClick = onClick,
        chipStyle = "md-suggestion-chip",
        enabled = enabled,
        icon = null
    )
}