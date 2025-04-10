package dev.catbit.sample.pages.components

import dev.catbit.sample.data.models.components.ComponentModel

sealed interface State {
    data class Default(
        val query: String,
        val allComponents: List<ComponentModel>
    ) : State

    data class Component(
        val componentModel: ComponentModel?
    ) : State
}

sealed interface Event {
    data class OnSearchQueryChange(val newQuery: String) : Event
    data object OnSearchQueryClear : Event
}