# Project_template

Это шаблон для решения проектной работы. Структура этого файла повторяет структуру заданий. Заполняйте его по мере работы над решением.

# Задание 1. Анализ и планирование

<aside>

Чтобы составить документ с описанием текущей архитектуры приложения, можно часть информации взять из описания компании и условия задания. Это нормально.

</aside>

### 1. Описание функциональности монолитного приложения

**Управление отоплением:**

- Пользователи могут удалённо включать/выключать отопление в своих домах.
- Система поддерживает изменение температуры и включение/выключение отопления с помощью обновления температуры и статуса на датчике

**Мониторинг температуры:**

- Пользователи могут узнавать текущую температуру через интерфейс
- Система поддерживает запрос температуры с датчиков в домах

### 2. Анализ архитектуры монолитного приложения

Язык программирования: Go
База данных: PostgreSQL
Архитектура: Монолитная, все компоненты системы (обработка запросов, бизнес-логика, работа с данными) находятся в рамках одного приложения.
Взаимодействие: Синхронное, запросы обрабатываются последовательно.
Масштабируемость: Ограничена, так как монолит сложно масштабировать по частям.
Развертывание: Требует остановки всего приложения.

### 3. Определение доменов и границы контекстов

- Домен управление устройствами
    - поддомен добавление устройства
        - контекст: добавление умного датчика отопления
        - контекст: добавление умного замка на воротах
        - контекст: добавление умной камеры
    - поддомен управление поведением и мониторинг устройств
        
- Домен управления пользователем
  - поддомен регистрация пользователя
  - поддомен оформление подписки на сервис

### **4. Проблемы монолитного решения**

- Сложность развертывания из-за необходимости перезапуска и тестирования всего приложения
- Невозможность масштабировать отдельный компонент 
- Сложно добавлять, т.к. большой риск ошибок

Если вы считаете, что текущее решение не вызывает проблем, аргументируйте свою позицию.

### 5. Визуализация контекста системы — диаграмма С4

Добавьте сюда диаграмму контекста в модели C4.

Чтобы добавить ссылку в файл Readme.md, нужно использовать синтаксис Markdown. Это делают так:

```markdown```

Замените `Текст ссылки` текстом, который хотите использовать для ссылки. Вместо `URL` вставьте адрес, на который должна вести ссылка. Например:


![Диаграмма контекста](https://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/notherland/architecture-warmhouse/refs/heads/warmhouse/diagrams/uml/Context.puml)

# Задание 2. Проектирование микросервисной архитектуры

В этом задании вам нужно предоставить только диаграммы в модели C4. Мы не просим вас отдельно описывать получившиеся микросервисы и то, как вы определили взаимодействия между компонентами To-Be системы. Если вы правильно подготовите диаграммы C4, они и так это покажут.

**Диаграмма контейнеров (Containers)**

![Диаграмма контейнеров](https://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/notherland/architecture-warmhouse/refs/heads/warmhouse/diagrams/uml/Container.puml)


**Диаграмма компонентов (Components)**

![Диаграмма компонентов](https://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/notherland/architecture-warmhouse/refs/heads/warmhouse/diagrams/uml/Component.puml)


Добавьте диаграмму для каждого из выделенных микросервисов.

**Диаграмма кода (Code)**

![Диаграмма пользователя](https://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/notherland/architecture-warmhouse/refs/heads/warmhouse/diagrams/uml/User_code.puml)

![Диаграмма сенсора](https://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/notherland/architecture-warmhouse/refs/heads/warmhouse/diagrams/uml/Sensor_code.puml)

![Диаграмма подписки](https://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/notherland/architecture-warmhouse/refs/heads/warmhouse/diagrams/uml/Subscriprion_code.puml)
Добавьте одну диаграмму или несколько.

# Задание 3. Разработка ER-диаграммы

Добавьте сюда ER-диаграмму. Она должна отражать ключевые сущности системы, их атрибуты и тип связей между ними.
![Диаграмма сущностей](https://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/notherland/architecture-warmhouse/refs/heads/warmhouse/diagrams/uml/ER_diagram.puml)


# Задание 4. Создание и документирование API

### 1. Тип API

RESTApi, т.к. учитывая что в старой реализации он был использован можно предположить что команда умеет с ним работать. Также нет необходимости хранить состояние датчиков, достаточно опрашивать их при запросе пользователя

### 2. Документация API

Здесь приложите ссылки на документацию API для микросервисов, которые вы спроектировали в первой части проектной работы. Для документирования используйте Swagger/OpenAPI или AsyncAPI.

[Документация сервиса управления устройствами](https://github.com/notherland/architecture-warmhouse/blob/warmhouse/apps/smart_home/device.yaml)
[Документация сервиса управления пользователями](https://github.com/notherland/architecture-warmhouse/blob/warmhouse/apps/smart_home/subscription.yaml)
[Документация сервиса управления подписками](https://github.com/notherland/architecture-warmhouse/blob/warmhouse/apps/smart_home/user.yaml)


# Задание 5. Работа с docker и docker-compose

Перейдите в apps.

Там находится приложение-монолит для работы с датчиками температуры. В README.md описано как запустить решение.

Вам нужно:

1) сделать простое приложение temperature-api на любом удобном для вас языке программирования, которое при запросе /temperature?location= будет отдавать рандомное значение температуры.

Locations - название комнаты, sensorId - идентификатор названия комнаты

```
	// If no location is provided, use a default based on sensor ID
	if location == "" {
		switch sensorID {
		case "1":
			location = "Living Room"
		case "2":
			location = "Bedroom"
		case "3":
			location = "Kitchen"
		default:
			location = "Unknown"
		}
	}

	// If no sensor ID is provided, generate one based on location
	if sensorID == "" {
		switch location {
		case "Living Room":
			sensorID = "1"
		case "Bedroom":
			sensorID = "2"
		case "Kitchen":
			sensorID = "3"
		default:
			sensorID = "0"
		}
	}
```

2) Приложение следует упаковать в Docker и добавить в docker-compose. Порт по умолчанию должен быть 8081

3) Кроме того для smart_home приложения требуется база данных - добавьте в docker-compose файл настройки для запуска postgres с указанием скрипта инициализации ./smart_home/init.sql

Для проверки можно использовать Postman коллекцию smarthome-api.postman_collection.json и вызвать:

- Create Sensor
- Get All Sensors

Должно при каждом вызове отображаться разное значение температуры

Ревьюер будет проверять точно так же.


