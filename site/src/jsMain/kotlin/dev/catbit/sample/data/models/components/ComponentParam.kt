package dev.catbit.sample.data.models.components

data class ComponentParam(
    val name: String,
    val type: String,
    val optional: Boolean,
    val defaultValue: String?,
    val description: String
)