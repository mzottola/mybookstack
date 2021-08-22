package com.mybookstack.domain.book

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class TitleTest {
    @Test
    fun `should reject creation of title with empty string`() {
        assertThatThrownBy { Title("") }
            .isInstanceOf(InvalidTitleException::class.java)
            .hasMessage("A title cannot be empty")
    }

    @Test
    fun `should reject creation of title with blank string`() {
        assertThatThrownBy { Title("     ") }
            .isInstanceOf(InvalidTitleException::class.java)
            .hasMessage("A title cannot be empty")
    }

}
