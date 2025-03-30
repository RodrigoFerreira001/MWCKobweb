package com.catbit.mwckobweb.foundation.effects

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.CoroutineScope

@Composable
fun SingleEffect(
    block: suspend CoroutineScope.() -> Unit
) {
    LaunchedEffect(Unit) {
        block()
    }
}