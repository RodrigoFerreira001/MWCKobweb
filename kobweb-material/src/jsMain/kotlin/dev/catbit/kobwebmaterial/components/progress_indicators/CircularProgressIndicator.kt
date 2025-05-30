package dev.catbit.kobwebmaterial.components.progress_indicators

import androidx.compose.runtime.Composable
import dev.catbit.kobwebmaterial.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.minSize
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.px

@Composable
fun CircularProgressIndicator(
    modifier: Modifier = Modifier,
    value: Double? = null,
    indeterminate: Boolean = true,
    progressColor: CSSColorValue = MaterialTheme.colorScheme.primary,
    progressSize: CSSSizeValue<CSSUnit.px> = 48.px,
    activeIndicatorWidth: Double = 8.3333
) {
    BaseProgressIndicator(
        modifier = modifier
            .minSize(48.px)
            .styleModifier {
                property("--md-circular-progress-active-indicator-color", progressColor)
                property("--md-circular-progress-size", progressSize.toString())
                property("--md-circular-progress-active-indicator-width", activeIndicatorWidth.toString())
            },
        value = value,
        indeterminate = indeterminate,
        progressStyle = "md-circular-progress"
    )
}