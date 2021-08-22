package com.mybookstack.domain.book

import com.mybookstack.annotations.ValueObject

@ValueObject
@JvmInline
value class Author(private val value: String) {
    init {
        if (value.isBlank()) {
            throw InvalidAuthorException("An author cannot be empty")
        }
    }
}

class InvalidAuthorException(message: String) : RuntimeException(message)
