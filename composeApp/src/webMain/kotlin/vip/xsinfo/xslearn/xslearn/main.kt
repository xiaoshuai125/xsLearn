package vip.xsinfo.xslearn.xslearn

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import vip.xsinfo.xslearn.xslearn.theme.AppTheme

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport {
        AppTheme {
            App()
        }
    }
}