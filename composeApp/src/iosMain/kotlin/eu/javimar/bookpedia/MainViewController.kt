package eu.javimar.bookpedia

import androidx.compose.ui.window.ComposeUIViewController
import eu.javimar.bookpedia.app.App
import eu.javimar.bookpedia.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }