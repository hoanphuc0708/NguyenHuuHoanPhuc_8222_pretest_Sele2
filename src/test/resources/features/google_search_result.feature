Feature: Validate Google search result

  Scenario: Verify Google search result when searching for “the Beatles”
    Given I navigate to the Google page
    When I search for the Beatles
    Then The main result should contains the Beatles text
  And



# Open Google, search for “the Beatles”
#  verify the search page: All of the results
#  (main result and results on special sections i.e. “People also ask”, “Top stories”, “Videos”) contains the query,
#  the inputted string remained on the search box