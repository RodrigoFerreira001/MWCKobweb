package dev.catbit.mwckobweb.components.search_bar

import androidx.compose.runtime.Composable
import dev.catbit.mwckobweb.foundation.modifiers.textStyle
import dev.catbit.mwckobweb.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.theme.shapes.RectF
import com.varabyte.kobweb.silk.theme.shapes.clip
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.TextInput

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    query: String,
    onQueryChange: (String) -> Unit,
    hint: String? = null,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
) {

    Row(
        modifier = modifier
            .color(MaterialTheme.colorScheme.onSurface)
            .backgroundColor(MaterialTheme.colorScheme.surfaceContainer)
            .padding(leftRight = 4.px)
            .minHeight(56.px)
            .clip(RectF(MaterialTheme.shape.extraLarge)),
        verticalAlignment = Alignment.CenterVertically
    ) {

        leadingIcon?.let {
            Box(
                modifier = Modifier
                    .minSize(48.px)
                    .userSelect(UserSelect.None),
                contentAlignment = Alignment.Center
            ) {
                leadingIcon()
            }
        }

        TextInput(
            value = query,
            attrs = Modifier
                .margin(leftRight = 8.px)
                .textStyle(MaterialTheme.typography.bodyLarge)
                .color(MaterialTheme.colorScheme.onSurface)
                .caretColor(MaterialTheme.colorScheme.onSurface)
                .backgroundColor(MaterialTheme.colorScheme.surfaceContainer)
                .weight(1f)
                .styleModifier {
                    property("border", "none")
                    property("outline", "none")
                }
                .toAttrs {
                    hint?.let {
                        placeholder(it)
                    }
                    onInput { onQueryChange(it.value) }
                }
        )

        trailingIcon?.let {
            Box(
                modifier = Modifier.userSelect(UserSelect.None)
            ) {
                trailingIcon()
            }
        }
    }
}