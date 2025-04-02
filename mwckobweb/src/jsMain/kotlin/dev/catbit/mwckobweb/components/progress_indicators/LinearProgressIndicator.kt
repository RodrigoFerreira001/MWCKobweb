package dev.catbit.mwckobweb.components.progress_indicators

import androidx.compose.runtime.Composable
import dev.catbit.mwckobweb.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.px

@Composable
fun LinearProgressIndicator(
    modifier: Modifier = Modifier,
    value: Double? = null,
    buffer: Double? = null,
    indeterminate: Boolean = true,
    maxValue: Double = 1.0,
    trackShape: CSSLengthOrPercentageNumericValue = MaterialTheme.shape.none,
    trackColor: CSSColorValue = MaterialTheme.colorScheme.surfaceContainerHighest,
    activeIndicatorColor: CSSColorValue = MaterialTheme.colorScheme.primary,
    trackHeight: CSSSizeValue<CSSUnit.px> = 4.px,
    activeIndicatorHeight: CSSSizeValue<CSSUnit.px> = 4.px,
) {
    BaseProgressIndicator(
        modifier = modifier
            .minHeight(4.px)
            .attrsModifier {
                buffer?.let { attr("buffer", buffer.toString()) }
                attr("max", maxValue.toString())
            }
            .styleModifier {
                property("--md-linear-progress-track-color", trackColor)
                property("--md-linear-progress-track-height", trackHeight)
                property("--md-linear-progress-track-shape", trackShape)
                property("--md-linear-progress-active-indicator-color", activeIndicatorColor)
                property("--md-linear-progress-active-indicator-height", activeIndicatorHeight)

            },
        value = value,
        indeterminate = indeterminate,
        progressStyle = "md-linear-progress"
    )
}