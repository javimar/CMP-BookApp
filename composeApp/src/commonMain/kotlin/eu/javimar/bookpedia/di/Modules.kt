package eu.javimar.bookpedia.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import eu.javimar.bookpedia.book.data.database.DatabaseFactory
import eu.javimar.bookpedia.book.data.database.FavoriteBookDatabase
import eu.javimar.bookpedia.book.data.network.KtorRemoteBookDataSource
import eu.javimar.bookpedia.book.data.network.RemoteBookDataSource
import eu.javimar.bookpedia.book.data.repository.DefaultBookRepository
import eu.javimar.bookpedia.book.domain.BookRepository
import eu.javimar.bookpedia.book.presentation.SelectedBookViewModel
import eu.javimar.bookpedia.book.presentation.book_detail.BookDetailViewModel
import eu.javimar.bookpedia.book.presentation.book_list.BookListViewModel
import eu.javimar.bookpedia.core.data.HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<FavoriteBookDatabase>().favoriteBookDao }

    viewModelOf(::BookListViewModel)
    viewModelOf(::BookDetailViewModel)
    viewModelOf(::SelectedBookViewModel)
}