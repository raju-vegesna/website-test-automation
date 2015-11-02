Feature: Contact Us Page
  As an end user
  I want a contact us page
  So that I can find out more about QAWorks exciting services

  Scenario: TC001 Valid Submission
    Given I am on the QAWorks Staging Site
    Then I should be able to contact QAWorks with the following information
      | name    | j.Bloggs         6                        |
      | email   | j.Bloggs@qaworks.com                      |
      | message | please contact me I want to find out more |
