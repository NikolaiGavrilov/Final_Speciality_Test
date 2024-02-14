package Java;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {

    public static void start() {
        while (true) {
            Scanner chooseFunction = new Scanner(System.in);
            System.out.println("Добро пожаловать! Вам доступны следующие функции:" +
                    "\n1 - завести животное, 2 - определить вид животного, 3 - список ваших животных,"
                    + "\n4 - посмотреть список команд у животных, 5 - обучить животное, 6 - использовать команды животного");
            int functionChoice = chooseFunction.nextInt();
            switch (functionChoice) {
                case (1):
                    AnimalRegistry.addAnimal();
                    break;
                case (2):
                    AnimalRegistry.determineType();
                    break;
                case (3):
                    AnimalRegistry.showAnimalList();
                    break;
                case (4):
                    Scanner chooseAnimalType = new Scanner(System.in);
                    System.out.println("Команды какого животного вас интересуют?" +
                            "\n1 - Кошка, 2 - Собака, 3 - Хомяк" +
                            "\n4 - Лошадь, 5 - Осёл, 6 - Верблюд, 7 - животного, которое я завел");
                    int animalTypeChoice = chooseAnimalType.nextInt();
                    Cat cat = new Cat("Cat", LocalDate.parse("2022-01-01"), 'f');
                    Dog dog = new Dog("Dog", LocalDate.parse("2022-01-01"), 'm');
                    Hamster hamster = new Hamster("Hamster", LocalDate.parse("2022-01-01"), 'm');
                    Horse horse = new Horse("Horse", LocalDate.parse("2022-01-01"), 'f');
                    Donkey donkey = new Donkey("Donkey", LocalDate.parse("2022-01-01"), 'm');
                    Camel camel = new Camel("Camel", LocalDate.parse("2022-01-01"), 'm');
                    if (animalTypeChoice == 1)
                        AnimalRegistry.showAnimalCommands(cat);
                    else if (animalTypeChoice == 2)
                        AnimalRegistry.showAnimalCommands(dog);
                    else if (animalTypeChoice == 3)
                        AnimalRegistry.showAnimalCommands(hamster);
                    else if (animalTypeChoice == 4)
                        AnimalRegistry.showAnimalCommands(horse);
                    else if (animalTypeChoice == 5)
                        AnimalRegistry.showAnimalCommands(donkey);
                    else if (animalTypeChoice == 6)
                        AnimalRegistry.showAnimalCommands(camel);
                    else if (animalTypeChoice == 7)
                        if (AnimalRegistry.animals.size() == 0)
                            System.out.println(
                                    "У вас пока нет животного. Сперва заведите животное, используя соответствующую функцию в главном меню.");
                        else {
                            AnimalRegistry.showAnimalCommands(AnimalRegistry.animals.getLast());
                        }
                    else {
                        System.out.println("Вы ввели некорректное значение. Выполняется перезапуск программы...");
                        start();
                    }
                    break;
                case (5):
                    if (AnimalRegistry.animals.size() == 0)
                        System.out.println(
                                "У вас пока нет животного. Сперва заведите животное, используя соответствующую функцию в главном меню.");
                    else {
                        Animal yourAnimal = AnimalRegistry.animals.getLast();
                        System.out.println("Посмотрим, что умеет ваше животное" + yourAnimal.toString());
                        AnimalRegistry.showAnimalCommands(yourAnimal);
                        System.out.println("Приступаем к тренировке!");
                        AnimalRegistry.trainAnimal(yourAnimal);
                        System.out.println("Тренировка окончена! Давайте проверим навыки вашего питомца");
                        AnimalRegistry.showAnimalCommands(yourAnimal);
                    }
                    break;
                case (6):
                    if (AnimalRegistry.animals.size() == 0)
                        System.out.println(
                                "У вас пока нет животного. Сперва заведите животное, используя соответствующую функцию в главном меню.");
                    else {
                        Animal yourAnimal = AnimalRegistry.animals.getLast();
                        System.out.println("Вот список команд. Попробуйте дать команду вашему животному.");
                        System.out.println(
                                "Учтите, что для некоторых команд придётся пройти тренировку, иначе животное попросту не сможет их выполнить.");
                        System.out.println("Ваше нынешнее животное - " + yourAnimal.toString());
                        for (String command : yourAnimal.getCommands()) {
                            if (command.equals("мяукнуть"))
                                commandsCat((Cat) yourAnimal);
                            else if (command.equals("полаять"))
                                commandsDog((Dog) yourAnimal);
                            else if (command.equals("притвориться мёртвым"))
                                commandsHamster((Hamster) yourAnimal);
                            else if (command.equals("заржать"))
                                commandsHorse((Horse) yourAnimal);
                            else if (command.equals("закричать ИА"))
                                commandsDonkey((Donkey) yourAnimal);
                            else if (command.equals("плюнуть"))
                                commandsCamel((Camel) yourAnimal);
                        }
                    }
            }

        }

    }

    public static void commandsCat(Cat animal) {
        Scanner chooseAction = new Scanner(System.in);
        System.out.println("Какими будут указания?"
                + "1 - кушать, 2 - прыгать, 3 - пройтись, 4 - дать себя погладить, 5 - мяукнуть, "
                + "6 - станцевать, 7 - принести предмет, 8 - делать сальто" + "\nВведите номер:");
        int actionChoice = chooseAction.nextInt();
        switch (actionChoice) {
            case (1):
                animal.eat();
                break;
            case (2):
                animal.jump();
                break;
            case (3):
                animal.walk();
                break;
            case (4):
                animal.bePetted();
                break;
            case (5):
                animal.meow();
                break;
            case (6):
                animal.dance();
                break;
            case (7):
                animal.bringItToMe("мышь");
                break;
            case (8):
                animal.backFlip();
                break;
            default:
                System.out.println("Ошибка! Требуется перезапустить программу!");
                start();
        }
    }

    public static void commandsDog(Dog animal) {
        Scanner chooseAction = new Scanner(System.in);
        System.out.println("Какими будут указания?"
                + "1 - кушать, 2 - прыгать, 3 - пройтись, 4 - дать себя погладить, 5 - гавкнуть, "
                + "6 - станцевать, 7 - принести предмет, 8 - делать сальто" + "\nВведите номер:");
        int actionChoice = chooseAction.nextInt();
        switch (actionChoice) {
            case (1):
                animal.eat();
                break;
            case (2):
                animal.jump();
                break;
            case (3):
                animal.walk();
                break;
            case (4):
                animal.bePetted();
                break;
            case (5):
                animal.bark();
                break;
            case (6):
                animal.dance();
                break;
            case (7):
                animal.bringItToMe("тапочки");
                break;
            case (8):
                animal.backFlip();
                break;
            default:
                System.out.println("Ошибка! Требуется перезапустить программу!");
                start();
        }
    }

    public static void commandsHamster(Hamster animal) {
        Scanner chooseAction = new Scanner(System.in);
        System.out.println("Какими будут указания?"
                + "1 - кушать, 2 - прыгать, 3 - пройтись, 4 - дать себя погладить, 5 - притвориться мертвым, "
                + "6 - станцевать, 7 - принести предмет, 8 - делать сальто" + "\nВведите номер:");
        int actionChoice = chooseAction.nextInt();
        switch (actionChoice) {
            case (1):
                animal.eat();
                break;
            case (2):
                animal.jump();
                break;
            case (3):
                animal.walk();
                break;
            case (4):
                animal.bePetted();
                break;
            case (5):
                animal.playDead();
                break;
            case (6):
                animal.dance();
                break;
            case (7):
                animal.bringItToMe("зёрнышко");
                break;
            case (8):
                animal.backFlip();
                break;
            default:
                System.out.println("Ошибка! Требуется перезапустить программу!");
                start();
        }
    }

    public static void commandsHorse(Horse animal) {
        Scanner chooseAction = new Scanner(System.in);
        System.out.println("Какими будут указания?"
                + "1 - кушать, 2 - прыгать, 3 - пройтись, 4 - покатать меня, 5 - повезти мой груз, "
                + "6 - заржать, 7 - станцевать, 8 - принести предмет, 9 - делать сальто" + "\nВведите номер:");
        int actionChoice = chooseAction.nextInt();
        switch (actionChoice) {
            case (1):
                animal.eat();
                break;
            case (2):
                animal.jump();
                break;
            case (3):
                animal.walk();
                break;
            case (4):
                animal.transportRider();
                break;
            case (5):
                animal.transportRider();
                break;
            case (6):
                animal.neigh();
                break;
            case (7):
                animal.dance();
                break;
            case (8):
                animal.bringItToMe("расческа для гривы");
                break;
            case (9):
                animal.backFlip();
                break;
            default:
                System.out.println("Ошибка! Требуется перезапустить программу!");
                start();
        }
    }

    public static void commandsDonkey(Donkey animal) {
        Scanner chooseAction = new Scanner(System.in);
        System.out.println("Какими будут указания?"
                + "1 - кушать, 2 - прыгать, 3 - пройтись, 4 - покатать меня, 5 - повезти мой груз, "
                + "6 - крикнуть ИА, 7 - станцевать, 8 - принести предмет, 9 - делать сальто" + "\nВведите номер:");
        int actionChoice = chooseAction.nextInt();
        switch (actionChoice) {
            case (1):
                animal.eat();
                break;
            case (2):
                animal.jump();
                break;
            case (3):
                animal.walk();
                break;
            case (4):
                animal.transportRider();
                break;
            case (5):
                animal.transportRider();
                break;
            case (6):
                animal.heeHaw();
                break;
            case (7):
                animal.dance();
                break;
            case (8):
                animal.bringItToMe("лопнутый воздушный шарик");
                break;
            case (9):
                animal.backFlip();
                break;
            default:
                System.out.println("Ошибка! Требуется перезапустить программу!");
                start();
        }
    }

    public static void commandsCamel(Camel animal) {
        Scanner chooseAction = new Scanner(System.in);
        System.out.println("Какими будут указания?"
                + "1 - кушать, 2 - прыгать, 3 - пройтись, 4 - покатать меня, 5 - повезти мой груз, "
                + "6 - плюнуть, 7 - станцевать, 8 - принести предмет, 9 - делать сальто" + "\nВведите номер:");
        int actionChoice = chooseAction.nextInt();
        switch (actionChoice) {
            case (1):
                animal.eat();
                break;
            case (2):
                animal.jump();
                break;
            case (3):
                animal.walk();
                break;
            case (4):
                animal.transportRider();
                break;
            case (5):
                animal.transportRider();
                break;
            case (6):
                animal.spit();
                break;
            case (7):
                animal.dance();
                break;
            case (8):
                animal.bringItToMe("лопнутый воздушный шарик");
                break;
            case (9):
                animal.backFlip();
                break;
            default:
                System.out.println("Ошибка! Требуется перезапустить программу!");
                start();
        }
    }
}
