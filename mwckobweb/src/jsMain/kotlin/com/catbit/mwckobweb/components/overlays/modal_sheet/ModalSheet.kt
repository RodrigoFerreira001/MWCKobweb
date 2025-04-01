package com.catbit.mwckobweb.components.overlays.modal_sheet

import androidx.compose.runtime.*
import com.catbit.mwckobweb.components.overlays.OverlayClosedBackgroundStyle
import com.catbit.mwckobweb.components.overlays.OverlayOpenedBackgroundStyle
import com.catbit.mwckobweb.foundation.modifiers.roundedCornerClip
import com.catbit.mwckobweb.foundation.modifiers.then
import com.catbit.mwckobweb.foundation.modifiers.thenIf
import com.catbit.mwckobweb.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.css.PointerEvents
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.TransitionTimingFunction
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.shapes.RectF
import com.varabyte.kobweb.silk.theme.shapes.clip
import org.jetbrains.compose.web.css.*

@Composable
fun ModalSheet(
    modifier: Modifier = Modifier,
    visible: Boolean,
    onDismissRequest: () -> Unit = {},
    shape: CSSLengthOrPercentageNumericValue = MaterialTheme.shape.extraLarge,
    containerColor: CSSColorValue = MaterialTheme.colorScheme.surfaceContainerLow,
    showHandler: Boolean = true,
    isCancellable: Boolean = true,
    content: @Composable ColumnScope.() -> Unit
) {

    var changeZIndex by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .id("modal-sheet-overlay")
            .then {
                if (visible)
                    OverlayOpenedBackgroundStyle.toModifier()
                else
                    OverlayClosedBackgroundStyle.toModifier()
            }
            .onTransitionStart {
                if (visible) { changeZIndex = true }
            }
            .onTransitionEnd {
                if (!visible) { changeZIndex = false }
            }
            .thenIf(changeZIndex) { zIndex(1) }
            .thenIf(!visible) {
                pointerEvents(PointerEvents.None)
            }
            .thenIf(visible) {
                onClick { if (isCancellable) onDismissRequest() }
            }
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = modifier
                .then {
                    if (visible)
                        ModalSheetOpenedStyle.toModifier()
                    else
                        ModalSheetClosedStyle.toModifier()
                }
                .background(containerColor)
                .onClick { it.stopPropagation() }
                .roundedCornerClip(
                    topRight = shape,
                    topLeft = shape
                )
                .fillMaxWidth()
                .padding(leftRight = 24.px, bottom = 24.px)
                .maxWidth(640.px)
        ) {
            if (showHandler) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .width(32.px)
                            .height(4.px)
                            .margin(topBottom = 16.px)
                            .backgroundColor(MaterialTheme.colorScheme.onSurfaceVariant)
                            .clip(RectF(cornerRadius = 32.px))
                    )
                }
            }
            content()
        }
    }
}

val ModalSheetClosedStyle = CssStyle {
    base {
        Modifier
            .position(Position.Fixed)
            .bottom(0.px)
            .transition(Transition.of("transform", duration = 250.ms, timingFunction = TransitionTimingFunction.Ease))
            .transform { translateY(100.percent) }
    }
}

val ModalSheetOpenedStyle = CssStyle {
    base {
        Modifier
            .position(Position.Fixed)
            .bottom(0.px)
            .transition(Transition.of("transform", duration = 250.ms, timingFunction = TransitionTimingFunction.Ease))
            .transform { translateY(0.px) }
    }
}