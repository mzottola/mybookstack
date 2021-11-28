package com.mybookstack.domain.spi

import com.mybookstack.annotations.ValueObject
import com.mybookstack.domain.book.Author

@ValueObject
data class SearchPreferences(val inAuthor: String, val inTitle: String)
