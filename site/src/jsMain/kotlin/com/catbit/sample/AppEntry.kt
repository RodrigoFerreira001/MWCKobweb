package com.catbit.sample

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.catbit.sample.ui.theme.SampleTheme
import com.varabyte.kobweb.compose.css.dvh
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.silk.SilkApp
import com.varabyte.kobweb.silk.components.layout.Surface
import com.varabyte.kobweb.silk.defer.DeferringHost
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.style.common.SmoothColorStyle
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.loadFromLocalStorage
import com.varabyte.kobweb.silk.theme.colors.saveToLocalStorage
import com.varabyte.kobweb.silk.theme.colors.systemPreference
import org.jetbrains.compose.web.css.vw

private const val COLOR_MODE_KEY = "sample:colorMode"

@InitSilk
fun initColorMode(ctx: InitSilkContext) {
    ctx.config.initialColorMode = ColorMode.loadFromLocalStorage(COLOR_MODE_KEY) ?: ColorMode.systemPreference
}

@App
@Composable
fun AppEntry(content: @Composable () -> Unit) {
    DeferringHost {
        SilkApp {
            val colorMode = ColorMode.current
            LaunchedEffect(colorMode) {
                colorMode.saveToLocalStorage(COLOR_MODE_KEY)
            }

            SampleTheme {
                Surface(
                    SmoothColorStyle.toModifier()
                        .height(100.dvh)
                        .width(100.vw)
                ) {
                    content()
                }
            }
        }
    }
}
