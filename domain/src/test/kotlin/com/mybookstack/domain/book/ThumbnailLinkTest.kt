package com.mybookstack.domain.book

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class ThumbnailLinkTest {
    @Test
    fun `should reject creation of thumbnail link with empty string`() {
        assertThatThrownBy { ThumbnailLink("") }
            .isInstanceOf(InvalidThumbnailException::class.java)
            .hasMessage("A thumbnail link cannot be empty")
    }

    @Test
    fun `should reject creation of thumbnail link with blank string`() {
        assertThatThrownBy { ThumbnailLink("     ") }
            .isInstanceOf(InvalidThumbnailException::class.java)
            .hasMessage("A thumbnail link cannot be empty")
    }

    @Test
    fun `should reject creation of thumbnail link with incorrect value`() {
        assertThatThrownBy { ThumbnailLink("not_http_nor_https://") }
            .isInstanceOf(InvalidThumbnailException::class.java)
            .hasMessage("A thumbnail link must be a HTTP link")
    }
}
