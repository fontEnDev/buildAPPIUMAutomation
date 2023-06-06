Feature: Code on Velocity App
  @TestAppVelocity
  Scenario: Add profile and practice URL on Velocity App
    Given Find and start "Velocity" app
    When Add new profile web name "youtube" and URL "https://youtube.com" if it does not exist
    Then Click profile name "youtube" and URL "https://youtube.com"