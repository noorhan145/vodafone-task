@smoke
Feature: F01_makeOrder | users could make order

  Scenario: guest user could select random product and make an order
    When user select language as “English”
    And user go to “Shop By Brand” section and select “Iphone”
    And user select any of returned iphone mobiles
    And user press add to cart
    And user press at cart icon
    And user press Proceed to Checkout
    And user select “Delivery Options” as “Cairo” “Ain Shams”
    And user select “Deliver to My Address”
    And user add address details
    And user press continue after fill address
    And user Leave Personal info. Tab empty and press continue
    Then error message returned from “Full Name” field


