package dev.catbit.sample.extensions

import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.text.buildAnnotatedString

fun ClipboardManager.writeText(text: String) {
    setText(buildAnnotatedString { append(text) })
}