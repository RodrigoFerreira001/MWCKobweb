package dev.catbit.sample.pages.setup

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.theme.shapes.RectF
import com.varabyte.kobweb.silk.theme.shapes.clip
import dev.catbit.kobwebmaterial.components.icons.Icon
import dev.catbit.kobwebmaterial.components.ripple.RippleContainer
import dev.catbit.kobwebmaterial.components.text.Text
import dev.catbit.kobwebmaterial.foundation.theme.MaterialTheme
import dev.catbit.sample.composables.markdown_viewer.MarkdownViewer
import org.jetbrains.compose.web.css.px

@Composable
fun SetupPage() {
    Column(
        modifier = Modifier
            .overflow { y(Overflow.Auto) }
            .fillMaxSize()
            .padding(24.px)
    ) {
        Text(
            modifier = Modifier.margin(bottom = 16.px),
            text = "Kobweb Material setup",
            style = MaterialTheme.typography.displaySmall
        )

        Text(
            modifier = Modifier.margin(bottom = 16.px),
            text = "Adding Kobweb Material to your project",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            modifier = Modifier.margin(bottom = 8.px),
            text = "In your build.gradle file, add the following dependency:",
            style = MaterialTheme.typography.bodyLarge
        )

        Box(
            contentAlignment = Alignment.TopEnd
        ) {
            MarkdownViewer(
                modifier = Modifier
                    .clip(RectF(MaterialTheme.shape.large)),
                markdown = """
                ```kotlin
                dependencies {
                    implementation("dev.catbit.kobwebmaterial:1.0.0")
                }
                ```
                """.trimIndent()
            )

            RippleContainer(
                modifier = Modifier
                    .userSelect(UserSelect.None)
                    .clip(RectF(MaterialTheme.shape.full))
                    .size(48.px)
                    .margin(4.px),
                onClick = {

                }
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        name = "content_copy",
                        tint = Colors.White
                    )
                }
            }
        }

        Text(
            modifier = Modifier.margin(bottom = 16.px, top = 16.px),
            text = "Building your theme",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            modifier = Modifier.margin(bottom = 8.px),
            text = "Like in the canvas based version of Compose, Kobweb Material allows you to use the MaterialTheme object to customize your application.",
            style = MaterialTheme.typography.bodyLarge
        )


        MarkdownViewer(
            modifier = Modifier.clip(RectF(MaterialTheme.shape.large)),
            markdown = """
                ```kotlin
                ...
                
                Text(
                    text = "Hello!",
                    style = MaterialTheme.typography.bodyLarge
                )
                
                ...
                ```
                """.trimIndent()
        )

        Text(
            modifier = Modifier.margin(bottom = 8.px, top = 16.px),
            text = "Adding your fonts",
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            modifier = Modifier.margin(bottom = 8.px),
            text = "You can add a font to your build.gradle like this:",
            style = MaterialTheme.typography.bodyLarge
        )

        MarkdownViewer(
            modifier = Modifier
                .clip(RectF(MaterialTheme.shape.large)),
            markdown = """
                ```kotlin
                kobweb {
                    app {
                        index {
                            with(head) {
                                add {
                                    link {
                                        rel = "stylesheet"
                                        href = "https://fonts.googleapis.com/css2?family=Antic+Didone&display=swap"
                                    }
                                }
                            }
                        }
                    }
                }
                ```
                """.trimIndent()
        )

        Text(
            modifier = Modifier.margin(bottom = 8.px, top = 16.px),
            text = "Defining your color scheme",
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            modifier = Modifier.margin(bottom = 8.px),
            text = "Kobweb Material provides a ColorScheme class based on Material",
            style = MaterialTheme.typography.bodyLarge
        )

        MarkdownViewer(
            modifier = Modifier
                .clip(RectF(MaterialTheme.shape.large)),
            markdown = """
                ```kotlin
                val lightColorScheme = ColorScheme(
                    primary = Color.rgb(65, 95, 145),
                    onPrimary = Color.rgb(255, 255, 255),
                    primaryContainer = Color.rgb(214, 227, 255),
                    onPrimaryContainer = Color.rgb(40, 71, 119),
                    ...
                    
                val darkColorScheme = ColorScheme(
                    primary = Color.rgb(170, 199, 255),
                    onPrimary = Color.rgb(10, 48, 95),
                    primaryContainer = Color.rgb(40, 71, 119),
                    onPrimaryContainer = Color.rgb(214, 227, 255),
                    ...
                ```
                """.trimIndent()
        )

        Text(
            modifier = Modifier.margin(bottom = 8.px, top = 16.px),
            text = "Defining your shape",
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            modifier = Modifier.margin(bottom = 8.px),
            text = "You can also define the Material Theme shape",
            style = MaterialTheme.typography.bodyLarge
        )

        MarkdownViewer(
            modifier = Modifier
                .clip(RectF(MaterialTheme.shape.large)),
            markdown = """
                ```kotlin
                val SampleShape = Shape(
                    extraSmall = 4.px,
                    small = 8.px,
                    medium = 12.px,
                    large = 16.px,
                    extraLarge = 28.px
                )
                ```
                """.trimIndent()
        )

        Text(
            modifier = Modifier.margin(bottom = 8.px, top = 16.px),
            text = "Creating your theme",
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            modifier = Modifier.margin(bottom = 8.px),
            text = "Once you have setup typography, colors and shape, you are able to create you application theme:",
            style = MaterialTheme.typography.bodyLarge
        )

        MarkdownViewer(
            modifier = Modifier
                .clip(RectF(MaterialTheme.shape.large)),
            markdown = """
                ```kotlin
                @Composable
                fun SampleTheme(
                    content: @Composable () -> Unit
                ) {
                
                    val colorMode by ColorMode.currentState
                
                    MaterialTheme(
                        colorScheme = if (colorMode.isDark) darkColorScheme else lightColorScheme,
                        typography = SampleTypography,
                        shape = Shape(),
                        content = content
                    )
                }
                ```
                """.trimIndent()
        )
    }
}