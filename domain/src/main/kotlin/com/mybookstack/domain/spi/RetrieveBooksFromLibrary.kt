package com.mybookstack.domain.spi

import com.mybookstack.annotations.ValueObject
import com.mybookstack.domain.book.Book

fun interface RetrieveBooksFromLibrary {
    fun forPreferences(retrieveBooksPreference: RetrieveBooksPreference): List<Book>
}

@ValueObject
data class RetrieveBooksPreference(val inAuthor: String, val inTitle: String)
