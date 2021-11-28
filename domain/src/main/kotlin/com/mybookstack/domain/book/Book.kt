package com.mybookstack.domain.book

import com.mybookstack.annotations.Entity
import com.mybookstack.domain.spi.SearchPreferences
import java.time.LocalDate

@Entity
class Book(
    private val isbn: ISBN13,
    private val title: Title,
    private val author: Author,
    private val publishedDate: LocalDate,
    private val thumbnailLink: ThumbnailLink
) {

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

    fun satisfies(preferences: SearchPreferences) =
        matchAuthor(preferences.inAuthor) && matchTitle(preferences.inTitle)

    private fun matchAuthor(inAuthor: String) = this.author.value.contains(inAuthor, ignoreCase = true)
    private fun matchTitle(inTitle: String) = this.title.value.contains(inTitle, ignoreCase = true)

}
