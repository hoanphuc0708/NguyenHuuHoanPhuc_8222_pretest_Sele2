Feature: Validate Google search result

  Background:
    Given I navigate to the Google page

  Scenario Outline: Verify Google search result when searching for “the Beatles”
    When I search for "<query>"
    Then The main result should contains "<query>" text
    And The special sections "Videos" should contains "<query>" text
    And The "<query>" remained on the search box

    Examples:
      | query       |
      | The Beatles |


  Scenario Outline: Verify YouTube result from Google search when searching for “the Beatles”
    When I search for "<query>"
    And I open the first YouTube video result on Google search for "<query>"
    And I play the video
    And I pause the video after 10 seconds
    Then The video title is same to Google result
    And The video is played or paused accordingly

    Examples:
      | query       |
      | The Beatles |