package eu.javimar.bookpedia

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import eu.javimar.bookpedia.app.App
import eu.javimar.bookpedia.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "CMP-Bookpedia",
        ) {
            App()
        }
    }
}