package com.catbit.sample.pages.index

import androidx.compose.runtime.*
import com.catbit.mwckobweb.components.app_bars.top_app_bars.LargeTopAppBar
import com.catbit.mwckobweb.components.app_bars.top_app_bars.MediumTopAppBar
import com.catbit.mwckobweb.components.app_bars.top_app_bars.SmallTopAppBar
import com.catbit.mwckobweb.components.buttons.common_buttons.FilledButton
import com.catbit.mwckobweb.components.buttons.icon_button.FilledIconButton
import com.catbit.mwckobweb.components.buttons.icon_button.IconButton
import com.catbit.mwckobweb.components.icons.Icon
import com.catbit.mwckobweb.components.progress_indicators.CircularProgressIndicator
import com.catbit.mwckobweb.components.progress_indicators.LinearProgressIndicator
import com.catbit.mwckobweb.components.search_bar.SearchBar
import com.catbit.mwckobweb.components.text.Text
import com.catbit.mwckobweb.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.icons.MoonIcon
import com.varabyte.kobweb.silk.components.icons.SunIcon
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.shapes.RectF
import com.varabyte.kobweb.silk.theme.shapes.clip
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Page("/")
@Composable
fun Index() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .overflow {
                y(Overflow.Auto)
            }
            .background(MaterialTheme.colorScheme.background)
    ) {

        SmallTopAppBar(
            modifier = Modifier.fillMaxWidth(),
            navigationIcon = {
                IconButton(
                    onClick = {

                    }
                ) {
                    Icon("arrow_back")
                }
            },
            title = {
                Text("MWC for Kobweb")
            },
            actions = {

                var colorMode by ColorMode.currentState

                IconButton(
                    onClick = {
                        colorMode = colorMode.opposite
                    }
                ) {
                    Icon(if (colorMode.isLight) "dark_mode" else "light_mode")
                }
            }
        )

        var query by remember { mutableStateOf("") }

        SearchBar(
            modifier = Modifier.width(50.percent),
            query = query,
            onQueryChange = {
                query = it
            },
            leadingIcon = {
                Icon("search")
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        query = ""
                    }
                ) {
                    Icon("clear")
                }
            }
        )
    }
}