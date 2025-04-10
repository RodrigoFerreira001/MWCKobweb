package dev.catbit.sample.data.models.components.image

import androidx.compose.runtime.Composable
import dev.catbit.sample.data.models.components.ComponentModel
import dev.catbit.sample.data.models.components.ComponentParam

object ImageComponentModel : ComponentModel {
    override val identifier = "image"
    override val searchTerms = listOf("image", "photo", "picture", "graphic", "media")
    override val title = "Image"
    override val description = "A composable that displays an image with optional tint and content scaling options."
    override val briefDescription = "Displays an image with support for scale, tint, and description."
    override val image = ""
    override val codeExample = ""
    override val params = listOf(
        ComponentParam(
            name = "modifier",
            type = "Modifier",
            optional = true,
            defaultValue = "Modifier",
            description = "Modifier used to adjust the layout or styling of the image."
        ),
        ComponentParam(
            name = "image",
            type = "String",
            optional = false,
            defaultValue = null,
            description = "The source path or URL of the image to display."
        ),
        ComponentParam(
            name = "tint",
            type = "CSSColorValue?",
            optional = true,
            defaultValue = "null",
            description = "Optional color overlay applied using background blend mode."
        ),
        ComponentParam(
            name = "contentScale",
            type = "ContentScale",
            optional = true,
            defaultValue = "ContentScale.Fit",
            description = "Controls how the image content is scaled to fit its bounds."
        ),
        ComponentParam(
            name = "contentDescription",
            type = "String?",
            optional = true,
            defaultValue = "null",
            description = "Optional description for accessibility purposes."
        )
    )
    override val composableExample = @Composable {}
}