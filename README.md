# Fruit Manager
### Это простое приложение на Java для работы с текстовыми файлами, которые содержат список слов. Оно предоставляет следующие функции:

- Подсчет количества слов в файле.
- Поиск самых длинных слов в файле.
- Определение частоты встречаемости каждого слова в файле.

## Использование
- ### Загрузите проект:
Склонируйте репозиторий с помощью Git:
```bash
git clone https://github.com/your_username/FruitManager.git
```

- ### Запустите приложение:
Откройте проект в вашей любимой интегрированной среде разработки (IDE) или выполните следующую команду в командной строке:
```bash
java FruitManager
```
- ### Укажите файл с данными:
Приложение ожидает, что вы предоставите текстовый файл с именем input.txt в том же каталоге, где находится скомпилированный файл .class.

## Примеры
Предположим, у вас есть файл input.txt со следующим содержимым:
```
apple banana orange banana apple
grape apple apple orange
banana orange
```
Запуск приложения приведет к следующему выводу:
```В файле 10 слов.
В файле 11 слов.
Список самых длинных слов: banana orange
Частота встречаемости слов:
apple: 4
banana: 3
orange: 3
grape: 1
```

