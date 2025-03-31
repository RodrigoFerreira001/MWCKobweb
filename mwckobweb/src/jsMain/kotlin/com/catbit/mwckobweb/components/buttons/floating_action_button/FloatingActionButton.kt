package com.catbit.mwckobweb.components.buttons.floating_action_button

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.catbit.mwckobweb.foundation.locals.LocalIconSize
import com.catbit.mwckobweb.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.dom.GenericTag
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.px

@Composable
fun FloatingActionButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    label: String? = null,
    variant: FloatingActionButtonVariant = FloatingActionButtonVariant.Primary,
    size: FloatingActionButtonSize = FloatingActionButtonSize.Medium,
    containerShape: CSSLengthOrPercentageNumericValue = MaterialTheme.shape.large,
    containerColor: CSSColorValue = MaterialTheme.colorScheme.surfaceContainerHigh,
    containerLoweredColor: CSSColorValue = MaterialTheme.colorScheme.surfaceContainerLow,
    contentColor: CSSColorValue = MaterialTheme.colorScheme.primary,
    lowered: Boolean = false,
    content: (@Composable () -> Unit)? = null
) {
    GenericTag(
        name = "md-fab",
        attrs = modifier
            .cursor(Cursor.Pointer)
            .styleModifier {
                property(
                    "--md-fab-icon-size", when (size) {
                        FloatingActionButtonSize.Small,
                        FloatingActionButtonSize.Medium -> 24.px

                        FloatingActionButtonSize.Large -> 36.px
                    }
                )
                property("--md-fab-container-color", containerColor)
                property("--md-fab-icon-color", contentColor)
                property("--md-fab-lowered-container-color", containerLoweredColor)
                property("--md-fab-container-shape", containerShape)
            }
            .toAttrs {
                if (!enabled) {
                    attr("disabled", "")
                }
                if (lowered) {
                    attr("lowered", "")
                }
                label?.let { attr("label", label) }
                attr("variant", variant.variant)
                attr("size", size.size)
                ref { element ->
                    element.addEventListener("click", { onClick() })
                    onDispose { }
                }
            }
    ) {
        content?.let {
            CompositionLocalProvider(
                LocalIconSize provides when (size) {
                    FloatingActionButtonSize.Small,
                    FloatingActionButtonSize.Medium -> 24.px
                    FloatingActionButtonSize.Large -> 36.px
                }
            ) {
                Box(
                    modifier = Modifier
                        .attrsModifier {
                            attr("slot", "icon")
                        }
                ) {
                    content()
                }
            }
        }
    }
}

enum class FloatingActionButtonVariant(internal val variant: String) {
    Primary("primary"),
    Secondary("secondary"),
    Tertiary("tertiary")
}

enum class FloatingActionButtonSize(internal val size: String) {
    Small("small"),
    Medium("medium"),
    Large("large")
}