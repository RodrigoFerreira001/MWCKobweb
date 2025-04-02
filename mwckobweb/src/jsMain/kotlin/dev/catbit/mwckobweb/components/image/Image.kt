package dev.catbit.mwckobweb.components.image

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import dev.catbit.mwckobweb.foundation.modifiers.then
import dev.catbit.mwckobweb.foundation.modifiers.thenIfNotNull
import com.varabyte.kobweb.compose.css.MixBlendMode
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.mixBlendMode
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.CSSColorValue
import com.varabyte.kobweb.silk.components.graphics.Image as ComposeImage

@Composable
fun Image(
    modifier: Modifier = Modifier,
    image: String,
    tint: CSSColorValue? = null,
    contentScale: ContentScale = ContentScale.Fit,
    contentDescription: String? = null,
) {
    ComposeImage(
        modifier = modifier
            .thenIfNotNull(tint) { backgroundColor(it).mixBlendMode(MixBlendMode.Multiply) }
            .then {
                when (contentScale) {
                    ContentScale.Crop -> Modifier.objectFit(ObjectFit.Cover)
                    ContentScale.Fit -> Modifier.objectFit(ObjectFit.Contain)
                    ContentScale.FillHeight -> Modifier
                        .objectFit(ObjectFit.Cover)
                        .styleModifier { property("object-position", "center top") }

                    ContentScale.FillWidth -> Modifier
                        .objectFit(ObjectFit.Cover)
                        .styleModifier { property("object-position", "left center") }

                    ContentScale.Inside -> Modifier.objectFit(ObjectFit.ScaleDown)
                    ContentScale.None -> Modifier.objectFit(ObjectFit.None)
                    ContentScale.FillBounds -> Modifier.objectFit(ObjectFit.Fill)
                    else -> Modifier
                }
            },
        src = image,
        description = contentDescription.orEmpty()
    )
}

@Stable
sealed interface ContentScale {

    @Stable
    data object Crop : ContentScale

    @Stable
    data object Fit : ContentScale

    @Stable
    data object FillHeight : ContentScale

    @Stable
    data object FillWidth : ContentScale

    @Stable
    data object Inside : ContentScale

    @Stable
    data object None : ContentScale

    @Stable
    data object FillBounds : ContentScale
}