package com.mybookstack.domain.book

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class AuthorTest {
    @Test
    fun `should reject creation of author with empty string`() {
        assertThatThrownBy { Author("") }
            .isInstanceOf(InvalidAuthorException::class.java)
            .hasMessage("An author cannot be empty")
    }

    @Test
    fun `should reject creation of author with blank string`() {
        assertThatThrownBy { Author("     ") }
            .isInstanceOf(InvalidAuthorException::class.java)
            .hasMessage("An author cannot be empty")
    }
}
