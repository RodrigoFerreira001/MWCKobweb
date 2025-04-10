package dev.catbit.sample.platform_utils

import androidx.compose.ui.platform.UriHandler
import kotlinx.browser.window

class UriHandler : UriHandler {
    override fun openUri(uri: String) {
        window.open(uri, "_blank")
    }
}