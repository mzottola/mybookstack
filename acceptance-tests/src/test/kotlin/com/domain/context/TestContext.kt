package com.domain.context

import com.mybookstack.domain.book.Book
import com.mybookstack.domain.spi.RetrieveBooksPreference

class TestContext {
    lateinit var retrieveBooksPreference: RetrieveBooksPreference
    lateinit var books: List<Book>
}
