package com.domain.context

import com.mybookstack.domain.book.Author
import com.mybookstack.domain.book.Book

class TestContext {
    var author: Author? = null
    var matchingInTitle: String? = null
    lateinit var books: List<Book>
}
