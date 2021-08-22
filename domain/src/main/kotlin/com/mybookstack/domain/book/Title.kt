package com.mybookstack.domain.book

import com.mybookstack.annotations.ValueObject

@ValueObject
@JvmInline
value class Title(private val value: String) {
    init {
        if (value.isBlank()) {
            throw InvalidTitleException("A title cannot be empty")
        }
    }
}
class InvalidTitleException(message: String) : RuntimeException(message)
