package dev.catbit.sample.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import dev.catbit.kobwebmaterial.foundation.theme.MaterialTheme
import com.varabyte.kobweb.silk.theme.colors.ColorMode

@Composable
fun SampleTheme(
    content: @Composable () -> Unit
) {

    val colorMode by ColorMode.currentState

    MaterialTheme(
        colorScheme = if (colorMode.isDark) darkColorScheme else lightColorScheme,
        typography = SampleTypography,
        content = content
    )
}