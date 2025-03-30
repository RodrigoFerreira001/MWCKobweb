package com.catbit.mwckobweb.components.text

import androidx.compose.runtime.Composable
import com.catbit.mwckobweb.foundation.locals.LocalTextStyle
import com.catbit.mwckobweb.foundation.modifiers.thenIfNotNull
import com.catbit.mwckobweb.foundation.text.FontFamily
import com.catbit.mwckobweb.foundation.text.TextStyle
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text as ComposeText

@Composable
fun Text(
    text: String,
    modifier: Modifier = Modifier,
    color: CSSColorValue? = null,
    fontSize: CSSLengthOrPercentageNumericValue? = null,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: CSSLengthNumericValue? = null,
    textDecoration: TextDecorationLine? = null,
    textAlign: TextAlign? = null,
    lineHeight: CSSLengthOrPercentageNumericValue? = null,
    softWrap: Boolean = true,
    textOverflow: TextOverflow = TextOverflow.Ellipsis,
    style: TextStyle? = null
) {
    val mergedTextStyle = mergeTextStyle(
        color = color,
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        letterSpacing = letterSpacing,
        textDecoration = textDecoration,
        textAlign = textAlign,
        lineHeight = lineHeight,
        style = style,
    )

    Span(
        attrs = modifier
            .thenIfNotNull(mergedTextStyle.color) { color(it) }
            .thenIfNotNull(mergedTextStyle.fontSize) { fontSize(it) }
            .thenIfNotNull(mergedTextStyle.fontStyle) { fontStyle(it) }
            .thenIfNotNull(mergedTextStyle.fontWeight) { fontWeight(it) }
            .thenIfNotNull(mergedTextStyle.fontFamily) { fontFamily(it.name) }
            .thenIfNotNull(mergedTextStyle.letterSpacing) { letterSpacing(it) }
            .thenIfNotNull(mergedTextStyle.textDecoration) { textDecorationLine(it) }
            .thenIfNotNull(mergedTextStyle.textAlign) { textAlign(it) }
            .thenIfNotNull(mergedTextStyle.lineHeight) { lineHeight(it) }
            .flexWrap(if (softWrap) FlexWrap.Wrap else FlexWrap.Nowrap)
            .textOverflow(textOverflow)
            .toAttrs()
    ) {
        ComposeText(text)
    }
}

@Composable
private fun mergeTextStyle(
    fontSize: CSSLengthOrPercentageNumericValue? = null,
    fontWeight: FontWeight? = null,
    fontStyle: FontStyle? = null,
    letterSpacing: CSSLengthNumericValue? = null,
    lineHeight: CSSLengthOrPercentageNumericValue? = null,
    color: CSSColorValue? = null,
    backgroundColor: CSSColorValue? = null,
    textDecoration: TextDecorationLine? = null,
    textAlign: TextAlign? = null,
    fontFamily: FontFamily? = null,
    style: TextStyle? = null
): TextStyle {

    val localTextStyle = LocalTextStyle.current

    return TextStyle(
        fontSize = fontSize ?: style?.fontSize ?: localTextStyle?.fontSize,
        fontWeight = fontWeight ?: style?.fontWeight ?: localTextStyle?.fontWeight,
        fontStyle = fontStyle ?: style?.fontStyle ?: localTextStyle?.fontStyle,
        letterSpacing = letterSpacing ?: style?.letterSpacing ?: localTextStyle?.letterSpacing,
        lineHeight = lineHeight ?: style?.lineHeight ?: localTextStyle?.lineHeight,
        color = color ?: style?.color ?: localTextStyle?.color,
        backgroundColor = backgroundColor ?: style?.backgroundColor ?: localTextStyle?.backgroundColor,
        textDecoration = textDecoration ?: style?.textDecoration ?: localTextStyle?.textDecoration,
        textAlign = textAlign ?: style?.textAlign ?: localTextStyle?.textAlign,
        fontFamily = fontFamily ?: style?.fontFamily ?: localTextStyle?.fontFamily,
    )
}

