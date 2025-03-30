package com.catbit.mwckobweb.components.app_bars.top_app_bars

import androidx.compose.runtime.Composable
import com.catbit.mwckobweb.foundation.theme.MaterialTheme
import org.jetbrains.compose.web.css.CSSColorValue

data class TopAppBarColors(
    val containerColor: CSSColorValue,
    val navigationIconContentColor: CSSColorValue,
    val titleContentColor: CSSColorValue,
    val actionIconContentColor: CSSColorValue,
) {
    companion object {
        @Composable
        fun Default() = TopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface,
            navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
            titleContentColor = MaterialTheme.colorScheme.onSurface,
            actionIconContentColor = MaterialTheme.colorScheme.onSurface,
        )
    }
}