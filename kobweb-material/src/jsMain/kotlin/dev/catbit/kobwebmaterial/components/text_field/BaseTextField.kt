package dev.catbit.kobwebmaterial.components.text_field

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.varabyte.kobweb.compose.dom.GenericTag
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.px
import org.w3c.dom.HTMLElement

@Composable
internal fun BaseTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    style: String,
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

    val textFieldRef = remember { mutableStateOf<HTMLElement?>(null) }

    LaunchedEffect(value) {
        textFieldRef.value?.let { element ->
            element.setAttribute("value", value)
            element.asDynamic().value = value
        }
    }

    GenericTag(
        name = style,
        attrs = modifier
            .minHeight(56.px)
            .toAttrs {
                attr("value", value)
                attr("type", inputType.type)
                attr("rows", rows.toString())
                if (!enabled) attr("disabled", "")
                if (readOnly) attr("readonly", "")
                label?.let { attr("label", label) }
                placeholder?.let { attr("placeholder", placeholder) }
                prefix?.let { attr("prefix-text", prefix) }
                suffix?.let { attr("suffix-text", suffix) }
                pattern?.let { attr("pattern", pattern) }
                supportingText?.let { attr("supporting-text", supportingText) }
                error?.let {
                    attr("error", "")
                    attr("error-text", error)
                }
                maxLength?.let { attr("maxlength", maxLength.toString()) }

                ref { element ->

                    textFieldRef.value = element as HTMLElement

                    element.addEventListener("input", { event ->
                        val newValue = (event.target?.asDynamic().value as? String) ?: ""
                        onValueChange(newValue)
                    })

                    onDispose {
                        element.removeEventListener("input", {})
                    }
                }
            }
    ) {
        leadingIcon?.let {
            Box(
                modifier = Modifier.attrsModifier {
                    attr("slot", "leading-icon")
                }
            ) {
                leadingIcon()
            }
        }
        trailingIcon?.let {
            Box(
                modifier = Modifier.attrsModifier {
                    attr("slot", "trailing-icon")
                }
            ) {
                trailingIcon()
            }
        }
    }
}

enum class InputType(val type: String) {
    Text("text"),
    Email("email"),
    Number("number"),
    Password("password"),
    Search("search"),
    Tel("tel"),
    Url("url"),
    TextArea("textarea")
}