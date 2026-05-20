System bezpiecznego zapisu użytkowników i połączenia z bazą danych
Opis projektu

Aplikacja konsolowa napisana w języku Java, której zadaniem jest bezpieczne łączenie się z bazą danych PostgreSQL oraz tworzenie użytkowników z bezpiecznym przechowywaniem haseł.

Projekt wykorzystuje dwa mechanizmy bezpieczeństwa:

szyfrowanie AES do ochrony danych dostępowych do bazy danych,
BCrypt do hashowania haseł użytkowników.

Aplikacja umożliwia tworzenie użytkowników poprzez konsolę bez konieczności używania interfejsu graficznego lub strony internetowej.

Jak działa aplikacja
1. Program uruchamia aplikację konsolową.
2. Użytkownik podaje master password.
3. Aplikacja odszyfrowuje login i hasło do bazy danych przy użyciu AES.
4. Następuje bezpieczne połączenie z PostgreSQL.
5. Użytkownik może tworzyć nowe konta.
6. Hasła użytkowników są hashowane przy użyciu BCrypt.
7. Username oraz hash hasła zostają zapisane w bazie danych.
8. Program umożliwia wielokrotne tworzenie użytkowników aż do zakończenia działania aplikacji.

Struktura projektu

src/main/java/org/projekt2/App.java
Główna logika aplikacji i obsługa konsoli

src/main/java/org/projekt2/config/DatabaseConnection.java
Obsługa połączenia z bazą danych

src/main/java/org/projekt2/config/SecurityUtil.java
Szyfrowanie i odszyfrowywanie danych AES

src/main/java/org/projekt2/config/ConfigLoader.java
Wczytywanie konfiguracji aplikacji

src/main/java/org/projekt2/service/UserService.java
Logika tworzenia użytkowników i hashowania haseł

src/main/java/org/projekt2/model/User.java
Model użytkownika

src/test/java/org/projekt2/
Testy jednostkowe aplikacji

docker-compose.yml
Konfiguracja kontenera PostgreSQL

Przykładowe uruchomienie
docker compose up
Uruchamiamy w Intelij

Przykładowe działanie programu

Podaj master password:
1234567890ABCDEF

Witamy w aplikacji!

Czy chcesz utworzyć użytkownika? (tak/nie):
tak

Podaj username:
admin

Podaj hasło:
secret123

Użytkownik został zapisany bezpiecznie.

Autor
[Kamil Marusia]
[Kamil Dziedzina]

