package com.catbit.sample.pages.index

import androidx.compose.runtime.*
import com.catbit.mwckobweb.components.buttons.common_buttons.FilledButton
import com.catbit.mwckobweb.components.buttons.common_buttons.TextButton
import com.catbit.mwckobweb.components.buttons.icon_button.IconButton
import com.catbit.mwckobweb.components.icons.Icon
import com.catbit.mwckobweb.components.navigation.NavigationRail
import com.catbit.mwckobweb.components.navigation.NavigationRailItem
import com.catbit.mwckobweb.components.overlays.dialog.Dialog
import com.catbit.mwckobweb.components.overlays.modal_sheet.ModalSheet
import com.catbit.mwckobweb.components.overlays.navigation_drawer.NavigationDrawer
import com.catbit.mwckobweb.components.overlays.navigation_drawer.NavigationDrawerItem
import com.catbit.mwckobweb.components.overlays.snackbar.Snackbar
import com.catbit.mwckobweb.components.overlays.snackbar.SnackbarDuration
import com.catbit.mwckobweb.components.text.Text
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.theme.colors.ColorMode
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
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(8.px)
            ) {
                FilledButton(
                    onClick = {
                        isModalSheetOpened = true
                    }
                ) {
                    Text("Open ModalSheet")
                }

                FilledButton(
                    onClick = {
                        isDialogOpened = true
                    }
                ) {
                    Text("Open Dialog")
                }

                FilledButton(
                    onClick = {
                        isSnackbarOpened = true
                    }
                ) {
                    Text("Show Snackbar")
                }
            }
        }


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
            duration = SnackbarDuration.Indefinite,
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

