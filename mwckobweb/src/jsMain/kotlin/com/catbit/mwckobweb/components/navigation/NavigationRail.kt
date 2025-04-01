package com.catbit.mwckobweb.components.navigation

import androidx.compose.runtime.Composable
import com.catbit.mwckobweb.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import org.jetbrains.compose.web.css.px

@Composable
fun NavigationRail(
    modifier: Modifier = Modifier,
    menu: (@Composable () -> Unit)? = null,
    floatingActionButton: (@Composable () -> Unit)? = null,
    verticalPadding: CSSLengthOrPercentageNumericValue = 44.px,
    contentArrangement: Arrangement.Vertical = Arrangement.spacedBy(12.px, Alignment.Top),
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .overflow {
                y(Overflow.Auto)
                x(Overflow.Hidden)
            }
            .background(MaterialTheme.colorScheme.surface)
            .padding(
                topBottom = verticalPadding,
                leftRight = 12.px,
            ),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        menu?.let {
            Box(
                modifier = Modifier
                    .maxSize(48.px)
                    .margin(bottom = 4.px)
            ) {
                menu()
            }
        }

        floatingActionButton?.let {
            Box(
                modifier = Modifier.margin(bottom = 40.px)
            ) {
                floatingActionButton()
            }
        }

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = contentArrangement,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            content()
        }
    }
}