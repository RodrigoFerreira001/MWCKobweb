package dev.catbit.sample.platform_utils

import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner

object ViewModelStoreOwners {
    private val viewModelStoreOwners = mutableMapOf<String, ViewModelStoreOwner>()

    operator fun get(ownerId: String): ViewModelStoreOwner = viewModelStoreOwners[ownerId] ?: object : ViewModelStoreOwner {
        override val viewModelStore = ViewModelStore()
    }.also {
        viewModelStoreOwners[ownerId] = it
    }

    fun remove(ownerId: String) {
        viewModelStoreOwners.remove(ownerId)
    }
}