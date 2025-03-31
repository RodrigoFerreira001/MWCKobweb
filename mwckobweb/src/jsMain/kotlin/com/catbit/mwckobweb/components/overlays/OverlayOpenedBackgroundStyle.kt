package com.catbit.mwckobweb.components.overlays

import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.TransitionTimingFunction
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.CssStyle
import org.jetbrains.compose.web.css.ms

val OverlayOpenedBackgroundStyle = CssStyle {
    base {
        Modifier
            .transition(
                Transition.of(
                    "background-color",
                    duration = 300.ms,
                    timingFunction = TransitionTimingFunction.Ease
                )
            )
            .backgroundColor(Colors.Black.copyf(alpha = 0.5f))
    }
}