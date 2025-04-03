package dev.catbit.kobwebmaterial.components.overlays.dialog

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.foundation.layout.RowScope
import dev.catbit.kobwebmaterial.foundation.theme.MaterialTheme
import org.jetbrains.compose.web.css.CSSColorValue

class DialogState(
    internal val shape: CSSLengthOrPercentageNumericValue,
    internal val containerColor: CSSColorValue,
) {
    internal var isCancellable = false
        private set

    internal var isVisible by mutableStateOf(false)
        private set

    internal var icon: (@Composable ColumnScope.() -> Unit)? = null
        private set

    internal var headline: @Composable ColumnScope.() -> Unit = {}
        private set

    internal var supportingText: @Composable ColumnScope.() -> Unit = {}
        private set

    internal var buttons: @Composable RowScope.() -> Unit = {}
        private set

    internal var content: (@Composable ColumnScope.() -> Unit)? = null
        private set

    internal var onDismissRequest: () -> Unit = {}
        private set

    fun dismiss() {
        isVisible = false
    }

    fun show(
        onDismissRequest: () -> Unit = {},
        isCancellable: Boolean = true,
        icon: (@Composable ColumnScope.() -> Unit)? = null,
        headline: @Composable ColumnScope.() -> Unit,
        supportingText: @Composable ColumnScope.() -> Unit,
        buttons: @Composable RowScope.() -> Unit,
        content: (@Composable ColumnScope.() -> Unit)? = null
    ) {
        this.onDismissRequest = onDismissRequest
        this.isCancellable = isCancellable
        this.icon = icon
        this.headline = headline
        this.supportingText = supportingText
        this.buttons = buttons
        this.content = content

        isVisible = true
    }
}

@Composable
fun rememberDialogState(
    shape: CSSLengthOrPercentageNumericValue = MaterialTheme.shape.extraLarge,
    containerColor: CSSColorValue = MaterialTheme.colorScheme.surfaceContainerHigh,
) = remember {
    DialogState(
        shape = shape,
        containerColor = containerColor
    )
}