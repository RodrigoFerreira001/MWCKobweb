package dev.catbit.mwckobweb.components.overlays.snackbar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import dev.catbit.mwckobweb.components.icons.Icon
import dev.catbit.mwckobweb.components.ripple.RippleContainer
import dev.catbit.mwckobweb.foundation.locals.LocalTextStyle
import dev.catbit.mwckobweb.foundation.modifiers.then
import dev.catbit.mwckobweb.foundation.modifiers.thenIf
import dev.catbit.mwckobweb.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.shapes.RectF
import com.varabyte.kobweb.silk.theme.shapes.clip
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.*
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

@Composable
fun Snackbar(
    modifier: Modifier = Modifier,
    visible: Boolean,
    onDismissRequest: () -> Unit = {},
    duration: SnackbarDuration = SnackbarDuration.Short(),
    shape: CSSLengthOrPercentageNumericValue = MaterialTheme.shape.extraSmall,
    containerColor: CSSColorValue = MaterialTheme.colorScheme.inverseSurface,
    contentColor: CSSColorValue = MaterialTheme.colorScheme.inverseOnSurface,
    actionColor: CSSColorValue = MaterialTheme.colorScheme.inversePrimary,
    displayCloseButton: Boolean = false,
    action: (@Composable () -> Unit)? = null,
    message: @Composable () -> Unit
) {

    LaunchedEffect(visible) {
        if (visible && duration !is SnackbarDuration.Indefinite) {
            val durationValue = (duration as? SnackbarDuration.Short)?.duration
                ?: (duration as SnackbarDuration.Long).duration

            delay(durationValue)
            onDismissRequest()
        }
    }

    Box(
        modifier = modifier
            .thenIf(!visible) {
                pointerEvents(PointerEvents.None)
            }
            .id("snackbar-overlay")
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            modifier = Modifier
                .userSelect(UserSelect.None)
                .then {
                    if (visible)
                        SnackbarOpenedStyle.toModifier()
                    else
                        SnackbarClosedStyle.toModifier()
                }
                .background(containerColor)
                .onClick { it.stopPropagation() }
                .clip(RectF(shape))
                .minHeight(48.px)
                .padding(left = 16.px, right = 8.px),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CompositionLocalProvider(
                LocalTextStyle provides MaterialTheme.typography.bodyMedium.copy(color = contentColor)
            ) {
                message()
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                action?.let {
                    CompositionLocalProvider(
                        LocalTextStyle provides MaterialTheme.typography.labelLarge.copy(color = actionColor)
                    ) {
                        action()
                    }
                }

                if (displayCloseButton) {
                    RippleContainer(
                        modifier = Modifier
                            .userSelect(UserSelect.None)
                            .clip(RectF(MaterialTheme.shape.full)),
                        onClick = onDismissRequest
                    ) {
                        Box(
                            modifier = Modifier.size(48.px),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                name = "close",
                                tint = contentColor
                            )
                        }
                    }
                }
            }
        }
    }
}

sealed interface SnackbarDuration {
    data object Indefinite : SnackbarDuration
    data class Short(internal val duration: Duration = 4.seconds) : SnackbarDuration
    data class Long(internal val duration: Duration = 10.seconds) : SnackbarDuration
}

val SnackbarClosedStyle = CssStyle {
    base {
        Modifier
            .position(Position.Fixed)
            .left(24.px)
            .right(24.px)
            .bottom(0.px)
            .transition(Transition.of("transform", duration = 250.ms, timingFunction = TransitionTimingFunction.Ease))
            .transform { translateY(100.percent) }
    }
}

val SnackbarOpenedStyle = CssStyle {
    base {
        Modifier
            .position(Position.Fixed)
            .left(24.px)
            .right(24.px)
            .bottom(24.px)
            .transition(Transition.of("transform", duration = 250.ms, timingFunction = TransitionTimingFunction.Ease))
            .transform { translateY(0.px) }
    }
}