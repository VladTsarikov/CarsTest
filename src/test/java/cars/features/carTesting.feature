Feature: Testing website cars
  Scenario: Find Random Car
    Given open website cars
    When we click tab Research
    Then we get ResearchPage
    When we choose random car
    Then we get RandomCarPage
    When we click compare trims button
    Then we go to CompareTrimsPage
    When we initialize car
    Then return to main page
    When we click tab Research
    Then we get ResearchPage
    When we choose random car
    Then we get RandomCarPage
    When we click compare trims button
    Then we go to CompareTrimsPage
    When we initialize car
    Then back to research page
    When click side by side comparisons
    Then we go to ComparePage
    When we choose first car
    Then we go to StartComparePage
    When we click add second car
    And choose second car
    Then we get result of comparing