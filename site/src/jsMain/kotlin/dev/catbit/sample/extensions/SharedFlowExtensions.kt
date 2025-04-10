package dev.catbit.sample.extensions

import androidx.compose.runtime.Composable
import dev.catbit.kobwebmaterial.foundation.effects.SingleEffect
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest

@Composable
fun <T> SharedFlow<T>.consume(
    action: suspend (value: T) -> Unit
) {
    SingleEffect {
        collectLatest {
            action(it)
        }
    }
}