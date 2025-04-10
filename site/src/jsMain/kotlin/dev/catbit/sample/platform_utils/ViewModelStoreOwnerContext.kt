package dev.catbit.sample.platform_utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import com.varabyte.kobweb.core.rememberPageContext

@Composable
fun ViewModelStoreOwnerContext(
    content: @Composable () -> Unit
) {
    val pageContext = rememberPageContext()
    
    CompositionLocalProvider(
        LocalViewModelStoreOwner provides ViewModelStoreOwners[pageContext.route.path]
    ) {
        content()
    }
}