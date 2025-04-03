package dev.catbit.kobwebmaterial.components.overlays.navigation_drawer

import androidx.compose.runtime.Composable
import dev.catbit.kobwebmaterial.components.ripple.RippleContainer
import dev.catbit.kobwebmaterial.foundation.modifiers.textStyle
import dev.catbit.kobwebmaterial.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.theme.shapes.RectF
import com.varabyte.kobweb.silk.theme.shapes.clip
import org.jetbrains.compose.web.css.px

@Composable
fun NavigationDrawerItem(
    selected: Boolean,
    icon: @Composable () -> Unit,
    text: @Composable () -> Unit,
    trailingIcon: (@Composable () -> Unit)? = null,
    onClick: () -> Unit
) {
    RippleContainer(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.px)
            .padding(left = 16.px, right = 24.px)
            .backgroundColor(
                if (selected)
                    MaterialTheme.colorScheme.secondaryContainer
                else
                    MaterialTheme.colorScheme.surfaceContainerLow
            )
            .color(
                if (selected)
                    MaterialTheme.colorScheme.onSecondaryContainer
                else
                    MaterialTheme.colorScheme.onSurfaceVariant
            )
            .clip(RectF(MaterialTheme.shape.full)),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.px)
            ) {
                icon()
                Box(
                    modifier = Modifier
                        .textStyle(MaterialTheme.typography.labelLarge)
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
            trailingIcon?.invoke()
        }
    }
}