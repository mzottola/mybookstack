package com.mybookstack.domain.book

import com.mybookstack.annotations.Entity
import java.time.LocalDate

@Entity
class Book private constructor(
    private val isbn: ISBN13,
    private val title: Title,
    private val author: Author,
    private val publishedDate: LocalDate,
    private val thumbnailLink: ThumbnailLink
) {
    companion object {
        fun createBook(isbn: String, title: String, author: String, publishedDate: LocalDate, thumbnailLink: String) =
            Book(ISBN13(isbn), Title(title), Author(author), publishedDate, ThumbnailLink(thumbnailLink))
    }

    override fun equals(other: Any?): Boolean {
        if (other == null)
            return false
        if (other !is Book) {
            return false
        }
        return other.isbn == this.isbn
    }

    override fun hashCode(): Int {
        return isbn.toUniqueNumber()
    }
}
