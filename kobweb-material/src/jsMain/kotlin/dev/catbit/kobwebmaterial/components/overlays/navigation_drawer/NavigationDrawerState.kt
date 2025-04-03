package dev.catbit.kobwebmaterial.components.overlays.navigation_drawer

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import dev.catbit.kobwebmaterial.foundation.theme.MaterialTheme
import org.jetbrains.compose.web.css.CSSColorValue

class NavigationDrawerState(
    internal val containerColor: CSSColorValue,
) {
    internal var isVisible by mutableStateOf(false)
        private set

    internal var isCancellable = false
        private set

    internal var content: @Composable ColumnScope.() -> Unit = {}
        private set

    internal var onDismissRequest: () -> Unit = {}
        private set

    fun dismiss() {
        isVisible = false
    }

    fun show(
        onDismissRequest: () -> Unit = {},
        isCancellable: Boolean = true,
        content: @Composable ColumnScope.() -> Unit
    ) {
        this.onDismissRequest = onDismissRequest
        this.isCancellable = isCancellable
        this.content = content

        isVisible = true
    }
}

@Composable
fun rememberNavigationDrawerState(
    containerColor: CSSColorValue = MaterialTheme.colorScheme.surfaceContainerLow,
) = remember {
    NavigationDrawerState(
        containerColor = containerColor
    )
}