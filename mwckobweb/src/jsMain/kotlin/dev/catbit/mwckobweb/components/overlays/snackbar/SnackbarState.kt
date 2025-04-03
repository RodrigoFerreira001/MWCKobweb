package dev.catbit.mwckobweb.components.overlays.snackbar

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import dev.catbit.mwckobweb.foundation.theme.MaterialTheme
import kotlinx.coroutines.*
import org.jetbrains.compose.web.css.CSSColorValue

class SnackbarState(
    internal val shape: CSSLengthOrPercentageNumericValue,
    internal val containerColor: CSSColorValue,
    internal val contentColor: CSSColorValue,
    internal val actionColor: CSSColorValue,
) {
    internal var isVisible by mutableStateOf(false)
        private set

    internal var duration: SnackbarDuration = SnackbarDuration.Short()
        private set

    internal var displayCloseButton: Boolean = false
        private set

    internal var action: (@Composable () -> Unit)? = null
        private set

    internal var message: @Composable () -> Unit = {}
        private set

    internal var onDismissRequest: () -> Unit = {}
        private set

    fun dismiss() {
        isVisible = false
    }

    fun show(
        onDismissRequest: () -> Unit = {},
        duration: SnackbarDuration = SnackbarDuration.Short(),
        displayCloseButton: Boolean = false,
        action: (@Composable () -> Unit)? = null,
        message: @Composable () -> Unit
    ) {
        this.onDismissRequest = onDismissRequest
        this.duration = duration
        this.displayCloseButton = displayCloseButton
        this.action = action
        this.message = message

        isVisible = true
    }
}

@Composable
fun rememberSnackbarState(
    shape: CSSLengthOrPercentageNumericValue = MaterialTheme.shape.extraSmall,
    containerColor: CSSColorValue = MaterialTheme.colorScheme.inverseSurface,
    contentColor: CSSColorValue = MaterialTheme.colorScheme.inverseOnSurface,
    actionColor: CSSColorValue = MaterialTheme.colorScheme.inversePrimary,
) = remember {
    SnackbarState(
        shape = shape,
        containerColor = containerColor,
        contentColor = contentColor,
        actionColor = actionColor,
    )
}