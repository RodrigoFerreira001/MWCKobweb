package dev.catbit.mwckobweb.components.chip

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import dev.catbit.mwckobweb.foundation.locals.LocalIconSize
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.dom.GenericTag
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.px

@Composable
internal fun BaseChip(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit,
    onRemove: (() -> Unit)? = null,
    chipStyle: String,
    enabled: Boolean = true,
    icon: (@Composable () -> Unit)? = null,
    iconSize: CSSLengthOrPercentageNumericValue = 18.px
) {
    GenericTag(
        name = chipStyle,
        attrs = modifier
            .minHeight(32.px)
            .cursor(Cursor.Pointer)
            .toAttrs {
                if (!enabled) { attr("disabled", "") }
                attr("label", label)
                ref { element ->
                    element.addEventListener("click", { onClick() })
                    onRemove?.let { element.addEventListener("remove", { onRemove() }) }
                    onDispose { }
                }
            }
    ) {
        icon?.let {
            CompositionLocalProvider(
                LocalIconSize provides iconSize
            ) {
                Box(
                    modifier = Modifier.attrsModifier {
                        attr("slot", "icon")
                    }
                ) {
                    icon()
                }
            }
        }
    }
}