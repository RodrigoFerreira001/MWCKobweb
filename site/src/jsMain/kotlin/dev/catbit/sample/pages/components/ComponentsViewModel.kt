package dev.catbit.sample.pages.components

import com.catbit.mywedding.ui.base.StateHolder
import dev.catbit.sample.data.sources.ComponentsDataSource
import dev.catbit.sample.extensions.updateAs
import kotlinx.coroutines.flow.MutableStateFlow

class ComponentsViewModel(
    path: String,
    private val componentsDataSource: ComponentsDataSource
) : StateHolder<State, Event, Unit>() {

    override val internalUIState = MutableStateFlow(getState(path))

    override fun onEvent(event: Event) {
        when(event) {
            is Event.OnSearchQueryChange -> onSearchQueryChange(event)
            Event.OnSearchQueryClear -> onSearchQueryClear()
        }
    }

    private fun onSearchQueryChange(event: Event.OnSearchQueryChange) {
        internalUIState.updateAs<State.Default> {
            copy(query = event.newQuery)
        }
    }

    private fun onSearchQueryClear() {
        internalUIState.updateAs<State.Default> {
            copy(query = "")
        }
    }

    private fun getState(path: String): State = if (path == "/components") {
        State.Default(
            query = "",
            allComponents = componentsDataSource.getAllComponents()
        )
    } else
        State.Component(
            componentModel = componentsDataSource.getComponent(path.removePrefix("/components/"))
        )
}