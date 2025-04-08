Feature: To test that search results are returned for the specified search term

  @Test
  Scenario: Verify that the specified search term has at least one search result
    Given I go to the website "https://risk.lexisnexis.co.uk/"
    And click on the menu "About Us" on that page    
    When I click on the option "Careers"    
    And I click on "Search jobs"
    And enter "automation tester" in the search box
    Then I should get at least one search result