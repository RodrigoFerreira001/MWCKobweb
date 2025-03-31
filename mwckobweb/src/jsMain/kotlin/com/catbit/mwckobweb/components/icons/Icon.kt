package com.catbit.mwckobweb.components.icons

import androidx.compose.runtime.Composable
import com.catbit.mwckobweb.foundation.locals.LocalIconSize
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.userSelect
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun Icon(
    name: String,
    modifier: Modifier = Modifier,
    style: SymbolStyle = SymbolStyle.Rounded,
    weight: SymbolWeight = SymbolWeight.Normal,
    grade: SymbolGrade = SymbolGrade.Normal,
    opticalSize: SymbolOpticalSize = SymbolOpticalSize.Size24,
    tint: CSSColorValue? = null,
    fill: Boolean = false,
) {
    val iconSize = LocalIconSize.current
    Span(
        attrs = modifier
            .userSelect(UserSelect.None)
            .toAttrs {
                classes(style.style)
                val fontVariationSetting = buildString {
                    iconSize?.let { append("font-size: $iconSize !important;") }
                    tint?.let { append("color: $tint;") }
                    append("font-variation-settings: ")
                    append("\"FILL\" ${if(fill) "1" else "0"}, ")
                    append("\"wght\" ${weight.weight}, ")
                    append("\"GRAD\" ${grade.grade}, ")
                    append("\"opsz\" ${opticalSize.opticalSize};")
                }
                attr("style", fontVariationSetting)
            }
    ) { Text(name) }
}

enum class SymbolStyle(internal val style: String) {
    Outlined("material-symbols-outlined"),
    Rounded("material-symbols-rounded"),
    Sharp("material-symbols-sharp"),
}

enum class SymbolWeight(internal val weight: String) {
    Thin("100"),
    ExtraLight("200"),
    Light("300"),
    Normal("400"),
    Medium("500"),
    SemiBold("600"),
    Bold("700")
}

enum class SymbolGrade(internal val grade: String) {
    Low("-25"),
    Normal("0"),
    HighEmphasis("200")
}

enum class SymbolOpticalSize(internal val opticalSize: String) {
    Size20("20"),
    Size24("24"),
    Size40("40"),
    Size48("48"),
}