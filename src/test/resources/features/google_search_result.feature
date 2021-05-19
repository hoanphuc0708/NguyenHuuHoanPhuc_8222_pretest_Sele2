Feature: Validate Google search result

  Scenario Outline: Verify Google search result when searching for “the Beatles”
    Given I navigate to the Google page
    When I search for "<query>"
    Then The main result should contains "<query>" text
    And The special sections "Videos" should contains "<query>" text
    And The "<query>" remained on the search box
    Examples:
      | query       |
      | The Beatles |