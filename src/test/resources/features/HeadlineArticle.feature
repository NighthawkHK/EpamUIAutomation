Feature: As a user I want to get ability to read a headline article

  Scenario Outline: Headline article should be equal to expected value
    Given the user opens BBC website
    When the user goes to the News page
    Then the headline article corresponds to expected "<title>"
    Examples:
    | title                                            |
    | Donald Trump 'paid $750 in federal income taxes' |