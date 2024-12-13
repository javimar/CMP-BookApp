package eu.javimar.bookpedia.book.presentation.book_detail

import eu.javimar.bookpedia.book.domain.Book

data class BookDetailState(
    val isLoading: Boolean = true,
    val isFavorite: Boolean = false,
    val book: Book? = null
)
