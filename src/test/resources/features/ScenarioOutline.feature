Feature: Testing scenario outline
  # " around <> " is reuired , else it will genrrate step def like sumit raut

  Scenario Outline: This is for multiple data
    Given User on Particular page
    When he enter "<username>" and "<password>"
    Then he is logged in

    Examples:
      | username | password |
      | sumit    | raut     |
      | Neha     | raut     |
