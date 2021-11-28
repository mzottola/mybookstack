package com.mybookstack.domain.book

import com.mybookstack.domain.spi.SearchPreferences
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

internal class BookTest {
    @Test
    fun `should be equal when two books have the same ISBN`() {
        // given
        val book1 = Book(
            ISBN13("1234567891234"),
            Title("Effective Java"),
            Author("Joshua Bloch"),
            LocalDate.parse("2008-05-08"),
            ThumbnailLink("https://thumbail.com")
        )
        val book1Bis = Book(
            ISBN13("1234567891234"),
            Title("Effective Java"),
            Author("Joshua Bloch"),
            LocalDate.parse("2008-05-08"),
            ThumbnailLink("https://thumbail.com")
        )
        val fakeBook = Book(
            ISBN13("0000000000000"),
            Title("Fake book"),
            Author("Any"),
            LocalDate.parse("2000-01-01"),
            ThumbnailLink("https://fake.com")
        )

        // then
        assertThat(book1).isEqualTo(book1Bis)
        assertThat(book1Bis).isEqualTo(book1)
        assertThat(fakeBook).isNotEqualTo(book1)
        assertThat(fakeBook).isNotEqualTo(book1Bis)
    }

    @Test
    fun `should get a book that satisfies the search preferences`() {
        // given
        val book = Book(
            ISBN13("1234567891234"),
            Title("Effective Java"),
            Author("Joshua Bloch"),
            LocalDate.parse("2008-05-08"),
            ThumbnailLink("https://thumbail.com")
        )

        // when
        assertThat(book.satisfies(SearchPreferences("bloch", "effective")))
            // then
            .isTrue
    }
}
