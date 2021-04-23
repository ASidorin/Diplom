# Приложение по автоматезированному тестированию PaymentService
[![Build status](https://ci.appveyor.com/api/projects/status/51hijlbevfwq0457/branch/master?svg=true)](https://ci.appveyor.com/project/AlexeiSidorin/diplom/branch/master)

## Документы о проведенном тестировании

1. [Tест план](https://github.com/AlexeiSidorin/Diplom/blob/master/documents/Plan.md)
2. [Отчет по итогу тестирования](https://github.com/AlexeiSidorin/Diplom/blob/master/documents/Report.md)
3. [Общий отчет](https://github.com/AlexeiSidorin/Diplom/blob/master/documents/Summary.md)

## Описание тестируемого приложения


Проект представляет собой автоматизацию тестирования комплексного сервиса, 
взаимодействующего с СУБД и API Банка. 

Приложение предлагает купить тур по определённой цене с помощью двух способов:
  1) Обычная оплата по дебетовой карте
  2) Выдача кредита по данным банковской карты

Само приложение не обрабатывает данные по картам, а пересылает их банковским сервисам:
  1) Сервису платежей (далее - Payment Gate)
  2) Кредитному сервису (далее - Credit Gate)

Приложение расположено в файле aqa-shop.jar хранимом в папке artifacts.

Заявлена поддержка двух СУБД:
  1) MySQL
  2) PostgreSQL

Учётные данные и url для подключения задаются в файле application.properties.


Приложение должно в собственной СУБД сохранять информацию о том, 
каким способом был совершён платёж и успешно ли он был совершён.
Доступа к живым банковским сервисам не предполагается, поэтому был добавлен симулятор банковских сервисов, 
который может принимать запросы в нужном формате и генерировать ответы.
Симулятор написан на Node.js, для его запуска необходим Docker, либо установленный Node.js. 
Симулятор расположен в каталоге gate-simulator.



## Запуск проекта

### Данная базовая версия проекта подключена для Базы данных MySQL:
  1. В командной строке введите: docker-compose up -d
  2. Затем введите: java -jar ./artifacts/aqa-shop.jar на порту 8080.
  3. Запускаем Allure (2xCtrl) и ввести: 
       1) gradlew clean test allureReport
       2) gradlew allureServe

### Для подключения PostgreSQL необходимо:
 1. Прервать сессию. 
 2. Ввести docker-compose down
 3. Поменять настройки в файле application.properties. 
 Для этого введите: 
 
  ```
  spring.datasource.url=jdbc:postgresql://localhost:5432/testDB
  spring.datasource.username=postgres
  spring.datasource.password=postgres
  ```
 4. Поменять настройки в классе DataSQl в методах вызова "connection": 
 ```
 urlForPostgres 
 userForPostgres 
 passwordForPostgres
 ```
 7. Запустить docker-compose up -d
 8. Затем введите: java -jar ./artifacts/aqa-shop.jar на порту 8080.
 9. Запускаем Allure (2xCtrl) и ввести: 
       1) gradlew clean test allureReport
       2) gradlew allureServe
 
