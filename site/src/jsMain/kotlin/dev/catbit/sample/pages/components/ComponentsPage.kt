package dev.catbit.sample.pages.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.theme.shapes.RectF
import com.varabyte.kobweb.silk.theme.shapes.clip
import dev.catbit.kobwebmaterial.components.buttons.icon_button.IconButton
import dev.catbit.kobwebmaterial.components.icons.Icon
import dev.catbit.kobwebmaterial.components.ripple.RippleContainer
import dev.catbit.kobwebmaterial.components.search_bar.SearchBar
import dev.catbit.kobwebmaterial.components.text.Text
import dev.catbit.kobwebmaterial.foundation.theme.MaterialTheme
import dev.catbit.sample.platform_utils.ViewModelStoreOwnerContext
import dev.catbit.sample.ui.composables.ComponentCard
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun ComponentsPage(path: String) {
    ViewModelStoreOwnerContext {

        val stateHolder: ComponentsViewModel = koinViewModel {
            parametersOf(path)
        }
        val uiState by stateHolder.uiState.collectAsState()

        Column(
            modifier = Modifier
                .overflow { y(Overflow.Auto) }
                .fillMaxSize()
                .padding(24.px)
        ) {

            ComponentsPageContent(
                uiState = uiState,
                onEvent = {
                    stateHolder.onEvent(it)
                }
            )
        }
    }
}

@Composable
private fun ColumnScope.ComponentsPageContent(
    uiState: State,
    onEvent: (Event) -> Unit
) {
    when (uiState) {
        is State.Default -> ComponentsPageContentDefault(uiState, onEvent)
        is State.Component -> ComponentsPageContentContent(uiState, onEvent)
    }
}


@Composable
private fun ColumnScope.ComponentsPageContentDefault(
    uiState: State.Default,
    onEvent: (Event) -> Unit
) {

    val pageContext = rememberPageContext()

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        SearchBar(
            modifier = Modifier.width(50.percent),
            query = uiState.query,
            leadingIcon = {
                Icon("search")
            },
            trailingIcon = uiState.query.takeIf { it.isNotEmpty() }?.let {
                {
                    RippleContainer(
                        modifier = Modifier
                            .clip(RectF(MaterialTheme.shape.full))
                            .size(24.px),
                        onClick = {
                            onEvent(Event.OnSearchQueryClear)
                        }
                    ) {
                        Icon(
                            modifier = Modifier,
                            name = "clear"
                        )
                    }
                }
            },
            hint = "Search for Material Components",
            onQueryChange = {
                onEvent(Event.OnSearchQueryChange(it))
            }
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .padding(top = 24.px, leftRight = 48.px)
            .overflow { y(Overflow.Auto) }
            .display(DisplayStyle.Flex)
            .flexWrap(FlexWrap.Wrap)
            .gap(16.px),
    ) {
        uiState.allComponents
            .filter {
                it.searchTerms.any { searchTerm ->
                    searchTerm.contains(uiState.query, ignoreCase = true)
                }
            }
            .forEach { component ->
                ComponentCard(
                    modifier = Modifier.size(250.px),
                    onClick = {
                        pageContext.router.tryRoutingTo("/components/${component.identifier}")
                    },
                    componentModel = component
                )
            }
    }
}

@Composable
private fun ComponentsPageContentContent(
    uiState: State.Component,
    onEvent: (Event) -> Unit
) {
    uiState.componentModel?.let {
        Text(it.title)
    } ?: run {
        Text("Unknown component")
    }
}