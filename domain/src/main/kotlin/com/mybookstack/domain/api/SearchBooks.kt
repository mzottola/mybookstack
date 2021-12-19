package com.mybookstack.domain.api

import com.mybookstack.annotations.DomainService
import com.mybookstack.domain.book.Book
import com.mybookstack.domain.spi.RetrieveBooksFromLibrary
import com.mybookstack.domain.spi.RetrieveBooksPreference

interface SearchBooks {
    fun search(preferences: RetrieveBooksPreference): List<Book>
}

@DomainService
class SearchBooksDomainService(private val retrieveBooksFromLibrary: RetrieveBooksFromLibrary) : SearchBooks {
    override fun search(preferences: RetrieveBooksPreference) =
        retrieveBooksFromLibrary.forPreferences(preferences)
}

