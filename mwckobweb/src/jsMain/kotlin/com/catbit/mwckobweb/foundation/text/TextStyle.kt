package com.catbit.mwckobweb.foundation.text

import com.varabyte.kobweb.compose.css.*
import org.jetbrains.compose.web.css.CSSColorValue

data class TextStyle(
    val fontSize: CSSLengthOrPercentageNumericValue? = null,
    val fontWeight: FontWeight? = null,
    val fontStyle: FontStyle? = null,
    val letterSpacing: CSSLengthNumericValue? = null,
    val lineHeight: CSSLengthOrPercentageNumericValue? = null,
    val color: CSSColorValue? = null,
    val backgroundColor: CSSColorValue? = null,
    val textDecoration: TextDecorationLine? = null,
    val textAlign: TextAlign? = null,
    val fontFamily: FontFamily? = null
)
