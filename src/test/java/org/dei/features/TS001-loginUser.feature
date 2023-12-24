@login
Feature: Login

  @login
  Scenario: As a user, I should be able to log in using correct registered data on secondhand-binaracademy
    Given user open SwagLabs app
    When user login using "standard_user"
    Then user direct to dashboard screen
    * user take screenshot "user-login-successfully"

  @login
  Scenario Outline: As a user, I can't log in using wrong password to secondhand-binaracademy
    Given user open SwagLabs app
    When user login using "locked_out_user"
    Then user verify snackbar error with value "<snackbar_error>" exists
    * user take screenshot "user-failed-login"

    Examples:
      | snackbar_error                        |
      | Sorry, this user has been locked out. |
