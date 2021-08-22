package com.mybookstack.domain.book

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import kotlin.random.Random

internal class ISBN13Test {
    @Test
    fun `should reject creation of ISBN with empty string`() {
        assertThatThrownBy { ISBN13("") }
            .isInstanceOf(InvalidISBN13Exception::class.java)
            .hasMessage("An ISBN-13 cannot be empty")
    }

    @Test
    fun `should reject creation of ISBN with blank string`() {
        assertThatThrownBy { ISBN13("     ") }
            .isInstanceOf(InvalidISBN13Exception::class.java)
            .hasMessage("An ISBN-13 cannot be empty")
    }

    @Test
    fun `should reject creation of ISBN with more than 13 characters`() {
        val stringHaving14Characters = (1..14).map { Random.nextInt(0, 9) }.joinToString("")
        assertThatThrownBy { ISBN13(stringHaving14Characters) }
            .isInstanceOf(InvalidISBN13Exception::class.java)
            .hasMessage("An ISBN-13 must have exactly 13 characters")
    }


    @Test
    fun `should reject creation of ISBN with more less than 13 characters`() {
        val stringHaving12Characters = (1..12).map { Random.nextInt(0, 9) }.joinToString("")
        assertThatThrownBy { ISBN13(stringHaving12Characters) }
            .isInstanceOf(InvalidISBN13Exception::class.java)
            .hasMessage("An ISBN-13 must have exactly 13 characters")
    }

    @Test
    fun `should rely on value String when generating a unique number`() {
        val value = "1234567891234"
        val isbn13 = ISBN13(value)
        assertThat(value.hashCode()).isEqualTo(isbn13.toUniqueNumber())
    }
}
