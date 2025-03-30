package com.catbit.mwckobweb.components.progress_indicators

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.dom.GenericTag
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs

@Composable
internal fun BaseProgressIndicator(
    modifier: Modifier = Modifier,
    value: Double? = null,
    indeterminate: Boolean = false,
    progressStyle: String,
) {
    GenericTag(
        name = progressStyle,
        attrs = modifier.toAttrs {
            value?.let { attr("value", value.toString()) }
            if (indeterminate && value == null) {
                attr("indeterminate", "")
            }
        }
    )
}