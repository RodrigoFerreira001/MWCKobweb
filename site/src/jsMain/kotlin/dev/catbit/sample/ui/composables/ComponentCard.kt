package dev.catbit.sample.ui.composables

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.theme.shapes.RectF
import com.varabyte.kobweb.silk.theme.shapes.clip
import dev.catbit.kobwebmaterial.components.ripple.RippleContainer
import dev.catbit.kobwebmaterial.components.text.Text
import dev.catbit.kobwebmaterial.foundation.theme.MaterialTheme
import dev.catbit.sample.data.models.components.ComponentModel
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px

@Composable
fun ComponentCard(
    modifier: Modifier = Modifier,
    componentModel: ComponentModel,
    onClick: () -> Unit
) {
    RippleContainer(
        modifier = modifier.clip(RectF(MaterialTheme.shape.large)),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(16.px)
                .border(
                    width = 1.px,
                    style = LineStyle.Solid,
                    color = MaterialTheme.colorScheme.outlineVariant
                )
                .borderRadius(MaterialTheme.shape.large)
                .color(MaterialTheme.colorScheme.onBackground)
                .fillMaxSize()
        ) {
            Text(
                text = componentModel.title,
                style = MaterialTheme.typography.titleLarge
            )
        }

    }
}