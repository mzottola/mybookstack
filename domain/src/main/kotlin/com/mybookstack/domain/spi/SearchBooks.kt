package com.mybookstack.domain.spi

import com.mybookstack.domain.book.Book

fun interface SearchBooks {
    fun forPreferences(searchPreferences: SearchPreferences): List<Book>
}
