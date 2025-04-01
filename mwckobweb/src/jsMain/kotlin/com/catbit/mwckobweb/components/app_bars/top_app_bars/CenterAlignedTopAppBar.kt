package com.catbit.mwckobweb.components.app_bars.top_app_bars

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.catbit.mwckobweb.foundation.locals.LocalTextStyle
import com.catbit.mwckobweb.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.RowScope
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.px

@Composable
fun CenterAlignedTopAppBar(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,
    navigationIcon: @Composable () -> Unit,
    actions: (@Composable RowScope.() -> Unit)? = null,
    colors: TopAppBarColors = TopAppBarColors.Default()
) {
    Row(
        modifier = modifier
            .minHeight(64.px)
            .overflow(Overflow.Hidden)
            .backgroundColor(colors.containerColor),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .styleModifier {
                    property("--md-sys-color-primary", colors.navigationIconContentColor)
                    property("--md-sys-color-on-surface-variant", colors.navigationIconContentColor)
                    property("color", colors.navigationIconContentColor)
                }
        ) {
            navigationIcon()
        }

        Box(
            modifier = Modifier
                .userSelect(UserSelect.None)
                .weight(1f)
                .margin(leftRight = 24.px)
                .styleModifier {
                    property("--md-sys-color-primary", colors.titleContentColor)
                    property("--md-sys-color-on-surface-variant", colors.titleContentColor)
                    property("color", colors.titleContentColor)
                },
            contentAlignment = Alignment.Center
        ) {
            CompositionLocalProvider(LocalTextStyle provides MaterialTheme.typography.titleLarge) {
                title()
            }
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
        } ?: run {
            Box(modifier = Modifier.size(48.px))
        }
    }
}