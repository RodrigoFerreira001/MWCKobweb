package dev.catbit.kobwebmaterial.foundation.shape

import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import org.jetbrains.compose.web.css.px

data class Shape(
    val none: CSSLengthOrPercentageNumericValue = 0.px,
    val extraSmall: CSSLengthOrPercentageNumericValue = 4.px,
    val small: CSSLengthOrPercentageNumericValue = 8.px,
    val medium: CSSLengthOrPercentageNumericValue = 12.px,
    val large: CSSLengthOrPercentageNumericValue = 16.px,
    val extraLarge: CSSLengthOrPercentageNumericValue = 28.px,
    val full: CSSLengthOrPercentageNumericValue = Int.MAX_VALUE.px,
)

val SampleShape = Shape(
    none = 0.px,
    extraSmall = 4.px,
    small = 8.px,
    medium = 12.px,
    large = 16.px,
    extraLarge = 28.px,
    full = Int.MAX_VALUE.px,
)