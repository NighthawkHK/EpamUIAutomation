Feature: As a user I want to get ability to read a headline article

  @Smoke
  Scenario: Headline article should be equal to expected value
    Given the user opens BBC website
    When the user goes to the "News" page
    Then the headline article corresponds to expected text