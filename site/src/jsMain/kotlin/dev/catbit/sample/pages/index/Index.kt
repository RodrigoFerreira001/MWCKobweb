package dev.catbit.sample.pages.index

import androidx.compose.runtime.*
import dev.catbit.mwckobweb.components.app_bars.top_app_bars.CenterAlignedTopAppBar
import dev.catbit.mwckobweb.components.app_bars.top_app_bars.LargeTopAppBar
import dev.catbit.mwckobweb.components.app_bars.top_app_bars.MediumTopAppBar
import dev.catbit.mwckobweb.components.app_bars.top_app_bars.SmallTopAppBar
import dev.catbit.mwckobweb.components.buttons.common_buttons.*
import dev.catbit.mwckobweb.components.buttons.floating_action_button.FloatingActionButton
import dev.catbit.mwckobweb.components.buttons.floating_action_button.FloatingActionButtonSize
import dev.catbit.mwckobweb.components.buttons.floating_action_button.FloatingActionButtonVariant
import dev.catbit.mwckobweb.components.buttons.icon_button.FilledIconButton
import dev.catbit.mwckobweb.components.buttons.icon_button.FilledTonalIconButton
import dev.catbit.mwckobweb.components.buttons.icon_button.IconButton
import dev.catbit.mwckobweb.components.buttons.icon_button.OutlinedIconButton
import dev.catbit.mwckobweb.components.checkbox.Checkbox
import dev.catbit.mwckobweb.components.chip.AssistChip
import dev.catbit.mwckobweb.components.chip.FilterChip
import dev.catbit.mwckobweb.components.chip.InputChip
import dev.catbit.mwckobweb.components.chip.SuggestionChip
import dev.catbit.mwckobweb.components.icons.Icon
import dev.catbit.mwckobweb.components.navigation.NavigationBar
import dev.catbit.mwckobweb.components.navigation.NavigationBarItem
import dev.catbit.mwckobweb.components.navigation.NavigationRail
import dev.catbit.mwckobweb.components.navigation.NavigationRailItem
import dev.catbit.mwckobweb.components.overlays.dialog.Dialog
import dev.catbit.mwckobweb.components.overlays.modal_sheet.ModalSheet
import dev.catbit.mwckobweb.components.overlays.navigation_drawer.NavigationDrawer
import dev.catbit.mwckobweb.components.overlays.navigation_drawer.NavigationDrawerItem
import dev.catbit.mwckobweb.components.overlays.snackbar.Snackbar
import dev.catbit.mwckobweb.components.overlays.snackbar.SnackbarDuration
import dev.catbit.mwckobweb.components.progress_indicators.CircularProgressIndicator
import dev.catbit.mwckobweb.components.progress_indicators.LinearProgressIndicator
import dev.catbit.mwckobweb.components.radio_button.RadioButton
import dev.catbit.mwckobweb.components.ripple.RippleContainer
import dev.catbit.mwckobweb.components.search_bar.SearchBar
import dev.catbit.mwckobweb.components.switch.Switch
import dev.catbit.mwckobweb.components.text.Text
import dev.catbit.mwckobweb.components.text_field.FilledTextField
import dev.catbit.mwckobweb.components.text_field.OutlinedTextField
import dev.catbit.mwckobweb.foundation.modifiers.textStyle
import dev.catbit.mwckobweb.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.shapes.RectF
import com.varabyte.kobweb.silk.theme.shapes.clip
import org.jetbrains.compose.web.css.px

@Page("/")
@Composable
fun Index() {

    var isNavDrawerOpened by remember { mutableStateOf(false) }
    var isModalSheetOpened by remember { mutableStateOf(false) }
    var isDialogOpened by remember { mutableStateOf(false) }
    var isSnackbarOpened by remember { mutableStateOf(false) }

    var selectedNavigation by remember { mutableStateOf("home") }
    val navigations = listOf(
        "Home" to "home",
        "Forum" to "forum",
        "Settings" to "settings"
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .overflow(Overflow.Hidden)
        ) {
            NavigationRail(
                modifier = Modifier.fillMaxHeight(),
                menu = {
                    IconButton(
                        onClick = {
                            isNavDrawerOpened = true
                        }
                    ) {
                        Icon("menu")
                    }
                }
            ) {
                navigations.forEach { (text, icon) ->
                    NavigationRailItem(
                        selected = icon == selectedNavigation,
                        onClick = {
                            selectedNavigation = icon
                        },
                        icon = {
                            Icon(
                                name = icon,
                                fill = icon == selectedNavigation
                            )
                        },
                        text = {
                            Text(text)
                        }
                    )
                }

                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    var colorMode by ColorMode.currentState

                    IconButton(
                        onClick = {
                            colorMode = colorMode.opposite
                        }
                    ) {
                        Icon(if (colorMode.isLight) "dark_mode" else "light_mode")
                    }
                }
            }

            Column(
                modifier = Modifier
                    .padding(24.px)
                    .weight(1f)
                    .overflow { y(Overflow.Auto) }
                    .fillMaxHeight()
            ) {

                Text(
                    text = "App bars",
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "CenterAlignedTopAppBar:",
                    style = MaterialTheme.typography.titleLarge
                )

                CenterAlignedTopAppBar(
                    modifier = Modifier
                        .margin(bottom = 16.px)
                        .width(400.px),
                    navigationIcon = {
                        IconButton(
                            onClick = {

                            }
                        ) {
                            Icon("arrow_back")
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = {

                            }
                        ) {
                            Icon("favorite")
                        }
                    },
                    title = {
                        Text("MWC for Kobweb")
                    }
                )

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "LargeTopAppBar:",
                    style = MaterialTheme.typography.titleLarge
                )

                LargeTopAppBar(
                    modifier = Modifier
                        .margin(bottom = 16.px)
                        .width(400.px),
                    navigationIcon = {
                        IconButton(
                            onClick = {

                            }
                        ) {
                            Icon("arrow_back")
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = {

                            }
                        ) {
                            Icon("favorite")
                        }
                    },
                    title = {
                        Text("MWC for Kobweb")
                    }
                )

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "MediumTopAppBar:",
                    style = MaterialTheme.typography.titleLarge
                )

                MediumTopAppBar(
                    modifier = Modifier
                        .margin(bottom = 16.px)
                        .width(400.px),
                    navigationIcon = {
                        IconButton(
                            onClick = {

                            }
                        ) {
                            Icon("arrow_back")
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = {

                            }
                        ) {
                            Icon("favorite")
                        }
                    },
                    title = {
                        Text("MWC for Kobweb")
                    }
                )

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "SmallTopAppBar:",
                    style = MaterialTheme.typography.titleLarge
                )

                SmallTopAppBar(
                    modifier = Modifier
                        .margin(bottom = 16.px)
                        .width(400.px),
                    navigationIcon = {
                        IconButton(
                            onClick = {

                            }
                        ) {
                            Icon("arrow_back")
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = {

                            }
                        ) {
                            Icon("favorite")
                        }
                    },
                    title = {
                        Text("MWC for Kobweb")
                    }
                )

                Text(
                    text = "Buttons",
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "ElevatedButton:",
                    style = MaterialTheme.typography.titleLarge
                )

                ElevatedButton(
                    modifier = Modifier.margin(bottom = 16.px),
                    onClick = {

                    }
                ) {
                    Text("Click me!")
                    Icon("star")
                }

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "FilledButton:",
                    style = MaterialTheme.typography.titleLarge
                )

                FilledButton(
                    modifier = Modifier.margin(bottom = 16.px),
                    onClick = {

                    }
                ) {
                    Text("Click me!")
                    Icon("star")
                }

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "FilledTonalButton:",
                    style = MaterialTheme.typography.titleLarge
                )

                FilledTonalButton(
                    modifier = Modifier.margin(bottom = 16.px),
                    onClick = {

                    }
                ) {
                    Text("Click me!")
                    Icon("star")
                }

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "OutlinedButton:",
                    style = MaterialTheme.typography.titleLarge
                )

                OutlinedButton(
                    modifier = Modifier.margin(bottom = 16.px),
                    onClick = {

                    }
                ) {
                    Text("Click me!")
                    Icon("star")
                }

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "TextButton:",
                    style = MaterialTheme.typography.titleLarge
                )

                TextButton(
                    modifier = Modifier.margin(bottom = 16.px),
                    onClick = {

                    }
                ) {
                    Text("Click me!")
                    Icon("star")
                }

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "FloatingActionButton:",
                    style = MaterialTheme.typography.titleLarge
                )

                Row(
                    modifier = Modifier.margin(bottom = 16.px),
                    horizontalArrangement = Arrangement.spacedBy(8.px)
                ) {
                    FloatingActionButton(
                        size = FloatingActionButtonSize.Small,
                        variant = FloatingActionButtonVariant.Primary,
                        onClick = {

                        }
                    ) {
                        Icon("add")
                    }

                    FloatingActionButton(
                        size = FloatingActionButtonSize.Medium,
                        variant = FloatingActionButtonVariant.Primary,
                        onClick = {

                        }
                    ) {
                        Icon("add")
                    }

                    FloatingActionButton(
                        size = FloatingActionButtonSize.Large,
                        variant = FloatingActionButtonVariant.Primary,
                        onClick = {

                        }
                    ) {
                        Icon("add")
                    }
                }

                Row(
                    modifier = Modifier.margin(bottom = 16.px),
                    horizontalArrangement = Arrangement.spacedBy(8.px)
                ) {
                    FloatingActionButton(
                        size = FloatingActionButtonSize.Small,
                        variant = FloatingActionButtonVariant.Secondary,
                        onClick = {

                        }
                    ) {
                        Icon("add")
                    }

                    FloatingActionButton(
                        size = FloatingActionButtonSize.Medium,
                        variant = FloatingActionButtonVariant.Secondary,
                        onClick = {

                        }
                    ) {
                        Icon("add")
                    }

                    FloatingActionButton(
                        size = FloatingActionButtonSize.Large,
                        variant = FloatingActionButtonVariant.Secondary,
                        onClick = {

                        }
                    ) {
                        Icon("add")
                    }
                }

                Row(
                    modifier = Modifier.margin(bottom = 16.px),
                    horizontalArrangement = Arrangement.spacedBy(8.px)
                ) {
                    FloatingActionButton(
                        size = FloatingActionButtonSize.Small,
                        variant = FloatingActionButtonVariant.Tertiary,
                        onClick = {

                        }
                    ) {
                        Icon("add")
                    }

                    FloatingActionButton(
                        size = FloatingActionButtonSize.Medium,
                        variant = FloatingActionButtonVariant.Tertiary,
                        onClick = {

                        }
                    ) {
                        Icon("add")
                    }

                    FloatingActionButton(
                        size = FloatingActionButtonSize.Large,
                        variant = FloatingActionButtonVariant.Tertiary,
                        onClick = {

                        }
                    ) {
                        Icon("add")
                    }
                }

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "FilledIconButton:",
                    style = MaterialTheme.typography.titleLarge
                )

                FilledIconButton(
                    modifier = Modifier.margin(bottom = 16.px),
                    onClick = {

                    }
                ) {
                    Icon("home")
                }

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "FilledTonalIconButton:",
                    style = MaterialTheme.typography.titleLarge
                )

                FilledTonalIconButton(
                    modifier = Modifier.margin(bottom = 16.px),
                    onClick = {

                    }
                ) {
                    Icon("home")
                }

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "IconButton:",
                    style = MaterialTheme.typography.titleLarge
                )

                IconButton(
                    modifier = Modifier.margin(bottom = 16.px),
                    onClick = {

                    }
                ) {
                    Icon("home")
                }

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "OutlinedIconButton:",
                    style = MaterialTheme.typography.titleLarge
                )

                OutlinedIconButton(
                    modifier = Modifier.margin(bottom = 16.px),
                    onClick = {

                    }
                ) {
                    Icon("home")
                }

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "Checkbox:",
                    style = MaterialTheme.typography.headlineMedium
                )

                var isCheckboxChecked by remember { mutableStateOf(false) }

                Checkbox(
                    modifier = Modifier.margin(bottom = 16.px),
                    checked = isCheckboxChecked,
                    onCheckChange = {
                        isCheckboxChecked = !isCheckboxChecked
                    }
                )

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "Chip:",
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "AssistChip:",
                    style = MaterialTheme.typography.titleLarge
                )

                AssistChip(
                    modifier = Modifier.margin(bottom = 16.px),
                    label = "AssistChip",
                    icon = {
                        Icon("help")
                    },
                    onClick = {

                    }
                )

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "FilterChip:",
                    style = MaterialTheme.typography.titleLarge
                )

                FilterChip(
                    modifier = Modifier.margin(bottom = 16.px),
                    label = "FilterChip",
                    icon = {
                        Icon("filter")
                    },
                    onClick = {

                    }
                )

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "InputChip:",
                    style = MaterialTheme.typography.titleLarge
                )

                InputChip(
                    modifier = Modifier.margin(bottom = 16.px),
                    label = "InputChip",
                    icon = {
                        Icon("filter")
                    },
                    onRemove = {

                    },
                    onClick = {

                    }
                )

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "InputChip:",
                    style = MaterialTheme.typography.titleLarge
                )

                SuggestionChip(
                    modifier = Modifier.margin(bottom = 16.px),
                    label = "SuggestionChip",
                    onClick = {

                    }
                )

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "Icon:",
                    style = MaterialTheme.typography.headlineMedium
                )

                Row(
                    modifier = Modifier.margin(bottom = 16.px),
                    horizontalArrangement = Arrangement.spacedBy(8.px)
                ) {
                    Text(
                        text = "All icons (icon name, for example \"more_vert\") available at ",
                        style = MaterialTheme.typography.titleSmall
                    )
                    Link(
                        modifier = Modifier.textStyle(MaterialTheme.typography.titleSmall),
                        path = "https://fonts.google.com/icons?icon.set=Material+Symbols"
                    )
                }

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "Navigation:",
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "NavigationRail:",
                    style = MaterialTheme.typography.titleLarge
                )

                NavigationBar(
                    modifier = Modifier
                        .width(400.px)
                        .margin(bottom = 16.px),
                ) {
                    navigations.forEach { (text, icon) ->
                        NavigationBarItem(
                            selected = icon == selectedNavigation,
                            onClick = {
                                selectedNavigation = icon
                            },
                            icon = {
                                Icon(
                                    name = icon,
                                    fill = icon == selectedNavigation
                                )
                            },
                            text = {
                                Text(text)
                            }
                        )
                    }
                }

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "Overlays:",
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "Dialog:",
                    style = MaterialTheme.typography.titleLarge
                )

                FilledButton(
                    Modifier.margin(bottom = 16.px),
                    onClick = {
                        isDialogOpened = true
                    }
                ) {
                    Text("Open Dialog")
                }


                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "ModalSheet:",
                    style = MaterialTheme.typography.titleLarge
                )

                FilledButton(
                    Modifier.margin(bottom = 16.px),
                    onClick = {
                        isModalSheetOpened = true
                    }
                ) {
                    Text("Open ModalSheet")
                }

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "Snackbar:",
                    style = MaterialTheme.typography.titleLarge
                )

                FilledButton(
                    Modifier.margin(bottom = 16.px),
                    onClick = {
                        isSnackbarOpened = true
                    }
                ) {
                    Text("Show Snackbar")
                }

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "Progress indicators:",
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "CircularProgressIndicator:",
                    style = MaterialTheme.typography.titleLarge
                )

                CircularProgressIndicator(
                    modifier = Modifier.margin(bottom = 16.px)
                )

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "LinearProgressIndicator:",
                    style = MaterialTheme.typography.titleLarge
                )

                LinearProgressIndicator(
                    modifier = Modifier
                        .width(400.px)
                        .margin(bottom = 16.px)
                )

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "RadioButton:",
                    style = MaterialTheme.typography.headlineMedium
                )

                var selectedRadio by remember { mutableStateOf("yes") }

                Row(
                    modifier = Modifier.margin(bottom = 16.px),
                    horizontalArrangement = Arrangement.spacedBy(24.px)
                ) {
                    RadioButton(
                        groupName = "radios",
                        selected = selectedRadio == "yes",
                        value = "yes",
                        onSelect = {
                            selectedRadio = it
                        }
                    )

                    RadioButton(
                        groupName = "radios",
                        selected = selectedRadio == "no",
                        value = "no",
                        onSelect = {
                            selectedRadio = it
                        }
                    )
                }

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "RippleContainer:",
                    style = MaterialTheme.typography.headlineMedium
                )

                RippleContainer(
                    modifier = Modifier
                        .margin(bottom = 16.px)
                        .clip(RectF(MaterialTheme.shape.large))
                        .size(100.px),
                    onClick = {

                    }
                ) {
                    Box(
                        modifier = Modifier
                            .userSelect(UserSelect.None)
                            .size(100.px),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Click here!",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "Search bar:",
                    style = MaterialTheme.typography.headlineMedium
                )

                var query by remember { mutableStateOf("") }

                SearchBar(
                    modifier = Modifier
                        .width(400.px)
                        .margin(bottom = 16.px),
                    query = query,
                    onQueryChange = {
                        query = it
                    },
                    leadingIcon = {
                        Icon("search")
                    },
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                query = ""
                            }
                        ) {
                            Icon("clear")
                        }
                    }
                )

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "Switch:",
                    style = MaterialTheme.typography.headlineMedium
                )

                var isSwitchChecked by remember { mutableStateOf(false) }

                Switch(
                    modifier = Modifier.margin(bottom = 16.px),
                    selected = isSwitchChecked,
                    onChange = {
                        isSwitchChecked = it
                    }
                )

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "Text fields:",
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "FilledTextField:",
                    style = MaterialTheme.typography.titleLarge
                )

                var firstTextField by remember { mutableStateOf("") }

                FilledTextField(
                    modifier = Modifier
                        .margin(bottom = 16.px)
                        .width(400.px),
                    value = firstTextField,
                    onValueChange = {
                        firstTextField = it
                    }
                )

                Text(
                    modifier = Modifier.margin(bottom = 8.px),
                    text = "OutlinedTextField:",
                    style = MaterialTheme.typography.titleLarge
                )

                var secondTextField by remember { mutableStateOf("") }

                OutlinedTextField(
                    modifier = Modifier
                        .margin(bottom = 16.px)
                        .width(400.px),
                    value = secondTextField,
                    onValueChange = {
                        secondTextField = it
                    }
                )
            }
        }

        // Overlays

        ModalSheet(
            visible = isModalSheetOpened,
            onDismissRequest = {
                isModalSheetOpened = false
            }
        ) {
            FilledButton(
                onClick = {
                    isModalSheetOpened = false
                }
            ) {
                Text("Close ModalSheet")
            }
        }

        Dialog(
            visible = isDialogOpened,
            headline = {
                Text("Dialog example")
            },
            supportingText = {
                Text("This is a dialog example")
            },
            buttons = {
                TextButton(
                    onClick = {
                        isDialogOpened = false
                    }
                ) {
                    Text("Ok")
                }
            },
            onDismissRequest = {
                isDialogOpened = false
            }
        )

        NavigationDrawer(
            visible = isNavDrawerOpened,
            onDismissRequest = {
                isNavDrawerOpened = false
            }
        ) {
            navigations.forEach { (text, icon) ->
                NavigationDrawerItem(
                    selected = icon == selectedNavigation,
                    onClick = {
                        selectedNavigation = icon
                        isNavDrawerOpened = false
                    },
                    icon = {
                        Icon(
                            name = icon,
                            fill = icon == selectedNavigation
                        )
                    },
                    text = {
                        Text(text)
                    }
                )
            }
        }

        Snackbar(
            visible = isSnackbarOpened,
            onDismissRequest = {
                isSnackbarOpened = false
            },
            displayCloseButton = true,
            action = {
                TextButton(
                    onClick = {
                        isSnackbarOpened = false
                    }
                ) {
                    Text("Dismiss")
                }
            },
            message = {
                Text("Hello!")
            }
        )
    }
}

