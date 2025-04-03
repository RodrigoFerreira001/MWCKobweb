package dev.catbit.kobwebmaterial.components.chip

import androidx.compose.runtime.Composable
import dev.catbit.kobwebmaterial.foundation.text.FontFamily
import dev.catbit.kobwebmaterial.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.px

@Composable
fun InputChip(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit,
    onRemove: () -> Unit,
    enabled: Boolean = true,
    selected: Boolean = false,
    selectedContainerColor: CSSColorValue = MaterialTheme.colorScheme.secondaryContainer,
    outlineColor: CSSColorValue = MaterialTheme.colorScheme.outline,
    contentColor: CSSColorValue = MaterialTheme.colorScheme.onSurface,
    iconSize: CSSLengthOrPercentageNumericValue = 18.px,
    shape: CSSLengthOrPercentageNumericValue = MaterialTheme.shape.small,
    font: FontFamily? = MaterialTheme.typography.labelLarge.fontFamily,
    avatar: Boolean = false,
    icon: (@Composable () -> Unit)? = null
) {
    BaseChip(
        modifier = modifier
            .styleModifier {
                property("--md-input-chip-selected-container-color", selectedContainerColor)
                property("--md-input-chip-outline-color", outlineColor)
                property("--md-input-chip-container-shape", shape)
                property("--md-input-chip-icon-size", iconSize)
                property("--md-input-chip-label-text-color", contentColor)
                font?.let { property("--md-input-chip-label-text-font", font.name) }
            }
            .attrsModifier {
                if (selected) attr("selected", "")
                if (avatar) attr("avatar", "")
            },
        label = label,
        iconSize = iconSize,
        onClick = onClick,
        onRemove = onRemove,
        chipStyle = "md-input-chip",
        enabled = enabled,
        icon = icon
    )
}