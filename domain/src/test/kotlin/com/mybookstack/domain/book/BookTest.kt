package com.mybookstack.domain.book

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

internal class BookTest {
    @Test
    fun `should be equal when two books have the same ISBN`() {
        // given
        val book1 = Book.createBook(
            "1234567891234",
            "Effective Java",
            "Joshua Bloch",
            LocalDate.parse("2008-05-08"),
            "https://thumbail.com"
        )
        val book1Bis = Book.createBook(
            "1234567891234",
            "Effective Java",
            "Joshua Bloch",
            LocalDate.parse("2008-05-08"),
            "https://thumbail.com"
        )
        val fakeBook = Book.createBook(
            "0000000000000",
            "Fake book",
            "Any",
            LocalDate.parse("2000-01-01"),
            "https://fake.com"
        )

        // then
        assertThat(book1).isEqualTo(book1Bis)
        assertThat(book1Bis).isEqualTo(book1)
        assertThat(fakeBook).isNotEqualTo(book1)
        assertThat(book1Bis).isNotEqualTo(fakeBook)
    }
}
