package com.catbit.mwckobweb.foundation.shape

import org.jetbrains.compose.web.css.CSSNumericValue
import org.jetbrains.compose.web.css.CSSUnitLengthOrPercentage

enum class ShapeVariable(private val shape: String) : CSSNumericValue<CSSUnitLengthOrPercentage> {
    None("var(--md-sys-shape-corner-none)"),
    ExtraSmall("var(--md-sys-shape-corner-extra-small)"),
    Small("var(--md-sys-shape-corner-small)"),
    Medium("var(--md-sys-shape-corner-medium)"),
    Large("var(--md-sys-shape-corner-large)"),
    ExtraLarge("var(--md-sys-shape-corner-extra-large)"),
    Full("var(--md-sys-shape-corner-full)");

    override fun toString() = shape

    companion object {
        fun toShape() = Shape(
            none = None,
            extraSmall = ExtraSmall,
            small = Small,
            medium = Medium,
            large = Large,
            extraLarge = ExtraLarge,
            full = Full
        )
    }
}