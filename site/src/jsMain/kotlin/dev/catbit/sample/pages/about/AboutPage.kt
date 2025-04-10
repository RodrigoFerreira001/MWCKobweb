package dev.catbit.sample.pages.about

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.silk.theme.shapes.RectF
import com.varabyte.kobweb.silk.theme.shapes.clip
import dev.catbit.kobwebmaterial.components.text.Text
import dev.catbit.kobwebmaterial.foundation.theme.MaterialTheme
import dev.catbit.sample.composables.markdown_viewer.MarkdownViewer

@Composable
fun AboutPage() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text("About!")
        MarkdownViewer(
            modifier = Modifier
                .clip(RectF(MaterialTheme.shape.large)),
            markdown = """
                ```kotlin
                fun a() {
                    println("Hello!")
                }
                ```
                """.trimIndent()
        )
    }
}