package dev.catbit.sample.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import dev.catbit.kobwebmaterial.foundation.shape.Shape
import dev.catbit.kobwebmaterial.foundation.theme.MaterialTheme

@Composable
fun SampleTheme(
    content: @Composable () -> Unit
) {

    val colorMode by ColorMode.currentState

    MaterialTheme(
        colorScheme = if (colorMode.isDark) darkColorScheme else lightColorScheme,
        typography = SampleTypography,
        shape = Shape(),
        content = content
    )
}