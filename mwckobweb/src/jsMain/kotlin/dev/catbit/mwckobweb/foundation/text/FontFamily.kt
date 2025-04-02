package dev.catbit.mwckobweb.foundation.text

import androidx.compose.runtime.Immutable

@Immutable
data class FontFamily(internal val name: String) {
    companion object {
        val Default = FontFamily("default")
        val SansSerif = FontFamily("sans-serif")
        val Serif = FontFamily("serif")
        val Monospace = FontFamily("monospace")
        val Cursive = FontFamily("cursive")
    }
}