# Приложение по автоматезированному тестированию PaymentService

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
  1. В командной строке введите: docker-compose up -d
  2. Затем введите: java -jar ./artifacts/aqa-shop.jar на порту 8080.
  3. Запускаем Allure (2xCtrl) и ввести: 
       1) gradlew clean test allureReport
       2) gradlew allureServe
 
