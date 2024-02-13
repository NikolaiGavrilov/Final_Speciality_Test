package Java;

import java.time.LocalDate;
import java.util.Scanner;

public class AnimalRegistry {

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
                    System.out.println("Вы добавили животное " + cat.toString());
                    break;
                case 2:
                    Dog dog = new Dog(resultName, resultDate, resultGender);
                    System.out.println("Вы добавили животное " + dog.toString());
                    break;
                case 3:
                    Hamster hamster = new Hamster(resultName, resultDate, resultGender);
                    System.out.println("Вы добавили животное " + hamster.toString());
                    break;
                case 4:
                    Horse horse = new Horse(resultName, resultDate, resultGender);
                    System.out.println("Вы добавили животное " + horse.toString());
                    break;
                case 5:
                    Donkey donkey = new Donkey(resultName, resultDate, resultGender);
                    System.out.println("Вы добавили животное " + donkey.toString());
                    break;
                case 6:
                    Camel camel = new Camel(resultName, resultDate, resultGender);
                    System.out.println("Вы добавили животное " + camel.toString());
                    break;
                case 7:
                    determineType();
                default:
                    System.out.println(
                            "Допущена ошибка. Метод перезапускается. Повторите все шаги, водя корректные значения.");
                    addAnimal();
            }
        } catch (Exception e) {
            System.out.println(
                    "Допущена ошибка. Метод перезапускается. Повторите все шаги, водя корректные значения.");
            addAnimal();
        }
    }

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

}