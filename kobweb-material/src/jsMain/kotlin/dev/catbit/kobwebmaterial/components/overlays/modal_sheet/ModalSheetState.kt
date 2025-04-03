package dev.catbit.kobwebmaterial.components.overlays.modal_sheet

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import dev.catbit.kobwebmaterial.foundation.theme.MaterialTheme
import org.jetbrains.compose.web.css.CSSColorValue

class ModalSheetState(
    internal val shape: CSSLengthOrPercentageNumericValue,
    internal val containerColor: CSSColorValue,
) {
    internal var isVisible by mutableStateOf(false)
        private set

    internal var isCancellable = false
        private set

    internal var showHandler = false
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
        showHandler: Boolean = true,
        content: @Composable ColumnScope.() -> Unit
    ) {
        this.onDismissRequest = onDismissRequest
        this.isCancellable = isCancellable
        this.showHandler = showHandler
        this.content = content

        isVisible = true
    }
}

@Composable
fun rememberModalSheetState(
    shape: CSSLengthOrPercentageNumericValue = MaterialTheme.shape.extraLarge,
    containerColor: CSSColorValue = MaterialTheme.colorScheme.surfaceContainerLow,
) = remember {
    ModalSheetState(
        shape = shape,
        containerColor = containerColor
    )
}