package com.mybookstack.domain.book

import com.mybookstack.annotations.Entity
import com.mybookstack.domain.spi.RetrieveBooksPreference
import java.time.LocalDate

@Entity
class Book(
    val isbn: ISBN13,
    val title: Title,
    val author: Author,
    val publishedDate: LocalDate,
    val thumbnailLink: ThumbnailLink
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

    fun satisfies(preferences: RetrieveBooksPreference) =
        matchAuthor(preferences.inAuthor) && matchTitle(preferences.inTitle)

    private fun matchAuthor(inAuthor: String) = this.author.value.contains(inAuthor, ignoreCase = true)
    private fun matchTitle(inTitle: String) = this.title.value.contains(inTitle, ignoreCase = true)

}
