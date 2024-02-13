# Итоговая контрольная работа по блоку специализация (Николай Гаврилов, февраль 2024 года)

__Информация о проекте__

Необходимо организовать систему учета для питомника в котором живут
домашние и вьючные животные.
___

## Операционные системы и виртуализация (Linux)
\
__1. Использование команды cat в Linux__

Создать два текстовых файла: "Pets"(Домашние животные) и "Pack
animals"(вьючные животные), используя команду `cat` в терминале Linux. В
первом файле перечислить собак, кошек и хомяков. Во втором — лошадей,
верблюдов и ослов.
Объединить содержимое этих двух файлов в один и просмотреть его
содержимое.
Переименовать получившийся файл в "Human Friends".
Пример конечного вывода после команды “ls” :
Desktop Documents Downloads HumanFriends.txt Music PackAnimals.txt
Pets.txt Pictures Videos

![Скриншот1](Images/Screenshot1.jpg)

__2. Работа с директориями в Linux__

Создать новую директорию и переместить туда файл "Human Friends".

![Скриншот2](Images/Screenshot2.jpg)

__3. Работа с MySQL в Linux. “Установить MySQL на вашу вычислительную
машину”__

Подключить дополнительный репозиторий MySQL и установить один из пакетов из этого репозитория.

![Скриншот3](Images/Screenshot3.jpg)

__4. Управление deb-пакетами__

Установить и затем удалить deb-пакет, используя команду `dpkg`.

![Скриншот4](Images/Screenshot4.jpg)

__5. История команд в терминале Ubuntu__

Сохранить и выложить историю ваших терминальных команд в Ubuntu.

```
mnogoliky@mnogolikyPC:~$ history
    178  mkdir Final_Speciality_Test
    179  cd Final_Speciality_Test
    180  cat > Pets.txt
    181  cat Pets.txt
    182  cat > Pack_Animals.txt
    183  cat Pets.txt Pack_Animals.txt > All_Animals.txt
    184  more All_Animals.txt
    185  mv All_Animals.txt Human_Friends.txt
    186  ls
    187  clear
    188  ls
    189  mkdir Animals_Dir
    190  mv Human_Friends.txt Animals_Dir
    191  ls - a
    192  cd Animals_Dir
    193  ll
    194  history
    195  clear
    196  wget -c https://dev.mysql.com/get/mysql-apt-config_0.8.16-1_all.deb
    197  sudo dpkg -i mysql-apt-config_0.8.16-1_all.deb
    198  sudo apt update
    199  sudo apt-get install mysql-server
    200  sudo mysql_secure_installation
    201  sudo systemctl status mysql
    202  history
    203  sudo mysql
    204  exit
    205  history
    206  clear
    207  wget http://archive.ubuntu.com/ubuntu/pool/universe/m/mc/mc_4.8.24-2ubuntu1_amd64.deb
    208  sudo dpkg -i mc_4.8.27-1_amd64.deb
    209  sudo apt install -f
    210  sudo dpkg -r mc
    211  history
```
В формате: Файла с ФИО, датой сдачи, номером группы(или потока)

___
## Объектно-ориентированное программирование

__6. Диаграмма классов__

Создать диаграмму классов с родительским классом "Животные", и двумя
подклассами: "Pets" и "Pack animals".
В составы классов которых в случае Pets войдут классы: собаки, кошки,
хомяки, а в класс Pack animals войдут: Лошади, верблюды и ослы.
Каждый тип животных будет характеризоваться (например, имена, даты
рождения, выполняемые команды и т.д)
Диаграмму можно нарисовать в любом редакторе, такими как Lucidchart,
Draw.io, Microsoft Visio и других.

![Диаграмма](Images/Diagram.jpg)

__7. Работа с MySQL (Задача выполняется в случае успешного выполнения
задачи “Работа с MySQL в Linux. “Установить MySQL на вашу машину”)__

7.1 После создания диаграммы классов в 6 пункте, в 7 пункте база данных
"Human Friends" должна быть структурирована в соответствии с этой
диаграммой. Например, можно создать таблицы, которые будут
соответствовать классам "Pets" и "Pack animals", и в этих таблицах будут поля, которые характеризуют каждый тип животных (например, имена, даты
рождения, выполняемые команды и т.д.).

7.2 В ранее подключенном MySQL создать базу данных с названием
"Human Friends".
````
DROP DATABASE IF EXISTS humanfriends;
CREATE DATABASE humanfriends;
````
Создать таблицы, соответствующие иерархии из вашей диаграммы
классов.
````
-- Используем базу данных humanfriends для дальнейших действий
USE humanfriends;

-- Создаем таблицы отдельных видов животных, таблицы питомцев и вьюточных животных, таблицу всех животных, собранных вместе
DROP TABLE IF EXISTS humanfriends.cats;
CREATE TABLE humanfriends.cats (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  birthDate DATE NOT NULL,
  gender CHAR(1) NOT NULL,
  isPredator TINYINT NOT NULL,
  commands TEXT NOT NULL,
  PRIMARY KEY (id));
  
DROP TABLE IF EXISTS humanfriends.dogs;
CREATE TABLE humanfriends.dogs (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  birthDate DATE NOT NULL,
  gender CHAR(1) NOT NULL,
  isPredator TINYINT NOT NULL,
  commands TEXT NOT NULL,
  PRIMARY KEY (id));
  
DROP TABLE IF EXISTS humanfriends.hamsters;
CREATE TABLE humanfriends.hamsters (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  birthDate DATE NOT NULL,
  gender CHAR(1) NOT NULL,
  isPredator TINYINT NOT NULL,
  commands TEXT NOT NULL,
  PRIMARY KEY (id));
  
DROP TABLE IF EXISTS humanfriends.horses;
CREATE TABLE humanfriends.horses (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  birthDate DATE NOT NULL,
  gender CHAR(1) NOT NULL,
  isPredator TINYINT NOT NULL,
  commands TEXT NOT NULL,
  PRIMARY KEY (id));
  
DROP TABLE IF EXISTS humanfriends.donkeys;
CREATE TABLE humanfriends.donkeys (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  birthDate DATE NOT NULL,
  gender CHAR(1) NOT NULL,
  isPredator TINYINT NOT NULL,
  commands TEXT NOT NULL,
  PRIMARY KEY (id));

DROP TABLE IF EXISTS humanfriends.camels;
CREATE TABLE humanfriends.camels (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  birthDate DATE NOT NULL,
  gender CHAR(1) NOT NULL,
  isPredator TINYINT NOT NULL,
  commands TEXT NOT NULL,
  PRIMARY KEY (id));
  
DROP TABLE IF EXISTS humanfriends.pets;
CREATE TABLE humanfriends.pets (
  id INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NOT NULL,
  subtype VARCHAR(45) NOT NULL,
  birthDate DATE NOT NULL,
  gender CHAR(1) NOT NULL,
  isPredator TINYINT NOT NULL,
  commands TEXT NOT NULL);
  
DROP TABLE IF EXISTS humanfriends.packanimals;
CREATE TABLE humanfriends.packanimals (
  id INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NOT NULL,
  subtype VARCHAR(45) NOT NULL,
  birthDate DATE NOT NULL,
  gender CHAR(1) NOT NULL,
  isPredator TINYINT NOT NULL,
  commands TEXT NOT NULL);
  
DROP TABLE IF EXISTS humanfriends.animals;
CREATE TABLE humanfriends.animals (
  id INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NOT NULL,
  type VARCHAR(45) NOT NULL,
  subtype VARCHAR(45) NOT NULL,
  birthDate DATE NOT NULL,
  gender CHAR(1) NOT NULL,
  isPredator TINYINT NOT NULL,
  commands TEXT NOT NULL);
````
Заполнить таблицы данными о животных, их командах и датах
рождения.
````
-- Заполняем таблицы животными 
INSERT INTO humanfriends.cats (name, birthDate, gender, isPredator, commands)
VALUES 
('Katya', '2000-03-01', 'f', '1', 'eat, jump, walk, bePetted, meow'),
('Sasha', '2006-09-13', 'f', '1', 'eat, jump, walk, bePetted, meow'),
('Seva', '2022-10-10', 'm', '1', 'eat, jump, walk, bePetted, meow');

INSERT INTO humanfriends.dogs (name, birthDate, gender, isPredator, commands)
VALUES 
('Bobik', '2011-11-01', 'm', '1', 'eat, jump, walk, bePetted, bark'),
('Rex', '2007-07-17', 'm', '1', 'eat, jump, walk, bePetted, bark'),
('Mukhtar', '2022-04-04', 'm', '1', 'eat, jump, walk, bePetted, bark');

INSERT INTO humanfriends.hamsters (name, birthDate, gender, isPredator, commands)
VALUES 
('Elvin', '2023-06-12', 'm', '0', 'eat, jump, walk, bePetted, playDead'),
('Ryzhik', '2023-01-11', 'm', '0', 'eat, jump, walk, bePetted, playDead'),
('Vasilisa', '2022-02-04', 'f', '0', 'eat, jump, walk, bePetted, playDead');

INSERT INTO humanfriends.horses (name, birthDate, gender, isPredator, commands)
VALUES 
('Servilat', '2020-03-20', 'm', '0', 'eat, jump, walk, transportRider, neigh'),
('Lyubimka', '2018-02-14', 'f', '0', 'eat, jump, walk, transportRider, neigh');

INSERT INTO humanfriends.donkeys (name, birthDate, gender, isPredator, commands)
VALUES 
('Donkey', '2012-06-02', 'm', '0', 'eat, jump, walk, transportRider, hee-haw'),
('Hee-Haw', '2017-08-27', 'm', '0', 'eat, jump, walk, transportRider, hee-haw'),
('Skotinka', '2021-11-13', 'f', '0', 'eat, jump, walk, transportRider, hee-haw');

INSERT INTO humanfriends.camels (name, birthDate, gender, isPredator, commands)
VALUES 
('Gorbachev', '2021-12-11', 'm', '0', 'eat, jump, walk, transportRider, spit'),
('Alladin', '2016-04-14', 'm', '0', 'eat, jump, walk, transportRider, spit'),
('Arabskaya Noch', '2009-01-02', 'f', '0', 'eat, jump, walk, transportRider, spit');

-- Заполняем таблицу домашних животных через селект-запрос с объединением (к кошкам, собакам, хомякам)
INSERT INTO humanfriends.pets(name, subtype, birthDate, gender, isPredator, commands)
SELECT cats.name, 'Cat' AS subtype, cats.birthDate, cats.gender, cats.isPredator, cats.commands
FROM humanfriends.cats
UNION 
SELECT dogs.name, 'Dog' AS subtype, dogs.birthDate, dogs.gender, dogs.isPredator, dogs.commands
FROM humanfriends.dogs
UNION 
SELECT hamsters.name, 'Hamster' AS subtype, hamsters.birthDate, hamsters.gender, hamsters.isPredator, hamsters.commands
FROM humanfriends.hamsters;
````
Удалить записи о верблюдах и объединить таблицы лошадей и ослов.
````
-- Удаляем записи о верблюдах в соответствии с заданием, выключаем на время этой операции безопасный режим (например, при ошибке в работе с MySQL Workbench) и включаем снова
SET SQL_SAFE_UPDATES = 0;
DELETE FROM humanfriends.camels;
SET SQL_SAFE_UPDATES = 1;

-- Объединяем лошадей и ослов в единую таблицу
INSERT INTO humanfriends.packanimals (name, subtype, birthDate, gender, isPredator, commands)
SELECT horses.name, 'Horse' AS subtype, horses.birthDate, horses.gender, horses.isPredator, horses.commands
FROM humanfriends.horses
UNION 
SELECT donkeys.name, 'Donkey' AS subtype, donkeys.birthDate, donkeys.gender, donkeys.isPredator, donkeys.commands
FROM humanfriends.donkeys;
````
Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить
их возраст с точностью до месяца.
````
-- Создаем таблицу для животных в возрасте от 1 до 3 лет и вычисляем их возраст с точностью до месяца с округлением (до полных месяцев), записывая его в отдельный столбец.
DROP TABLE IF EXISTS humanfriends.onetothreeyearanimals;
CREATE TABLE humanfriends.onetothreeyearanimals AS
SELECT *, FLOOR(DATEDIFF(CURDATE(), birthDate)/30) as ageInMonths FROM humanfriends.pets
WHERE DATEDIFF(CURDATE(), birthDate)/30 >= 12 AND DATEDIFF(CURDATE(), birthDate)/30 <= 36
UNION
SELECT *, FLOOR(DATEDIFF(CURDATE(), birthDate)/30) as ageInMonths FROM humanfriends.packanimals
WHERE DATEDIFF(CURDATE(), birthDate)/30 >= 12 AND DATEDIFF(CURDATE(), birthDate)/30 <= 36;
````
Объединить все созданные таблицы в одну, сохраняя информацию о
принадлежности к исходным таблицам.

````
-- Объединим все созданные таблицы с животными в одну (верблюдов тоже указываем, хотя помним, что таблица была очищена).

INSERT INTO humanfriends.animals (name, type, subtype, birthDate, gender, isPredator, commands)
SELECT cats.name, 'Pet' as type, 'Cat' AS subtype, cats.birthDate, cats.gender, cats.isPredator, cats.commands FROM humanfriends.cats
UNION
SELECT dogs.name, 'Pet' as type, 'Dog' AS subtype, dogs.birthDate, dogs.gender, dogs.isPredator, dogs.commands FROM humanfriends.dogs
UNION
SELECT hamsters.name, 'Pet' as type, 'Hamster' AS subtype, hamsters.birthDate, hamsters.gender, hamsters.isPredator, hamsters.commands FROM humanfriends.hamsters
UNION
SELECT horses.name, 'Pack Animal' as type, 'Horse' AS subtype, horses.birthDate, horses.gender, horses.isPredator, horses.commands FROM humanfriends.horses
UNION
SELECT donkeys.name, 'Pack Animal' as type, 'Donkey' AS subtype, donkeys.birthDate, donkeys.gender, donkeys.isPredator, donkeys.commands FROM humanfriends.donkeys
UNION
SELECT camels.name, 'Pack Animal' as type, 'Camel' AS subtype, camels.birthDate, camels.gender, camels.isPredator, camels.commands FROM humanfriends.camels;

-- Присоединяем с помощью RIGHT JOIN'а колонку с возрастом (в месяцах) из таблицы молодых животных для тех животных, которые были в той таблице.
CREATE TABLE humanfriends.allanimalswithage AS
SELECT animals.*, onetothreeyearanimals.ageInMonths FROM humanfriends.animals 
RIGHT OUTER JOIN humanfriends.onetothreeyearanimals
ON animals.name = onetothreeyearanimals.name
UNION
SELECT animals.*, onetothreeyearanimals.ageInMonths IS NULL FROM humanfriends.animals 
RIGHT OUTER JOIN humanfriends.onetothreeyearanimals
ON animals.name NOT IN (SELECT onetothreeyearanimals.name FROM humanfriends.onetothreeyearanimals where onetothreeyearanimals.name IS NOT NULL);

-- Перезаполняем возраст (в месяцах) для всех животных, чтобы он отображался у каждой строки в таблице
SET SQL_SAFE_UPDATES = 0;
UPDATE humanfriends.allanimalswithage 
SET ageInMonths = FLOOR(DATEDIFF(CURDATE(), allanimalswithage.birthDate)/30);
SET SQL_SAFE_UPDATES = 1;

-- Выводим финальный результат в порядке возрастания индексов
SELECT * FROM humanfriends.allanimalswithage
ORDER BY id ASC;
````

#### [Скрипт со всеми командами](HumanFriends.sql)
\
__8. ООП и Java__

__Создать иерархию классов в Java, который будет повторять диаграмму
классов созданную в задаче 6(Диаграмма классов).__

Главный абстрактный класс - Animal. Наследники Animal - абстрактные классы Pet и PackAnimal. Наследники Pet - классы Cat, Dog и Hamster. Наследники PackAnimal - Horse, Donkey и Camel. 

Общие методы для всех животных: eat() - есть, walk() - ходить, jump() - прыгать.

Методы, доступные только для наследников Pet: bePetted() - приластиться/позволить себя погладить. 

Функции только для кошек: meow() - мяукать. Только для собак: bark() - лаять. Только для хомяков: playDead() - притвориться мёртвым.

Методы, доступные только для наследников PackAnimal: transportRider() - покатать ездока на себе, transportLoad() - повезти на себе груз. 

Доступные только лошадям: neigh() - ржать. Только верблюдам: spit() - плеваться. Только ослам: heeHaw() - кричать "Иа!".

#### [Ознакомиться с классами можно в этой директории](/Java)
\
__9. Программа-реестр домашних животных__

Написать программу на Java, которая будет имитировать реестр
домашних животных.
Должен быть реализован следующий функционал:

__9.1 Добавление нового животного__
Реализовать функциональность для добавления новых животных в
реестр.
Животное должно определяться в правильный класс (например, "собака",
"кошка", "хомяк" и т.д.)

__9.2 Список команд животного__
Вывести список команд, которые может выполнять добавленное
животное (например, "сидеть", "лежать").

__9.3 Обучение новым командам__
Добавить возможность обучать животных новым командам.

__9.4 Вывести список животных по дате рождения__

__9.5 Навигация по меню__
Реализовать консольный пользовательский интерфейс с меню для
навигации между вышеуказанными функциями.

__10. Счетчик животных__
Создать механизм, который позволяет вывести на экран общее количество
созданных животных любого типа (Как домашних, так и вьючных), то есть при
создании каждого нового животного счетчик увеличивается на “1”.
