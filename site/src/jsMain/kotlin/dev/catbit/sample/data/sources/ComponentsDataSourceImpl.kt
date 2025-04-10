package dev.catbit.sample.data.sources

import dev.catbit.sample.data.models.components.app_bars.top_app_bars.CenterAlignedTopAppBarComponentModel
import dev.catbit.sample.data.models.components.app_bars.top_app_bars.LargeTopAppBarComponentModel
import dev.catbit.sample.data.models.components.app_bars.top_app_bars.MediumTopAppBarComponentModel
import dev.catbit.sample.data.models.components.app_bars.top_app_bars.SmallTopAppBarComponentModel
import dev.catbit.sample.data.models.components.buttons.*
import dev.catbit.sample.data.models.components.buttons.floating_action_button.FloatingActionButtonComponentModel
import dev.catbit.sample.data.models.components.buttons.icon_buttons.FilledIconButtonComponentModel
import dev.catbit.sample.data.models.components.buttons.icon_buttons.FilledTonalIconButtonComponentModel
import dev.catbit.sample.data.models.components.buttons.icon_buttons.IconButtonComponentModel
import dev.catbit.sample.data.models.components.buttons.icon_buttons.OutlinedIconButtonComponentModel
import dev.catbit.sample.data.models.components.checkbox.CheckboxComponentModel
import dev.catbit.sample.data.models.components.chip.AssistChipComponentModel
import dev.catbit.sample.data.models.components.chip.FilterChipComponentModel
import dev.catbit.sample.data.models.components.chip.InputChipComponentModel
import dev.catbit.sample.data.models.components.chip.SuggestionChipComponentModel
import dev.catbit.sample.data.models.components.image.ImageComponentModel

class ComponentsDataSourceImpl : ComponentsDataSource {

    override fun getComponent(componentName: String) = components[componentName]

    override fun getAllComponents() = components.values.toList()

    private val components = mapOf(
        "filled-button" to FilledButtonComponentModel,
        "image" to ImageComponentModel,
        "icon" to IconButtonComponentModel,
        "suggestion-chip" to SuggestionChipComponentModel,
        "input-chip" to InputChipComponentModel,
        "filter-chip" to FilterChipComponentModel,
        "assist-chip" to AssistChipComponentModel,
        "checkbox" to CheckboxComponentModel,
        "filled-icon-button" to FilledIconButtonComponentModel,
        "filled-tonal-icon-button" to FilledTonalIconButtonComponentModel,
        "icon-button" to IconButtonComponentModel,
        "outlined-icon-button" to OutlinedIconButtonComponentModel,
        "elevated-button" to ElevatedButtonComponentModel,
        "filled-button" to FilledButtonComponentModel,
        "filled-tonal" to FilledTonalButtonComponentModel,
        "outlined-button" to OutlinedButtonComponentModel,
        "text-button" to TextButtonComponentModel,
        "center-aligned-top-app-bar" to CenterAlignedTopAppBarComponentModel,
        "large-top-app-bar" to LargeTopAppBarComponentModel,
        "medium-top-app-bar" to MediumTopAppBarComponentModel,
        "small-top-app-bar" to SmallTopAppBarComponentModel,
        "fab" to FloatingActionButtonComponentModel,
    )
}