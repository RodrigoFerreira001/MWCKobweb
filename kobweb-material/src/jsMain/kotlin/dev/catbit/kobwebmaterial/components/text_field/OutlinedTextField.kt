package dev.catbit.kobwebmaterial.components.text_field

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier

@Composable
fun OutlinedTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    inputType: InputType = InputType.Text,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    label: String? = null,
    placeholder: String? = null,
    prefix: String? = null,
    suffix: String? = null,
    supportingText: String? = null,
    error: String? = null,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    maxLength: Int? = null,
    pattern: String? = null,
    rows: Int = 1,
) {
    BaseTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        style = "md-outlined-text-field",
        inputType = inputType,
        enabled = enabled,
        readOnly = readOnly,
        label = label,
        placeholder = placeholder,
        prefix = prefix,
        suffix = suffix,
        supportingText = supportingText,
        error = error,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        maxLength = maxLength,
        pattern = pattern,
        rows = rows,
    )
}