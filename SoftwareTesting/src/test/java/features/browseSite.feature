Feature: Открытие разных страниц на "kpfu.ru"
  Scenario: Открыть "Успеваемость"
    Given Открыть kpfu.ru
    When Нажать на кнопку "Личный кабинет"
    And Ввести в поле "Введите логин" текст: "login"
    And Ввести в поле "Введите пароль" текст: "password"
    And Нажать на кнопку "Отправить"
    And Нажать на кнопку "Успеваемость"
    Then На странице "Успеваемость"

  Scenario: Открыть "Обо мне"
    Given Открыть kpfu.ru
    When Нажать на кнопку "Личный кабинет"
    And Ввести в поле "Введите логин" текст: "login"
    And Ввести в поле "Введите пароль" текст: "password"
    And Нажать на кнопку "Отправить"
    And Нажать на кнопку "Обо мне"
    Then На странице "Обо мне"

  Scenario: Открыть профиль
    Given Открыть kpfu.ru
    When Нажать на кнопку "Личный кабинет"
    And Ввести в поле "Введите логин" текст: "login"
    And Ввести в поле "Введите пароль" текст: "password"
    And Нажать на кнопку "Отправить"
    And Нажать на кнопку "Сообщения"
    Then На странице "Сообщения"


