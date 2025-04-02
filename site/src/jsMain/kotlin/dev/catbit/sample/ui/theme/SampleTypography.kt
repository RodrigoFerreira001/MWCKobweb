package dev.catbit.sample.ui.theme

import dev.catbit.mwckobweb.foundation.text.FontFamily
import dev.catbit.mwckobweb.foundation.text.Typography

val SampleTypography
    get() : Typography {

        val baseTypography = Typography()
        val jostFont = FontFamily("Jost")

        return Typography(
            displayLarge = baseTypography.displayLarge.copy(fontFamily = jostFont),
            displayMedium = baseTypography.displayMedium.copy(fontFamily = jostFont),
            displaySmall = baseTypography.displaySmall.copy(fontFamily = jostFont),
            headlineLarge = baseTypography.headlineLarge.copy(fontFamily = jostFont),
            headlineMedium = baseTypography.headlineMedium.copy(fontFamily = jostFont),
            headlineSmall = baseTypography.headlineSmall.copy(fontFamily = jostFont),
            titleLarge = baseTypography.titleLarge.copy(fontFamily = jostFont),
            titleMedium = baseTypography.titleMedium.copy(fontFamily = jostFont),
            titleSmall = baseTypography.titleSmall.copy(fontFamily = jostFont),
            bodyLarge = baseTypography.bodyLarge.copy(fontFamily = jostFont),
            bodyMedium = baseTypography.bodyMedium.copy(fontFamily = jostFont),
            bodySmall = baseTypography.bodySmall.copy(fontFamily = jostFont),
            labelLarge = baseTypography.labelLarge.copy(fontFamily = jostFont),
            labelMedium = baseTypography.labelMedium.copy(fontFamily = jostFont),
            labelSmall = baseTypography.labelSmall.copy(fontFamily = jostFont),
        )
    }