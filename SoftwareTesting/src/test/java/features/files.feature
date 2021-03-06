Feature: Работа с файлами
  Scenario: Удаление и добавление картинки
    Given Открыть kpfu.ru
    When Нажать на кнопку "Личный кабинет"
    And Ввести в поле "Введите логин" текст: "login"
    And Ввести в поле "Введите пароль" текст: "password"
    And Нажать на кнопку "Отправить"
    And Нажать на кнопку "Обо мне"
    And Удалить старую фотографию
    And Установить новую фотографию
    Then Фото установлено

  Scenario: Скачивание и проверка файла
    Given Открыть kpfu.ru
    When Нажать на кнопку "Личный кабинет"
    And Ввести в поле "Введите логин" текст: "login"
    And Ввести в поле "Введите пароль" текст: "password"
    And Нажать на кнопку "Отправить"
    And Нажать на кнопку "Успеваемость"
    And Нажать на кнопку "Единый центр обслуживания"
    And Нажать на кнопку "Документы"
    And Нажать на кнопку "Шаблоны документов"
    Then Скачать и проверить файл