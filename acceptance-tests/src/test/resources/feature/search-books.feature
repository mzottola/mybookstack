Feature: As a reader
  I want to select books I love
  So I can know exactly which book to read

  Scenario: A reader wants to search books

    Given a reader
    And he wants to search a book written by "robert" matching "clean code" in its title
    When he asks for a book according to his choice
    Then all the books he receives are written by "Robert C. Martin" and title relates to "clean code"
