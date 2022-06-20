@C12 @Algorithms
Feature: C12

  Scenario:  Algorithm1b - Add order for flagging

    When Open NavigateSOM Demo
    Then Enter login "nikitadanilevskiy@pharma.solutions" on Demo login page
    Then Enter password "nikita9899tenant" on Demo login page
    When Open the [Uploads] tab on Demo env
    Then Upload the file "src/main/resources/algorithm1b4b5b6b.csv" on Demo env
    When Open the [Orders] tab on Demo env
    When Find the "1111120" order on Demo env
    Then Open the first order on Demo env
    Then Check the order for "Algorithm 1b: NDC over quantity average" flag reason on Demo env
    Then Close the order window on Demo env
