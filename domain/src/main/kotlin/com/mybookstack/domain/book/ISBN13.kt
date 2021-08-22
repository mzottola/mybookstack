package com.mybookstack.domain.book

import com.mybookstack.annotations.ValueObject

@ValueObject
@JvmInline
value class ISBN13(private val value: String) {
    init {
        if (value.isBlank()) {
            throw InvalidISBN13Exception("An ISBN-13 cannot be empty")
        }
        if (value.length != 13) {
            throw InvalidISBN13Exception("An ISBN-13 must have exactly 13 characters")
        }
    }

    fun toUniqueNumber() = value.hashCode()
}

class InvalidISBN13Exception(message: String) : RuntimeException(message)
