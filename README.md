# Dino System

Тестовое задание для DINO System
<details><summary>ТЗ</summary>
1. Написать программу, удовлетворяющую указанным требованиям.
	
2. Написать юнит тесты на написанный код.

3. Должны быть использованы следующие технологии: 
Java (8 версии или выше),
Spring Boot, 
JUnit. 
Не должны быть использованы базы данных.

4. Должны быть предоставлены: 
исходный код программы, 
юнит тесты, 
инструкция по запуску программы, 
примеры вызова REST методов программы.

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

### 5 Request 'PUT /users/update/1' - изменение данных пользователя
```javascript
{
	"name":"Bagira",
	"email": "dima@mail.ru"
}
```

### 5 Response 'PUT /users/update/1' - изменение данных пользователя
`200 OK`

```javascript
{
    "status": "OK",
    "time": "03-01-2020 08:56:12",
    "result": {
        "id": 1,
        "name": "Bagira",
        "email": "dima@mail.ru",
        "notes": null
    }
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

### 9 Request 'PUT /notes/update/0?userId=1' - изменение записи
```javascript
{
	"name":"Oleg Sergeev",
	"number":"8800900"
}
```
### 9 Response 'PUT /users/update/1' - изменение данных пользователя
```javascript
{
    "status": "OK",
    "time": "03-01-2020 08:56:12",
    "result": {
        "id": 1,
        "name": "Bagira",
        "email": "dima@mail.ru",
        "notes": null
    }
}
```

### 10 Request 'GET /notes?userId=1' получение всех записей в книжке пользователя
### 10 Response 'GET /notes?userId=1' получение всех записей в книжке пользователя
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
### 11 Response 'GET /users/by?name=dima' - поиск пользователя по имени/части имени
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
### 12 Response 'GET /notes/by?userId=1&number=168413' получение всех записей в книжке пользователя
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
