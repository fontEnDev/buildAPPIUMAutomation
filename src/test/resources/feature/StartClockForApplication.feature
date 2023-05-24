Feature: this is testing for Mobile


  @APPIUM
  Scenario: Add new Timer on clock application
    Given Load App by Appium
    When Find and start "Clock" app
    When Add new timer and click Start

      @TestAppVelocity1
      Scenario: Add new chrome for server
        Given Load App of SamSung real device
        And Go to "Velocity" app
        When Add new profile web name "google" and URL "https://youtube.com"
        Then Click profile name "google" and URL "https://youtube.com"