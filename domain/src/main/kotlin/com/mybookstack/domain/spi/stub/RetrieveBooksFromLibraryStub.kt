package com.mybookstack.domain.spi.stub

import com.mybookstack.annotations.Stub
import com.mybookstack.domain.book.Author
import com.mybookstack.domain.book.Book
import com.mybookstack.domain.book.ISBN13
import com.mybookstack.domain.book.ThumbnailLink
import com.mybookstack.domain.book.Title
import com.mybookstack.domain.spi.RetrieveBooksFromLibrary
import com.mybookstack.domain.spi.RetrieveBooksPreference
import java.time.LocalDate

@Stub
class RetrieveBooksFromLibraryStub : RetrieveBooksFromLibrary {
    override fun forPreferences(retrieveBooksPreference: RetrieveBooksPreference): List<Book> =
        listOf(
            Book(
                ISBN13("9780136083252"),
                Title("Clean Code"),
                Author("Robert C. Martin"),
                publishedDate = LocalDate.parse("2008-08-01"),
                ThumbnailLink("http://books.google.com/books/content?id=_i6bDeoCQzsC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api")
            ),
            Book(
                ISBN13("9780137081073"),
                Title("The Clean Coder"),
                Author("Robert C. Martin"),
                publishedDate = LocalDate.parse("2008-08-01"),
                ThumbnailLink("http://books.google.com/books/content?id=_i6bDeoCQzsC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api")
            ),
            Book(
                ISBN13("9781638353287"),
                Title("Spring in Action"),
                Author("Craig Walls"),
                publishedDate = LocalDate.parse("2018-10-05"),
                ThumbnailLink("http://books.google.com/books/content?id=NzkzEAAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api")
            ),
        ).filter { it.satisfies(retrieveBooksPreference) }
}
