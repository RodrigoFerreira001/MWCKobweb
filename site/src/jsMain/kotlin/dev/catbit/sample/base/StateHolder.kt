package com.catbit.mywedding.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class StateHolder<State, Event, Effect> : ViewModel() {

    protected abstract val internalUIState: MutableStateFlow<State>
    val uiState get() = internalUIState.asStateFlow()

    protected val internalEffects = MutableSharedFlow<Effect>()
    val effects get() = internalEffects.asSharedFlow()

    abstract fun onEvent(event: Event)

    fun MutableSharedFlow<Effect>.dispatch(effect: Effect) {
        viewModelScope.launch {
            emit(effect)
        }
    }
}