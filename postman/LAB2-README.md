# Лабораторна №2. HTTP-запити

## Запуск додатка

```bash
./mvnw spring-boot:run
```

Додаток працює на `http://localhost:8080`. Дані зберігаються в пам'яті, тому після кожного перезапуску знову є 3 початкові книги.
Перед тим як робити скріни, перезапустіть додаток, щоб запити пройшли на чистих даних.

## Postman

1. **Import** → виберіть файл `postman/Lab2-HTTP-requests.postman_collection.json`.
2. Відкрийте колекцію **Lab2 HTTP requests** (змінна `baseUrl` = `http://localhost:8080`).
3. Виконуйте запити 1–8 по черзі (**Send**) або всі разом через **Run collection**.

## Talend API Tester

Створіть запити вручну. Для POST і PUT додайте заголовок `Content-Type: application/json`.

| № | Метод  | URL                                    | Тіло |
|---|--------|----------------------------------------|------|
| 1 | GET    | `http://localhost:8080/api/v1/books`   | — |
| 2 | GET    | `http://localhost:8080/api/v1/books/1` | — |
| 3 | POST   | `http://localhost:8080/api/v1/books`   | `{"id":"4","name":"Test Book","description":"Created via Postman","author":"Test Author","year":2026}` |
| 4 | PUT    | `http://localhost:8080/api/v1/books/3` | `{"id":"3","name":"Updated Book","description":"Updated description","author":"Updated Author","year":2000}` |
| 5 | DELETE | `http://localhost:8080/api/v1/books/4` | — |

Після Create, Update і Delete повторіть **GET** `http://localhost:8080/api/v1/books` (для Update можна ще й `GET .../books/3`).

## Які скріни зробити

На кожному скріні мають бути видні метод, URL, тіло запиту (для POST/PUT), статус і тіло відповіді.

1. Get all — `200 OK`, 3 книги.
2. Get one — `200 OK`, книга `1` (Kobzar).
3. Create — `200 OK`, у відповіді створена книга `4`.
4. Get all після Create — 4 книги, серед них `4`.
5. Update — `200 OK`, книга `3` з новими даними.
6. Get one / Get all після Update — книга `3` оновлена.
7. Delete — `200 OK`, порожнє тіло.
8. Get all після Delete — 3 книги, книги `4` немає.
