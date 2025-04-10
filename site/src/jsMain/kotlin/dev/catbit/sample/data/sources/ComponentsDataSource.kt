package dev.catbit.sample.data.sources

import dev.catbit.sample.data.models.components.ComponentModel

interface ComponentsDataSource {
    fun getComponent(componentName: String): ComponentModel?
    fun getAllComponents(): List<ComponentModel>
}