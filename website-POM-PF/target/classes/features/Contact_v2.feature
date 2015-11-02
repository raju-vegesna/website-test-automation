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

  Scenario Outline: TC002 Invalid Submission
    Given I am on the QAWorks Staging Site
    And I am on contact page
    When I miss some input data "<name>" or "<email>" or "<message>" in the form
    Then I should be able to see <error> msg
    And the form will not be submitted

    Examples: 
      | name | email         | message        | error                        |
      | John | john@mail.com |                | Please type your message     |
      | Bob  |               | Please contact | An Email address is required |
      |      | tom@mail.com  | Please contact | Your name is required        |
      | Alex | alex.com      | Please contact | Invalid Email Address        |
