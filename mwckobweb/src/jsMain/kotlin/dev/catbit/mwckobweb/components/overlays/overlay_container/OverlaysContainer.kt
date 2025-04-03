package dev.catbit.mwckobweb.components.overlays.overlay_container

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import dev.catbit.mwckobweb.components.overlays.dialog.Dialog
import dev.catbit.mwckobweb.components.overlays.dialog.DialogState
import dev.catbit.mwckobweb.components.overlays.dialog.rememberDialogState
import dev.catbit.mwckobweb.components.overlays.modal_sheet.ModalSheet
import dev.catbit.mwckobweb.components.overlays.modal_sheet.ModalSheetState
import dev.catbit.mwckobweb.components.overlays.modal_sheet.rememberModalSheetState
import dev.catbit.mwckobweb.components.overlays.navigation_drawer.NavigationDrawer
import dev.catbit.mwckobweb.components.overlays.navigation_drawer.NavigationDrawerState
import dev.catbit.mwckobweb.components.overlays.navigation_drawer.rememberNavigationDrawerState
import dev.catbit.mwckobweb.components.overlays.snackbar.Snackbar
import dev.catbit.mwckobweb.components.overlays.snackbar.SnackbarState
import dev.catbit.mwckobweb.components.overlays.snackbar.rememberSnackbarState

@Composable
fun OverlaysContainer(
    modifier: Modifier = Modifier,
    dialogState: DialogState = rememberDialogState(),
    modalSheetState: ModalSheetState = rememberModalSheetState(),
    navigationDrawerState: NavigationDrawerState = rememberNavigationDrawerState(),
    snackbarState: SnackbarState = rememberSnackbarState(),
    content: @Composable OverlaysContainerScope.() -> Unit
) {
    with(
        OverlaysContainerScope(
            dialogState = dialogState,
            modalSheetState = modalSheetState,
            navigationDrawerState = navigationDrawerState,
            snackbarState = snackbarState
        )
    ) {
        Box(
            modifier = modifier
        ) {
            content()

            with(dialogState) {
                Dialog(
                    visible = isVisible,
                    onDismissRequest = onDismissRequest,
                    shape = shape,
                    containerColor = containerColor,
                    isCancellable = isCancellable,
                    icon = icon,
                    headline = headline,
                    supportingText = supportingText,
                    buttons = buttons,
                    content = this.content
                )
            }

            with(modalSheetState) {
                ModalSheet(
                    visible = isVisible,
                    onDismissRequest = onDismissRequest,
                    shape = shape,
                    containerColor = containerColor,
                    showHandler = showHandler,
                    isCancellable = isCancellable,
                    content = this.content,
                )
            }

            with(navigationDrawerState) {
                NavigationDrawer(
                    visible = isVisible,
                    onDismissRequest = onDismissRequest,
                    containerColor = containerColor,
                    isCancellable = isCancellable,
                    content = this.content,
                )
            }

            with(snackbarState) {
                Snackbar(
                    visible = isVisible,
                    onDismissRequest = onDismissRequest,
                    duration = duration,
                    shape = shape,
                    containerColor = containerColor,
                    contentColor = contentColor,
                    actionColor = actionColor,
                    displayCloseButton = displayCloseButton,
                    action = action,
                    message = message
                )
            }
        }
    }
}

data class OverlaysContainerScope(
    val dialogState: DialogState,
    val modalSheetState: ModalSheetState,
    val navigationDrawerState: NavigationDrawerState,
    val snackbarState: SnackbarState
)