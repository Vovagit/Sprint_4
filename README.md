# Sprint_4
# Запуск chrome

```bash
mvn test
```

# Запуск firefox

```bash
mvn -Dbrowser=firefox test
```

Если при запуске mvn test с firefox возникает ошибка 500,необходимо добавить параметр запуска:
```bash
-Dwebdriver.firefox.bin = путь к bin файлу firefox
```
