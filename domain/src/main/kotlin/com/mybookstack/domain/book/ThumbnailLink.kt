package com.mybookstack.domain.book

import com.mybookstack.annotations.ValueObject

@ValueObject
@JvmInline
value class ThumbnailLink(private val value: String) {
    init {
        if (value.isBlank()) {
            throw InvalidThumbnailException("A thumbnail link cannot be empty")
        }
        // TODO (mzo) write better validation
        if (listOf("http://", "https://").none { value.startsWith(it) }) {
            throw InvalidThumbnailException("A thumbnail link must be a HTTP link")
        }
    }
}
class InvalidThumbnailException(message: String) : RuntimeException(message)