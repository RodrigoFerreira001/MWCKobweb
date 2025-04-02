package dev.catbit.mwckobweb.components.navigation

import androidx.compose.runtime.Composable
import dev.catbit.mwckobweb.components.ripple.RippleContainer
import dev.catbit.mwckobweb.foundation.modifiers.textStyle
import dev.catbit.mwckobweb.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.theme.shapes.RectF
import com.varabyte.kobweb.silk.theme.shapes.clip
import org.jetbrains.compose.web.css.px

@Composable
fun NavigationRailItem(
    selected: Boolean,
    icon: @Composable () -> Unit,
    text: @Composable () -> Unit,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .userSelect(UserSelect.None)
            .minWidth(48.px),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.px)
    ) {
        RippleContainer(
            modifier = Modifier
                .backgroundColor(
                    if (selected)
                        MaterialTheme.colorScheme.secondaryContainer
                    else
                        MaterialTheme.colorScheme.surface
                )
                .color(
                    if (selected)
                        MaterialTheme.colorScheme.onSecondaryContainer
                    else
                        MaterialTheme.colorScheme.onSurfaceVariant
                )
                .clip(RectF(MaterialTheme.shape.full))
                .height(32.px)
                .width(64.px),
            onClick = onClick
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                icon()
            }
        }
        Box(
            modifier = Modifier
                .textStyle(MaterialTheme.typography.labelMedium)
                .fontWeight(
                    if (selected)
                        FontWeight.Medium
                    else
                        FontWeight.SemiBold
                )
                .color(
                    if (selected)
                        MaterialTheme.colorScheme.onSurface
                    else
                        MaterialTheme.colorScheme.onSurfaceVariant
                )
        ) {
            text()
        }
    }
}