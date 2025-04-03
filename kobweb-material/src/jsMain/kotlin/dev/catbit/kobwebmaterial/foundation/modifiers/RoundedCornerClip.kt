package dev.catbit.kobwebmaterial.foundation.modifiers

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.CSSNumeric
import org.jetbrains.compose.web.css.px

fun Modifier.roundedCornerClip(
    topLeft: CSSNumeric = 0.px,
    topRight: CSSNumeric = 0.px,
    bottomRight: CSSNumeric = 0.px,
    bottomLeft: CSSNumeric = 0.px
): Modifier {
    return then(this).styleModifier {
        property("clip-path", "inset(0% round $topLeft $topRight $bottomRight $bottomLeft)")
    }
}