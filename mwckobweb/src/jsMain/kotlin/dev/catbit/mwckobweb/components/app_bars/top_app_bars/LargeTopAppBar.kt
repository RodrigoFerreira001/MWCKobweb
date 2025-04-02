package dev.catbit.mwckobweb.components.app_bars.top_app_bars

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import dev.catbit.mwckobweb.foundation.locals.LocalTextStyle
import dev.catbit.mwckobweb.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.px

@Composable
fun LargeTopAppBar(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,
    navigationIcon: @Composable () -> Unit,
    actions: (@Composable RowScope.() -> Unit)? = null,
    colors: TopAppBarColors = TopAppBarColors.Default()
) {
    Column(
        modifier = modifier
            .minHeight(152.px)
            .overflow(Overflow.Hidden)
            .backgroundColor(colors.containerColor),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .styleModifier {
                        property("--md-sys-color-primary", colors.navigationIconContentColor)
                        property("--md-sys-color-on-surface-variant", colors.navigationIconContentColor)
                        property("color", colors.navigationIconContentColor)
                    },
                contentAlignment = Alignment.Center
            ) {
                navigationIcon()
            }

            actions?.let {
                Row(
                    modifier = Modifier
                        .styleModifier {
                            property("--md-sys-color-primary", colors.actionIconContentColor)
                            property("--md-sys-color-on-surface-variant", colors.actionIconContentColor)
                            property("color", colors.actionIconContentColor)
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    actions()
                }
            }
        }

        Box(
            modifier = Modifier
                .userSelect(UserSelect.None)
                .fillMaxWidth()
                .padding(left = 16.px, right = 16.px, bottom = 28.px)
                .styleModifier {
                    property("--md-sys-color-primary", colors.titleContentColor)
                    property("--md-sys-color-on-surface-variant", colors.titleContentColor)
                    property("color", colors.titleContentColor)
                }
        ) {
            CompositionLocalProvider(LocalTextStyle provides MaterialTheme.typography.headlineMedium) {
                title()
            }
        }
    }
}