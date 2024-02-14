# Итоговая контрольная работа по блоку специализация (Николай Гаврилов, февраль 2024 года)

__Информация о проекте__

Необходимо организовать систему учета для питомника в котором живут
домашние и вьючные животные.
___

## ЗАДАНИЯ

## 1 
*__Используя команду cat в терминале операционной системы Linux, создать
два файла - Домашние животные (заполнив файл собаками, кошками,
хомяками) и Вьючные животные (заполнив файл лошадьми, верблюдами и
ослами), а затем объединить их. Просмотреть содержимое созданного файла.
Переименовать файл, дав ему новое имя (Друзья человека)__*

![Скриншот1](Images/Screenshot1.jpg)

## 2
*__Создать директорию, переместить файл туда__*

![Скриншот2](Images/Screenshot2.jpg)

## 3
*__Подключить дополнительный репозиторий MySQL. Установить любой пакет
из этого репозитория__*


![Скриншот3](Images/Screenshot3.jpg)

## 4
*__Установить и удалить deb-пакет с помощью dpkg__*

![Скриншот4](Images/Screenshot4.jpg)

## 5
*__Выложить историю команд в терминале ubuntu__*

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

## 6
*__Нарисовать диаграмму, в которой есть класс родительский класс, домашние
животные и вьючные животные, в составы которых в случае домашних
животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные
войдут: лошади, верблюды и ослы.__*

![Диаграмма](Images/Diagram.jpg)

## 7
*__В подключенном MySQL репозитории создать базу данных “Друзья
человека”__*
````
DROP DATABASE IF EXISTS humanfriends;
CREATE DATABASE humanfriends;
````
#### [Мой скрипт, в котором создана эта база данных и выполнены все последующие задания по SQL](HumanFriends.sql)

## 8
*__Создать таблицы с иерархией из диаграммы в БД__*

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

## 9
*__Заполнить низкоуровневые таблицы именами(животных), командами
которые они выполняют и датами рождения__*

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

## 10
*__Удалить из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.__*

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

## 11
*__Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице__*

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

## 12
*__Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам.__*

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

#### [Мой скрипт со всеми командами и предыдущими заданиями по SQL](HumanFriends.sql)

## 13
__*Создать класс с Инкапсуляцией методов и наследованием по диаграмме.*__

Главный абстрактный класс - Animal. Наследники Animal - абстрактные классы Pet и PackAnimal. Наследники Pet - классы Cat, Dog и Hamster. Наследники PackAnimal - Horse, Donkey и Camel. 

Общие методы для всех животных: eat() - есть, walk() - ходить, jump() - прыгать.

Методы, доступные только для наследников Pet: bePetted() - приластиться/позволить себя погладить. 

Функции только для кошек: meow() - мяукать. Только для собак: bark() - лаять. Только для хомяков: playDead() - притвориться мёртвым.

Методы, доступные только для наследников PackAnimal: transportRider() - покатать ездока на себе, transportLoad() - повезти на себе груз. 

Доступные только лошадям: neigh() - ржать. Только верблюдам: spit() - плеваться. Только ослам: heeHaw() - кричать "Иа!".

#### [Ознакомиться с классами можно в этой директории](/Java)

## 14
__*Написать программу, имитирующую работу реестра домашних животных*__

#### [Класс, в котором реализован реестр](/Java/AnimalRegistry.java)

__*В программе должен быть реализован следующий функционал:*__

## 14.1 

__*Завести новое животное*__

````
public static void addAnimal() {
        Scanner addAnimalScanner1 = new Scanner(System.in);
        System.out.println("Вы привели новое животное, как здорово! Как его зовут?\n" +
                "Только на латинице, пожалуйста. Наш реестр пока не настроен на русские символы.\n"
                + "Введите имя: ");
        String resultName = addAnimalScanner1.next();
        try {
            Scanner addAnimalScanner2 = new Scanner(System.in);
            System.out.println(resultName + "? " + "На всякий случай - это он или она?\n"
                    + "Введите символ: m - самец, f - самка");
            char resultGender = addAnimalScanner2.next().charAt(0);
            if (resultGender != 'm' && resultGender != 'f') {
                throw new Exception("Неправильный символ");
            }
            Scanner addAnimalScanner3 = new Scanner(System.in);
            System.out.println("Когда родилось это чудо? Постарайтесь вспомнить!\n" +
                    "Введите дату в формате год-месяц-день. Например: 2024-02-13");
            LocalDate resultDate = LocalDate.parse(addAnimalScanner3.next());

            Scanner addAnimalScanner4 = new Scanner(System.in);
            System.out.println("Вы знаете, к какому виду относится это животное?\n"
                    + "1 - Кошка, 2 - Собака, 3 - Хомяк, 4 - Лошадь,\n" +
                    "5 - Осёл, 6 - Верблюд, 7 - помогите определить" +
                    "\nВведите лишь номер вашего выбора:");
            int resultType = addAnimalScanner4.nextInt();
            switch (resultType) {
                case 1:
                    Cat cat = new Cat(resultName, resultDate, resultGender);
                    animals.add(cat);
                    System.out.println("Вы добавили животное " + cat.toString());
                    break;
                case 2:
                    Dog dog = new Dog(resultName, resultDate, resultGender);
                    animals.add(dog);
                    System.out.println("Вы добавили животное " + dog.toString());
                    break;
                case 3:
                    Hamster hamster = new Hamster(resultName, resultDate, resultGender);
                    animals.add(hamster);
                    System.out.println("Вы добавили животное " + hamster.toString());
                    break;
                case 4:
                    Horse horse = new Horse(resultName, resultDate, resultGender);
                    animals.add(horse);
                    System.out.println("Вы добавили животное " + horse.toString());
                    break;
                case 5:
                    Donkey donkey = new Donkey(resultName, resultDate, resultGender);
                    animals.add(donkey);
                    System.out.println("Вы добавили животное " + donkey.toString());
                    break;
                case 6:
                    Camel camel = new Camel(resultName, resultDate, resultGender);
                    animals.add(camel);
                    System.out.println("Вы добавили животное " + camel.toString());
                    break;
                case 7:
                    determineType();
                default:
                    throw new Exception("Введен некорректный номер");
            }
        } catch (Exception e) {
            System.out.println("Допущена ошибка. Метод перезапускается." +
                    "Повторите все шаги, водя корректные значения.\n");
            addAnimal();
        }
    }
````
## 14.2 
__*Определять животное в правильный класс*__

Прим. автора: данная функция работает в паре с предыдущей. В случае незнания класса добавляемого животного пользователем, пользователь использует метод determineType(). В этом методе определяется класс, но программа отправляет пользователя обратно к методу addAnimal(), чтобы он ввёл информацию повторно с учетом новых знаний.
````
private static void determineType() {
        Scanner determineAnimalScan1 = new Scanner(System.in);
        System.out.println(
                "На этом животном можно ездить верхом взрослому человеку? 1 - да, 2 - нет\nВведите номер ответа:");
        int resultChoice1 = determineAnimalScan1.nextInt();
        if (resultChoice1 == 1) {
            Scanner determineAnimalScan2 = new Scanner(System.in);
            System.out.println("У этого животного есть горбы на спине? 1 - да, 2 - нет\nВведите номер ответа:");
            int resultChoice2 = determineAnimalScan2.nextInt();
            if (resultChoice2 == 1) {
                System.out.println("Кажется, это верблюд!");
                System.out.println("Ой, какой я забывчивый, надо ввести все данные заново.\n" +
                        "Зато теперь вы сразу назовётё мне вид этого животного.");
            } else if (resultChoice2 == 2) {
                Scanner determineAnimalScan3 = new Scanner(System.in);
                System.out.println("Это животное говорит 'ИА?'. 1 - да, 2 - нет\nВведите номер ответа:");
                int resultChoice3 = determineAnimalScan3.nextInt();
                if (resultChoice3 == 1) {
                    System.out.println("Я знаю! Это осёл!");
                    System.out.println("Ой, какой я забывчивый, надо ввести все данные заново.\n" +
                            "Зато теперь вы сразу назовётё мне вид этого животного.");
                } else if (resultChoice3 == 2) {
                    System.out.println("Конечно, не говорит! Это же лошадь!");
                    System.out.println("Ой, какой я забывчивый, надо ввести все данные заново.\n" +
                            "Зато теперь вы сразу назовётё мне вид этого животного.");
                } else {
                    System.out.println("Что-то мы запутались, будьте внимательнее. Давайте ещё раз.");
                    determineType();
                }
            } else {
                System.out.println("Что-то мы запутались, будьте внимательнее. Давайте ещё раз.");
                determineType();
            }
        } else if (resultChoice1 == 2) {
            Scanner determineAnimalScan4 = new Scanner(System.in);
            System.out.println("Это животное хищное? 1 - да, 2 - нет\nВведите номер ответа:");
            int resultChoice4 = determineAnimalScan4.nextInt();
            if (resultChoice4 == 1) {
                Scanner determineAnimalScan5 = new Scanner(System.in);
                System.out.println("Это животное мяукает? 1 - да, 2 - нет\nВведите номер ответа:");
                int resultChoice5 = determineAnimalScan4.nextInt();
                if (resultChoice5 == 1) {
                    System.out.println("Тогда всё ясно, это кошка");
                    System.out.println("Ой, какой я забывчивый, надо ввести все данные заново.\n" +
                            "Зато теперь вы сразу назовётё мне вид этого животного.");
                } else if (resultChoice5 == 2) {
                    System.out.println("По виду понятно, что оно не мяукает, а лает! Это же собака!");
                    System.out.println("Ой, какой я забывчивый, надо ввести все данные заново.\n" +
                            "Зато теперь вы сразу назовётё мне вид этого животного.");
                } else {
                    System.out.println("Что-то мы запутались, будьте внимательнее. Давайте ещё раз.");
                    determineType();
                }
            } else if (resultChoice4 == 2) {
                System.out.println("Такой малыш хищником быть не может. Это же хомяк!");
                System.out.println("Ой, какой я забывчивый, надо ввести все данные заново.\n" +
                        "Зато теперь вы сразу назовётё мне вид этого животного.");
            } else {
                System.out.println("Что-то мы запутались, будьте внимательнее. Давайте ещё раз.");
                determineType();
            }
        } else {
            System.out.println("Что-то мы запутались, будьте внимательнее. Давайте ещё раз.");
            determineType();
        }
    }
````
## 14.3 
__*Увидеть список команд, которое выполняет животное*__

В классе реестра:
````
public static void showAnimalCommands(Animal animal) {
        System.out.println("Животное " + animal + " знает команды: " + animal.getCommands());
    }
````
В классе животного действует абстрактный класс, данный метод нужно переопределить для классов-наследников:
````
public abstract List<String> getCommands();
````
Вот пример переопределения класса на базе класса кошки: 
````
public List<String> getCommands() {
        return this.commands;
    }
````
В классе Main, непосредственно уже вызов:
````
Cat cat1 = new Cat("Katya", LocalDate.parse("2010-10-10"), 'f');
        AnimalRegistry.showAnimalCommands(cat1);
````

## 14.4 
__*Обучить животное новым командам*__

В классе реестра:
````
public static void trainAnimal(Animal animal) {
        int newcommands = 0;
        for (String command : animal.getCommands()) {
            if (command.equals("станцевать"))
                newcommands++;
            else if (command.equals("принести предмет"))
                newcommands++;
            else if (command.equals("сальто"))
                newcommands++;
            else
                continue;
        }
        animal.addTrainingPoints();
        ;
        if (newcommands == 0) {
            animal.newCommand("станцевать");
            System.out.println("Ваше животное освоило новый приём - станцевать.\n" +
                    "Используйте команду dance().");
        } else if (newcommands == 1) {
            animal.newCommand("принести предмет");
            System.out.println(
                    "Ваше животное освоило новый приём - принести предмет.\n" +
                            "Используйте команду bringItToMe(String object), указав в скобках желаемый предмет, " +
                            "и животное его принесёт.");
        } else if (newcommands == 2) {
            animal.newCommand("делать сальто");
            System.out.println(
                    "Ваше животное освоило новый приём - сальто. \n" +
                            "Используйте команду backFlip(), и животное сделает сальто назад.\n" +
                            "Используйте команду frontFlip(), и животное сделает сальто вперёд.");
        } else
            System.out.println("Ваше животное нечему учить, оно уже всё умеет.");
    }
````

В родительском классе Animal прописываем дополнительно переменные, отвечающие за очки тренировки, метод увеличения этих очков, упомянутый в куске кода выше, а также все перечисленные выше новые методы, которые смогут использовать тренированные животные. Функционал этих методов будет ограничен, если животное не имеет достаточно очков. 

````
public abstract void newCommand(String newCommand);

    public void addTrainingPoints() {
        this.trainingPoints += 10;
    }

    public void dance() {
        if (this.trainingPoints > 0) {
            if (this.gender == 'f')
                System.out.println(this.name + " встает на задние лапы и танцует");
            else
                System.out.println(this.name + " встает на задние лапы и танцует");
        } else {
            if (this.gender == 'f')
                System.out.println(this.name
                        + " смотрит на вас и непонимающе моргает. Может, вам стоит разучить с ней этот прием с помощью trainAnimal?");
            else
                System.out.println(this.name
                        + " смотрит на вас и непонимающе моргает. Может, вам стоит разучить с ним этот прием с помощью trainAnimal?");
        }
    }

    public void bringItToMe(String object) {
        if (this.trainingPoints > 10) {
            if (this.gender == 'f')
                System.out.println(this.name + " приносит вам предмет: " + object);
            else
                System.out.println(this.name + " приносит вам предмет: " + object);
        } else {
            if (this.gender == 'f')
                System.out.println(this.name
                        + " смотрит на вас и непонимающе моргает. Может, вам стоит разучить с ней этот прием с помощью trainAnimal?");
            else
                System.out.println(this.name
                        + " смотрит на вас и непонимающе моргает. Может, вам стоит разучить с ним этот прием с помощью trainAnimal?");
        }
    }

    public void backFlip() {
        if (this.trainingPoints > 20) {
            if (this.gender == 'f')
                System.out.println(this.name + " делает обратное сальто");
            else
                System.out.println(this.name + " делает обратное сальто");
        } else {
            if (this.gender == 'f')
                System.out.println(this.name
                        + " смотрит на вас и непонимающе моргает. Может, вам стоит разучить с ней этот прием с помощью trainAnimal?");
            else
                System.out.println(this.name
                        + " смотрит на вас и непонимающе моргает. Может, вам стоит разучить с ним этот прием с помощью trainAnimal?");
        }
    }

    public void frontFlip() {
        if (this.trainingPoints > 20) {
            if (this.gender == 'f')
                System.out.println(this.name + " делает переднее сальто");
            else
                System.out.println(this.name + " делает переднее сальто");
        } else {
            if (this.gender == 'f')
                System.out.println(this.name
                        + " смотрит на вас и непонимающе моргает. Может, вам стоит разучить с ней этот прием с помощью trainAnimal?");
            else
                System.out.println(this.name
                        + " смотрит на вас и непонимающе моргает. Может, вам стоит разучить с ним этот прием с помощью trainAnimal?");
        }
    }

    
````
## 14.5 

__*Реализовать навигацию по меню*__

## 15 
__*Создайте класс Счетчик, у которого есть метод add(), увеличивающий̆
значение внутренней̆int переменной̆на 1 при нажатие “Завести новое
животное” Сделайте так, чтобы с объектом такого типа можно было работать в
блоке try-with-resources. Нужно бросить исключение, если работа с объектом
типа счетчик была не в ресурсном try и/или ресурс остался открыт. Значение
считать в ресурсе try, если при заведения животного заполнены все поля.*__

