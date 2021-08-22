package com.domain.stepdefs

import com.domain.context.TestContext
import com.mybookstack.domain.book.Author
import com.mybookstack.domain.book.Book
import com.mybookstack.domain.book.ISBN13
import com.mybookstack.domain.book.ThumbnailLink
import com.mybookstack.domain.book.Title
import com.mybookstack.domain.spi.RetrieveBooksFromLibrary
import com.mybookstack.domain.spi.RetrieveBooksPreference
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.assertj.core.api.Assertions.assertThat
import java.time.LocalDate

class SearchBookStepDefs(
    private val testContext: TestContext,
    private val retrieveBooksFromLibrary: RetrieveBooksFromLibrary
) {

    @Given("he wants to search a book written by {string} matching {string} in its title")
    fun `he wants to search a book written by a specific author matching a specific string in its title`(
        matchingInAuthor: String,
        matchingInTitle: String
    ) {
        testContext.retrieveBooksPreference = RetrieveBooksPreference(matchingInAuthor, matchingInTitle)
    }

    @When("he asks for a book according to his choice")
    fun `he asks for a book according to his choice`() {
        testContext.books = retrieveBooksFromLibrary.forPreferences(testContext.retrieveBooksPreference)
    }

    @Then("all the books he receives are written by {string} and title relates to {string}")
    fun `all the books he receives are written by expected author and title relates to expected content`(
        expectedAuthor: String,
        expectedTitle: String
    ) {
        assertThat(testContext.books)
            .isNotEmpty
            .isEqualTo(
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
                    )
                )
            )
    }
}
