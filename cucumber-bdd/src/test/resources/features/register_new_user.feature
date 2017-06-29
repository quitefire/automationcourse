@registration
Feature: registration of new user

  Background: Open registration page
    Given a user is on the main hotline page
    When user open registration form

  @negative
  Scenario Outline: register a new user with invalid data
    And fill registration form with with:
      | email   | nick   | password   |
      | <email> | <nick> | <password> |
    Then following messages should be displayed:
      | <message1> | <message2> | <message3> |
    Examples:
      | email                  | nick      | password  | message1 | message2                      | message3                                               |
      | negavite_data1@ukr.net | mike13new | 1234      |          |                               | Длина поля не может быть меньше 4 и больше 16 символов |
      | negavite_data2@ukr.net | $$$$      | password1 |          | Поле не соответствует формату |                                                        |


  @positive
  Scenario Outline: register a new user with valid data
    And fill registration form with with:
      | email   | nick   | password   |
      | <email> | <nick> | <password> |
    Then user should see message:Поздравляем! Вы успешно зарегистрировались на Hotline
    Examples:
      | email            | nick        | password   |
      | newEmail@ukr.net | untakenNick | 1234345345 |
