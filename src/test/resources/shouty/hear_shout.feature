Feature: Hear Shout

  Shouts have a range of approximately 1000m

  @new-scenario
  Scenario: Multiple shouters
    Given Lucy is at 0,0
    And Sean is at 0,500
    And Oscar is at 1100,0
    When Sean shouts
    And Oscar shouts
    Then Lucy should hear Sean
    And Lucy should not hear Oscar

  @new-functionality
  Scenario: Shouters should not hear their own shouts
    Given Lucy is at 0,0
    When Lucy shouts
    Then Lucy should not hear her own shout

  @scenario-outline
  Scenario Outline: Only hear in-range shouts
    Given Lucy is at 0,0
    And Sean is at <sean-location>
    When Sean shouts
    Then Lucy should hear <what-lucy-hears>

    Examples: happy path and negative scenario
    | sean-location | what-lucy-hears |
    | 0,900         | Sean            |
    | 800,800       | nothing         |

  @tables
  Scenario: Multiple people multiple shouts
    Given people are located at
      | name   | x    |  y   |
      | Lucy   | 0    | 0    |
      | Sean   | 0    | 500  |
      | Oscar  | 1100 | 0    |
    When they shout
    Then others should hear if they are within range

  @isolation
  Scenario: Multiple shouts from one person
    Given Lucy is at 0,0
    And Sean is at 0,500
    When Sean shouts
    And Sean shouts
    Then Lucy should hear 2 shouts from Sean



