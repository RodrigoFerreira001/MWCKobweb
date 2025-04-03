package dev.catbit.kobwebmaterial.foundation.shape

import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import org.jetbrains.compose.web.css.*

data class Shape(
    val none: CSSLengthOrPercentageNumericValue = 0.px,
    val extraSmall: CSSLengthOrPercentageNumericValue = 4.px,
    val small: CSSLengthOrPercentageNumericValue = 8.px,
    val medium: CSSLengthOrPercentageNumericValue = 12.px,
    val large: CSSLengthOrPercentageNumericValue = 16.px,
    val extraLarge: CSSLengthOrPercentageNumericValue = 28.px,
    val full: CSSLengthOrPercentageNumericValue = Int.MAX_VALUE.px,
)