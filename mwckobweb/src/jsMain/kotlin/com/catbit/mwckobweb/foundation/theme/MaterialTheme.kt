package com.catbit.mwckobweb.foundation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import com.catbit.mwckobweb.foundation.color.ColorVariable
import com.catbit.mwckobweb.foundation.color.ColorScheme
import com.catbit.mwckobweb.foundation.effects.SingleEffect
import com.catbit.mwckobweb.foundation.text.Typography
import com.catbit.mwckobweb.foundation.locals.LocalTypography
import com.catbit.mwckobweb.foundation.locals.LocalColorScheme
import com.catbit.mwckobweb.foundation.locals.LocalShape
import com.catbit.mwckobweb.foundation.shape.Shape
import com.catbit.mwckobweb.foundation.shape.ShapeVariable
import kotlinx.browser.document
import org.w3c.dom.HTMLStyleElement

@JsName("MaterialThemeObject")
object MaterialTheme {
    val colorScheme: ColorScheme
        @Composable @ReadOnlyComposable get() = LocalColorScheme.current

    val typography: Typography
        @Composable @ReadOnlyComposable get() = LocalTypography.current

    val shape: Shape
        @Composable @ReadOnlyComposable get() = LocalShape.current
}

@Composable
fun MaterialTheme(
    colorScheme: ColorScheme,
    typography: Typography = Typography(),
    shape: Shape = Shape(),
    content: @Composable () -> Unit
) {

    SideEffect {
        setupStyleVariables(
            colorScheme = colorScheme,
            typography = typography,
            shape = shape
        )
    }
    
    CompositionLocalProvider(
        LocalColorScheme provides ColorVariable.toColorScheme(),
        LocalTypography provides typography,
        LocalShape provides ShapeVariable.toShape()
    ) {
        content()
    }
}

private fun setupStyleVariables(
    colorScheme: ColorScheme,
    typography: Typography,
    shape: Shape
) {
    document.getElementById("MaterialThemeStyle")?.let {
        document.head?.removeChild(it)
    }

    (document.createElement("style") as HTMLStyleElement).apply {
        type = "text/css"
        id = "MaterialThemeStyle"
        appendChild(
            document.createTextNode(
                buildString {
                    appendLine(":root {")
                    appendLine("\t--md-sys-shape-corner-none: ${shape.none};")
                    appendLine("\t--md-sys-shape-corner-extra-small: ${shape.extraSmall};")
                    appendLine("\t--md-sys-shape-corner-small: ${shape.small};")
                    appendLine("\t--md-sys-shape-corner-medium: ${shape.medium};")
                    appendLine("\t--md-sys-shape-corner-large: ${shape.large};")
                    appendLine("\t--md-sys-shape-corner-extra-large: ${shape.extraLarge};")
                    appendLine("\t--md-sys-shape-corner-full: ${shape.full};")

                    appendLine("\t--md-sys-typescale-display-large-font: '${typography.displayLarge.fontFamily?.name}';")
                    appendLine("\t--md-sys-typescale-display-medium-font: '${typography.displayMedium.fontFamily?.name}';")
                    appendLine("\t--md-sys-typescale-display-small-font: '${typography.displaySmall.fontFamily?.name}';")
                    appendLine("\t--md-sys-typescale-headline-large-font: '${typography.headlineLarge.fontFamily?.name}';")
                    appendLine("\t--md-sys-typescale-headline-medium-font: '${typography.headlineMedium.fontFamily?.name}';")
                    appendLine("\t--md-sys-typescale-headline-small-font: '${typography.headlineSmall.fontFamily?.name}';")
                    appendLine("\t--md-sys-typescale-title-large-font: '${typography.titleLarge.fontFamily?.name}';")
                    appendLine("\t--md-sys-typescale-title-medium-font: '${typography.titleMedium.fontFamily?.name}';")
                    appendLine("\t--md-sys-typescale-title-small-font: '${typography.titleSmall.fontFamily?.name}';")
                    appendLine("\t--md-sys-typescale-body-large-font: '${typography.bodyLarge.fontFamily?.name}';")
                    appendLine("\t--md-sys-typescale-body-medium-font: '${typography.bodyMedium.fontFamily?.name}';")
                    appendLine("\t--md-sys-typescale-body-small-font: '${typography.bodySmall.fontFamily?.name}';")
                    appendLine("\t--md-sys-typescale-label-large-font: '${typography.labelLarge.fontFamily?.name}';")
                    appendLine("\t--md-sys-typescale-label-medium-font: '${typography.labelMedium.fontFamily?.name}';")
                    appendLine("\t--md-sys-typescale-label-small-font: '${typography.labelSmall.fontFamily?.name}';")

                    appendLine("\t--md-sys-color-primary: ${colorScheme.primary};")
                    appendLine("\t--md-sys-color-surface-tint: ${colorScheme.surfaceTint};")
                    appendLine("\t--md-sys-color-on-primary: ${colorScheme.onPrimary};")
                    appendLine("\t--md-sys-color-primary-container: ${colorScheme.primaryContainer};")
                    appendLine("\t--md-sys-color-on-primary-container: ${colorScheme.onPrimaryContainer};")
                    appendLine("\t--md-sys-color-secondary: ${colorScheme.secondary};")
                    appendLine("\t--md-sys-color-on-secondary: ${colorScheme.onSecondary};")
                    appendLine("\t--md-sys-color-secondary-container: ${colorScheme.secondaryContainer};")
                    appendLine("\t--md-sys-color-on-secondary-container: ${colorScheme.onSecondaryContainer};")
                    appendLine("\t--md-sys-color-tertiary: ${colorScheme.tertiary};")
                    appendLine("\t--md-sys-color-on-tertiary: ${colorScheme.onTertiary};")
                    appendLine("\t--md-sys-color-tertiary-container: ${colorScheme.tertiaryContainer};")
                    appendLine("\t--md-sys-color-on-tertiary-container: ${colorScheme.onTertiaryContainer};")
                    appendLine("\t--md-sys-color-error: ${colorScheme.error};")
                    appendLine("\t--md-sys-color-on-error: ${colorScheme.onError};")
                    appendLine("\t--md-sys-color-error-container: ${colorScheme.errorContainer};")
                    appendLine("\t--md-sys-color-on-error-container: ${colorScheme.onErrorContainer};")
                    appendLine("\t--md-sys-color-background: ${colorScheme.background};")
                    appendLine("\t--md-sys-color-on-background: ${colorScheme.onBackground};")
                    appendLine("\t--md-sys-color-surface: ${colorScheme.surface};")
                    appendLine("\t--md-sys-color-on-surface: ${colorScheme.onSurface};")
                    appendLine("\t--md-sys-color-surface-variant: ${colorScheme.surfaceVariant};")
                    appendLine("\t--md-sys-color-on-surface-variant: ${colorScheme.onSurfaceVariant};")
                    appendLine("\t--md-sys-color-outline: ${colorScheme.outline};")
                    appendLine("\t--md-sys-color-outline-variant: ${colorScheme.outlineVariant};")
                    appendLine("\t--md-sys-color-shadow: ${colorScheme.shadow};")
                    appendLine("\t--md-sys-color-scrim: ${colorScheme.scrim};")
                    appendLine("\t--md-sys-color-inverse-surface: ${colorScheme.inverseSurface};")
                    appendLine("\t--md-sys-color-inverse-on-surface: ${colorScheme.inverseOnSurface};")
                    appendLine("\t--md-sys-color-inverse-primary: ${colorScheme.inversePrimary};")
                    appendLine("\t--md-sys-color-primary-fixed: ${colorScheme.primaryFixed};")
                    appendLine("\t--md-sys-color-on-primary-fixed: ${colorScheme.onPrimaryFixed};")
                    appendLine("\t--md-sys-color-primary-fixed-dim: ${colorScheme.primaryFixedDim};")
                    appendLine("\t--md-sys-color-on-primary-fixed-variant: ${colorScheme.onPrimaryFixedVariant};")
                    appendLine("\t--md-sys-color-secondary-fixed: ${colorScheme.secondaryFixed};")
                    appendLine("\t--md-sys-color-on-secondary-fixed: ${colorScheme.onSecondaryFixed};")
                    appendLine("\t--md-sys-color-secondary-fixed-dim: ${colorScheme.secondaryFixedDim};")
                    appendLine("\t--md-sys-color-on-secondary-fixed-variant: ${colorScheme.onSecondaryFixedVariant};")
                    appendLine("\t--md-sys-color-tertiary-fixed: ${colorScheme.tertiaryFixed};")
                    appendLine("\t--md-sys-color-on-tertiary-fixed: ${colorScheme.onTertiaryFixed};")
                    appendLine("\t--md-sys-color-tertiary-fixed-dim: ${colorScheme.tertiaryFixedDim};")
                    appendLine("\t--md-sys-color-on-tertiary-fixed-variant: ${colorScheme.onTertiaryFixedVariant};")
                    appendLine("\t--md-sys-color-surface-dim: ${colorScheme.surfaceDim};")
                    appendLine("\t--md-sys-color-surface-bright: ${colorScheme.surfaceBright};")
                    appendLine("\t--md-sys-color-surface-container-lowest: ${colorScheme.surfaceContainerLowest};")
                    appendLine("\t--md-sys-color-surface-container-low: ${colorScheme.surfaceContainerLow};")
                    appendLine("\t--md-sys-color-surface-container: ${colorScheme.surfaceContainer};")
                    appendLine("\t--md-sys-color-surface-container-high: ${colorScheme.surfaceContainerHigh};")
                    appendLine("\t--md-sys-color-surface-container-highest: ${colorScheme.surfaceContainerHighest};")
                    append("}")
                }
            )
        )
    }.also {
        document.head?.append(it)
    }
}