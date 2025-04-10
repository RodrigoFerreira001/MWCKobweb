package dev.catbit.sample.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import dev.catbit.kobwebmaterial.components.buttons.icon_button.IconButton
import dev.catbit.kobwebmaterial.components.icons.Icon
import dev.catbit.kobwebmaterial.components.navigation.NavigationRail
import dev.catbit.kobwebmaterial.components.navigation.NavigationRailItem
import dev.catbit.kobwebmaterial.components.overlays.overlay_container.OverlaysContainer
import dev.catbit.kobwebmaterial.components.text.Text
import dev.catbit.sample.pages.about.AboutPage
import dev.catbit.sample.pages.components.ComponentsPage
import dev.catbit.sample.pages.setup.SetupPage
import org.jetbrains.compose.web.css.px

@Page("/{...context?}")
@Composable
fun Index() {

    val ctx = rememberPageContext()

    val navigations = listOf(
        Triple("About", "home", "/"),
        Triple("Setup", "flag", "/setup"),
        Triple("Components", "grid_view", "/components")
    )

    OverlaysContainer(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .overflow(Overflow.Hidden)
        ) {
            NavigationRail(
                modifier = Modifier
                    .width(100.px)
                    .fillMaxHeight()
            ) {
                navigations.forEach { (text, icon, path) ->

                    val currentPath = ctx.route.path
                    val selected = currentPath == path || path != "/" && currentPath.startsWith(path)

                    NavigationRailItem(
                        selected = selected,
                        onClick = {
                            ctx.router.tryRoutingTo(path)
                        },
                        icon = {
                            Icon(
                                name = icon,
                                fill = selected
                            )
                        },
                        text = {
                            Text(text)
                        }
                    )
                }

                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    var colorMode by ColorMode.currentState

                    IconButton(
                        onClick = {
                            colorMode = colorMode.opposite
                        }
                    ) {
                        Icon(if (colorMode.isLight) "dark_mode" else "light_mode")
                    }
                }
            }

            when (ctx.route.path) {
                "/" -> AboutPage()
                "/setup" -> SetupPage()
                else -> {
                    when {
                        ctx.route.path.startsWith("/components") -> ComponentsPage(ctx.route.path)
                        else -> Text("Page not found.")
                    }
                }
            }
        }
    }
}

