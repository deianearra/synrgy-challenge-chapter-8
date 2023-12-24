@checkout
Feature: Checkout

  @checkout
  Scenario: As a user, I should be able to make product checkout successfully
    Given user is already on home page
    When user tap Add To Cart button on first product
    * user tap Add To Cart button on second product
    * user tap Cart icon
    * user tap Checkout button on Your Cart page
    * user fill in Checkout Information
    * user tap Finish button on Checkout Overview page
    Then user verify success checkout
    * user take screenshot "user-checkout-product-successfully"
