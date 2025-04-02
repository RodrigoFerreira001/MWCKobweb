package dev.catbit.mwckobweb.components.overlays.dialog

import androidx.compose.runtime.*
import dev.catbit.mwckobweb.components.overlays.OverlayClosedBackgroundStyle
import dev.catbit.mwckobweb.components.overlays.OverlayOpenedBackgroundStyle
import dev.catbit.mwckobweb.foundation.locals.LocalTextStyle
import dev.catbit.mwckobweb.foundation.modifiers.then
import dev.catbit.mwckobweb.foundation.modifiers.thenIf
import dev.catbit.mwckobweb.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.css.PointerEvents
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.shapes.RectF
import com.varabyte.kobweb.silk.theme.shapes.clip
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.px

@Composable
fun Dialog(
    modifier: Modifier = Modifier,
    visible: Boolean,
    onDismissRequest: () -> Unit = {},
    shape: CSSLengthOrPercentageNumericValue = MaterialTheme.shape.extraLarge,
    containerColor: CSSColorValue = MaterialTheme.colorScheme.surfaceContainerHigh,
    isCancellable: Boolean = true,
    icon: (@Composable ColumnScope.() -> Unit)? = null,
    headline: @Composable ColumnScope.() -> Unit,
    supportingText: @Composable ColumnScope.() -> Unit,
    buttons: @Composable RowScope.() -> Unit,
    content: (@Composable ColumnScope.() -> Unit)? = null
) {

    var changeZIndex by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .id("dialog-overlay")
            .then {
                if (visible)
                    OverlayOpenedBackgroundStyle.toModifier()
                else
                    OverlayClosedBackgroundStyle.toModifier()
            }
            .onTransitionStart {
                if (visible) {
                    changeZIndex = true
                }
            }
            .onTransitionEnd {
                if (!visible) {
                    changeZIndex = false
                }
            }
            .thenIf(changeZIndex) { zIndex(1) }
            .thenIf(!visible) {
                pointerEvents(PointerEvents.None)
            }
            .thenIf(visible) {
                onClick { if (isCancellable) onDismissRequest() }
            }
            .padding(24.px)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (visible) {
            Column(
                modifier = Modifier
                    .background(containerColor)
                    .userSelect(UserSelect.None)
                    .padding(24.px)
                    .onClick { it.stopPropagation() }
                    .clip(RectF(shape))
                    .fillMaxWidth()
                    .maxWidth(640.px),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                icon?.let {
                    Box(
                        modifier = Modifier.margin(bottom = 16.px)
                    ) {
                        icon(this@Column)
                    }
                }

                CompositionLocalProvider(
                    LocalTextStyle provides MaterialTheme.typography.headlineSmall.copy(
                        color = MaterialTheme.colorScheme.onSurface
                    )
                ) {
                    headline()
                }

                Box(modifier = Modifier.margin(bottom = 16.px))

                CompositionLocalProvider(
                    LocalTextStyle provides MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.onSurface
                    )
                ) {
                    supportingText()
                }

                content?.let {
                    Box(modifier = Modifier.margin(bottom = 24.px))
                    content()
                }

                Row(
                    modifier = Modifier
                        .padding(top = 24.px)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    buttons()
                }
            }
        }
    }
}