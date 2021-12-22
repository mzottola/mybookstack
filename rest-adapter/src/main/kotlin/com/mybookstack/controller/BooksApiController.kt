package com.mybookstack.controller

import com.mybookstack.api.BooksApi
import com.mybookstack.domain.api.SearchBooks
import com.mybookstack.domain.spi.RetrieveBooksPreference
import com.mybookstack.model.BookDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
open class BooksApiController(private val searchBooks: SearchBooks) : BooksApi {

    override fun findBooks(author: String, title: String): ResponseEntity<List<BookDto>> {
        return ResponseEntity.ok(searchBooks.search(RetrieveBooksPreference(author, title))
            .map {
                BookDto(
                    it.isbn.value,
                    it.title.value,
                    it.author.value,
                    it.publishedDate,
                    it.thumbnailLink.value
                )
            }
            .toList())
    }
}
