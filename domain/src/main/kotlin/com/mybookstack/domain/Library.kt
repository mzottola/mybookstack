package com.mybookstack.domain

import com.mybookstack.annotations.Aggregate
import com.mybookstack.domain.book.Book

@Aggregate
class Library(private val books: List<Book>) {

}
