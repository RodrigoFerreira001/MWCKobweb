package dev.catbit.sample.composables.markdown_viewer

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.dom.GenericTag
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.dom.Text

@Composable
fun MarkdownViewer(
    modifier: Modifier = Modifier,
    markdown: String
) {
    GenericTag(
        name = "zero-md",
        attrs = modifier.toAttrs()
    ) {
        GenericTag(
            name = "template",
            attrs = Modifier.toAttrs {
                attr("data-append", "")
            }
        ) {
            GenericTag("style") {
                Text(
                    """
                    code {
                        background: yellow;
                    }
                    """.trimIndent()
                )
            }
        }
        GenericTag(
            name = "script",
            attrs = Modifier.toAttrs {
                attr("type", "text/markdown")
            }
        ) {
            Text(markdown)
        }
    }
}