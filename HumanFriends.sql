-- Создаем базу данных humanfriends
DROP DATABASE IF EXISTS humanfriends;
CREATE DATABASE humanfriends;

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

-- Это был альтернативный менее удачный вариант заполнения
/*SET @id = 0;
INSERT INTO humanfriends.pets
SELECT @id := @id + 1 AS id, 'Cat' AS subtype, cats.name, cats.birthdate, cats.gender, cats.isPredator, cats.commands
FROM humanfriends.cats
UNION 
SELECT @id := @id + 1 AS id, 'Dog' AS subtype, dogs.name, dogs.birthdate, dogs.gender, dogs.isPredator, dogs.commands
FROM humanfriends.dogs
UNION 
SELECT @id := @id + 1 AS id, 'Hamster' AS subtype, hamsters.name, hamsters.birthdate, hamsters.gender, hamsters.isPredator, hamsters.commands
FROM humanfriends.hamsters;
*/

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

-- Создаем таблицу для животных в возрасте от 1 до 3 лет и вычисляем их возраст с точностью до месяца с округлением (до полных месяцев), записывая его в отдельный столбец.
DROP TABLE IF EXISTS humanfriends.onetothreeyearanimals;
CREATE TABLE humanfriends.onetothreeyearanimals AS
SELECT *, FLOOR(DATEDIFF(CURDATE(), birthDate)/30) as ageInMonths FROM humanfriends.pets
WHERE DATEDIFF(CURDATE(), birthDate)/30 >= 12 AND DATEDIFF(CURDATE(), birthDate)/30 <= 36
UNION
SELECT *, FLOOR(DATEDIFF(CURDATE(), birthDate)/30) as ageInMonths FROM humanfriends.packanimals
WHERE DATEDIFF(CURDATE(), birthDate)/30 >= 12 AND DATEDIFF(CURDATE(), birthDate)/30 <= 36;

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





