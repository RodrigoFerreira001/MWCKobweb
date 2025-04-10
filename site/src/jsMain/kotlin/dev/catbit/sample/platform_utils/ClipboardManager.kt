package dev.catbit.sample.platform_utils

import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import kotlinx.browser.window
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.await
import kotlinx.coroutines.launch

class ClipboardManager : ClipboardManager {
    @OptIn(DelicateCoroutinesApi::class)
    override fun getText() = buildAnnotatedString {
        GlobalScope.launch {
            append(window.navigator.clipboard.readText().await())
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun setText(annotatedString: AnnotatedString) {
        GlobalScope.launch {
            window.navigator.clipboard.writeText(annotatedString.toString())
        }
    }
}