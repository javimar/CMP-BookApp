package eu.javimar.bookpedia.book.data.network

import eu.javimar.bookpedia.book.data.dto.BookWorkDto
import eu.javimar.bookpedia.book.data.dto.SearchResponseDto
import eu.javimar.bookpedia.core.domain.DataError
import eu.javimar.bookpedia.core.domain.Result

interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>

    suspend fun getBookDetails(bookWorkId: String): Result<BookWorkDto, DataError.Remote>
}