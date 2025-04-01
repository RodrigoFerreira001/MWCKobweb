package com.catbit.mwckobweb.components.overlays.navigation_drawer

import androidx.compose.runtime.*
import com.catbit.mwckobweb.components.overlays.OverlayClosedBackgroundStyle
import com.catbit.mwckobweb.components.overlays.OverlayOpenedBackgroundStyle
import com.catbit.mwckobweb.foundation.modifiers.then
import com.catbit.mwckobweb.foundation.modifiers.thenIf
import com.catbit.mwckobweb.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.PointerEvents
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.TransitionTimingFunction
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*

@Composable
fun NavigationDrawer(
    modifier: Modifier = Modifier,
    visible: Boolean,
    onDismissRequest: () -> Unit = {},
    containerColor: CSSColorValue = MaterialTheme.colorScheme.surfaceContainerLow,
    isCancellable: Boolean = true,
    content: @Composable ColumnScope.() -> Unit
) {

    var changeZIndex by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .id("navigation-drawer-overlay")
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
            .padding(right = 24.px)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .then {
                    if (visible)
                        NavDrawerOpenedStyle.toModifier()
                    else
                        NavDrawerClosedStyle.toModifier()
                }
                .onClick { it.stopPropagation() }
                .overflow { y(Overflow.Auto) }
                .padding(12.px)
                .fillMaxSize()
                .maxWidth(360.px)
                .backgroundColor(containerColor),
            verticalArrangement = Arrangement.spacedBy(4.px)
        ) {
            content()
        }
    }
}

val NavDrawerClosedStyle = CssStyle {
    base {
        Modifier
            .position(Position.Fixed)
            .top(0.px)
            .left(0.px)
            .transition(Transition.of("transform", duration = 300.ms, timingFunction = TransitionTimingFunction.Ease))
            .transform { translateX((-100).percent) }
    }
}

val NavDrawerOpenedStyle = CssStyle {
    base {
        Modifier
            .position(Position.Fixed)
            .top(0.px)
            .left(0.px)
            .transition(Transition.of("transform", duration = 300.ms, timingFunction = TransitionTimingFunction.Ease))
            .transform { translateX(0.px) }
    }
}



