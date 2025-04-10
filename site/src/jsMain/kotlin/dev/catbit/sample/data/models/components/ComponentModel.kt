package dev.catbit.sample.data.models.components

import androidx.compose.runtime.Composable

interface ComponentModel {
    val identifier: String
    val searchTerms: List<String>
    val title: String
    val description: String
    val briefDescription: String
    val image: String
    val codeExample: String
    val params: List<ComponentParam>
    val composableExample: @Composable () -> Unit
}