Feature: As a user, I want to be able to send my question to BBC

  @Smoke
  Scenario Outline: Ability to send a question to BBC
    Given data to test: "<question>", "<name>", "<contactNumber>", "<emailAddress>", "<ageConfirmation>", "<termsConfirmation>"
    And the user opens BBC website
    When the user goes to Share news page
    And fills in the form
    Then the user submits the form
    And the form successfully sent on the server
    Examples:
      | question        | name   | contactNumber  | emailAddress        | ageConfirmation | termsConfirmation |
      | Test message #1 | Test01 | 0987654321     | test_m@mail.com     | true            | false              |
      | Test message #2 | Test02 | 1234567890     | test_mail@mail.com  | true            | false              |

