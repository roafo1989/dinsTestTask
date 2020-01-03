# Dino System

Тестовое задание для DINO System
<details><summary>ТЗ</summary>
1. Написать программу, удовлетворяющую указанным требованиям.

2. Написать юнит тесты на написанный код.

3. Должны быть использованы следующие технологии: Java (8 версии или выше), Spring Boot, JUnit. Не должны быть использованы базы данных.

4. Должны быть предоставлены: исходный код программы, юнит тесты, инструкция по запуску программы, примеры вызова REST методов программы.

5. Стоит уделить особое внимание REST спецификации и организации REST методов.



Требования к программе.

Нужно написать серверную часть приложения (без UI части) по работе с пользователями и их телефонной книжкой.

Программа должна предоставлять REST API для:

*1 получения списка всех пользователей (владельцев телефонных книжек)

*2 создания, 3 получения (по id), 4 удаления, 5 редактирования пользователя

*6 создания, 7 получения (по id), 8 удаления, 9 редактирования записи в телефонной книжке

*10 получения списка всех записей в телефонной книжке пользователя

*11 поиск пользователей по имени (или его части)

*12 поиск телефонной записи по номеру телефона
</details>

### 1 Request 'GET /users' - получение всех пользователей
### 1 Response 'GET /users' - получение всех пользователей
`200 OK`

```javascript
{
    "status": "OK",
    "time": "03-01-2020 06:29:48",
    "result": [
        {
            "id": 1,
            "name": "Dima",
            "email": "dima@mail.ru",
            "notes": null,
            "new": false
        },
        {
            "id": 2,
            "name": "Max",
            "email": "max@mail.ru",
            "notes": null,
            "new": false
        }
    ]
}
```
----


### 2 Request 'POST /users' - создает пользователя(user)
```javascript
{
	    "name": "Name3",
        "email": "name@mail.ru"
}
```
### 2 Response 'POST /users' - создает пользователя(user)
`200 OK`

```javascript
{
    "status": "CREATED",
    "time": "03-01-2020 06:53:15",
    "result": {
        "id": null,
        "name": "Name3",
        "email": "name@mail.ru",
        "notes": null,
        "new": true
    }
}
```
----

### 3 Request 'GET users/1'- получение одного пользователя по id
### 3 Response 'GET users/1'- получение одного пользователя по id
`200 OK`

```javascript
{
    "status": "OK",
    "time": "03-01-2020 06:33:12",
    "result": {
        "id": 1,
        "name": "Dima",
        "email": "dima@mail.ru",
        "notes": null,
        "new": false
    }
}
```
----

### 4 Request 'DELETE /notes/delete/2' - удаление пользователя по id
### 4 Response 'DELETE /notes/delete/2' - удаление пользователя по id
```javascript
{
    "status": "NO_CONTENT",
    "time": "03-01-2020 07:12:30",
    "result": {
        "id": 2,
        "name": "Max",
        "email": "max@mail.ru",
        "notes": null,
        "new": false
    }
}
```

### 5 Request 'PUT /users' - изменение данных пользователя

```javascript
{
    "id": "19cfe3f9-8bc0-41cc-8dba-27b37efd9b74",
    "name" : "max",
    "surname" : "shizov",
    "phone_book_id": "89c56e87-2a37-4b11-963a-117f33b8c48b"
}
```


### 6 Request 'POST /notes?userId=1' - создает запись
```javascript
{
	   "name": "Ira",
       "number": "123456"
}
```
### 6 Response 'POST /notes?userId=1' - создает запись
`200 OK`

```javascript
{
    "status": "CREATED",
    "time": "03-01-2020 07:05:41",
    "result": {
        "id": 7,
        "name": "Ira",
        "number": "123456",
        "new": false
    }
}
```
----

### 7 Request 'GET /notes/4/?userId=1'- получение одной записи по id
### 7 Response 'GET /notes/4/?userId=1'- получение одной записи по id
`200 OK`

```javascript
{
    "status": "OK",
    "time": "03-01-2020 07:09:20",
    "result": {
        "id": 4,
        "name": "Name2",
        "number": "1164",
        "new": false
    }
}
```
----

### 8 Request 'DELETE /notes/delete/0?userId=1' - удаление записи по id
### Response 'DELETE /notes/delete/0?userId=1' - удаление записи по id
```javascript
{
    "status": "NO_CONTENT",
    "time": "03-01-2020 06:42:58",
    "result": {
        "id": 0,
        "name": "Oleg",
        "number": "8800900",
        "new": false
    }
}
```

### 9 Request 'PUT /users' - изменение записи

```javascript
{
    "id": "19cfe3f9-8bc0-41cc-8dba-27b37efd9b74",
    "name" : "max",
    "surname" : "shizov",
    "phone_book_id": "89c56e87-2a37-4b11-963a-117f33b8c48b"
}
```


### 10 Request 'GET /notes?userId=1' получение всех записей в книжке пользователя
### Response 'GET /notes?userId=1' получение всех записей в книжке пользователя
`200 OK`

```javascript
{
    "status": "OK",
    "time": "03-01-2020 06:58:26",
    "result": [
        {
            "id": 1,
            "name": "Ivan",
            "number": "168413",
            "new": false
        },
        {
            "id": 4,
            "name": "Name2",
            "number": "1164",
            "new": false
        },
        {
            "id": 5,
            "name": "Name2",
            "number": "1164",
            "new": false
        }
    ]
}
```
----

### 11 Request 'GET /users/by?name=dima' - поиск пользователя по имени/части имени
### Response 'GET /users/by?name=dima' - поиск пользователя по имени/части имени
```javascript
{
    "status": "OK",
    "time": "03-01-2020 06:49:29",
    "result": [
        {
            "id": 1,
            "name": "Dima",
            "email": "dima@mail.ru",
            "notes": null,
            "new": false
        }
    ]
}
```

### 12 Request 'GET /notes/by?userId=1&number=168413' поиск записи по номеру телефона
### Response 'GET /notes/by?userId=1&number=168413' получение всех записей в книжке пользователя
`200 OK`

```javascript
{
    "status": "OK",
    "time": "03-01-2020 07:02:00",
    "result": [
        {
            "id": 1,
            "name": "Ivan",
            "number": "168413",
            "new": false
        }
    ]
}
```
----

### Example Response
`204 No Content`
----


Перед этим добавим еще пару пользователей с именами, начинающимися на di
### Example Request
`GET /api/user/search?inText=di` - если существуют пользователи с таким именем,
 то мы получим именно этих пользователей, но если таких нет, то мы получим тех,
 что имеют такое начало имени.

### Example Response
`200 OK`

```javascript
[
    {
        "id": "5b44697d-c7ad-4351-bcb1-78075f1cf972",
        "name": "dim",
        "surname": "privaloc",
        "phone_book_id": "9b182ab9-3265-4101-8ec6-689b3013a074"
    },
    {
        "id": "a64c286a-44b0-4ab3-bd6e-42c3704e71c4",
        "name": "dinar",
        "surname": "gazizulin",
        "phone_book_id": "327ca53f-afe9-40dd-919c-9300b689ea4e"
    },
    {
        "id": "1c958506-fb7f-4042-8a1d-aaaf2e3b7cba",
        "name": "dima",
        "surname": "orlov",
        "phone_book_id": "faef406f-689f-46ec-8f04-5ff8a01c45a0"
    },
    {
        "id": "23dc8520-1017-4229-a2ee-16c177f1f990",
        "name": "digit",
        "surname": "medvedevius",
        "phone_book_id": "bf654657-7f48-472c-a22d-c2668c38f4a0"
    }
]
```
----





### Example Request
`POST /api/pb/89c56e87-2a37-4b11-963a-117f33b8c48b` - создание записи(entryPhoneBook)
 в телефонной книжки пользователя(user) (по id телефонной книжки)

```javascript
{
	"name" : "Dasha",
	"value" : "893214513228"
}
```

### Example Response
`200 OK`

```javascript
{
    "id": "340f187b-6d18-4cfc-9239-a89c02f45bc9",
    "name": "Dasha",
    "value": "893214513228",
}
```
----


### Example Request
`PUT /api/pb/89c56e87-2a37-4b11-963a-117f33b8c48b` - изменение записи в телефонной книжке пользователя
 (по id  телефонной книжки и по id самой записи)
```javascript
{
	"id": "340f187b-6d18-4cfc-9239-a89c02f45bc9",
	"name" : "Dashenka",
	"value" : "893214513228"
}
```

### Example Response
`200 OK`

```javascript
{
	"id": "340f187b-6d18-4cfc-9239-a89c02f45bc9",
	"name" : "Dashenka",
	"value" : "893214513228"
}
```
----


### Example Request
`GET /api/pb/89c56e87-2a37-4b11-963a-117f33b8c48b/340f187b-6d18-4cfc-9239-a89c02f45bc9 - получение записи в
телефонной книжке пользователя (по id телефонной книжки и по id самой записи)

### Example Response
`200 OK`

```javascript
{
	"id": "340f187b-6d18-4cfc-9239-a89c02f45bc9",
	"name" : "Dashenka",
	"value" : "893214513228"
}
```
----


### Example Request
`GET /api/pb/89c56e87-2a37-4b11-963a-117f33b8c48b` - получение всех записей в телефонной книжке пользователя
(по id телефонной книжки)

### Example Response
`200 OK`

```javascript
{
	"id": "340f187b-6d18-4cfc-9239-a89c02f45bc9",
	"name" : "Dashenka",
	"value" : "893214513228"
}
```
----


### Example Request
`DELETE /api/pb/89c56e87-2a37-4b11-963a-117f33b8c48b` - удаление записи в телефонной книжке пользователя по id
(по  id телефонной книжки)

```javascript
{
	"id": "340f187b-6d18-4cfc-9239-a89c02f45bc9",
	"name" : "Dashenka",
	"value" : "893214513228"
}
```

### Example Response
`204 No Content`
----


Перед этим добавим еще пару записей с номерами, начинающимися на 89
### Example Request
`GET /api/pb/89c56e87-2a37-4b11-963a-117f33b8c48b/search?inText=89` - если существуют записи в телефонной книжке с таким номером,
 то мы получим именно эти записи, но если таких нет, то мы получим те, которые имеют такое начало номера.

### Example Response
`200 OK`

```javascript
[
    {
        "id": "f9b6a1cf-b51d-45fb-b6ed-3e1157042121",
        "name": "Dashenka",
        "value": "8799321432513228",
    },
    {
        "id": "b0a4e161-3936-44dd-865b-4e659d64685d",
        "name": "Dashenka",
        "value": "879932143251443228",
    },
    {
        "id": "7dc4d204-e6ee-45ab-bb3f-3d5711c7ffe9",
        "name": "Dashenka",
        "value": "879932143251443228",
    },
    {
        "id": "1c71078f-c86b-40d0-af34-2d56615e0698",
        "name": "Dashenka",
        "value": "87993214513228"
    }
]
```
----



