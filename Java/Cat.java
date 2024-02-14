package Java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cat extends Pet {
    List<String> commands = Arrays.asList("кушать", "прыгать", "пройтись", "дать себя погладить", "мяукнуть");

    public Cat(String name, LocalDate birthDate, char gender) {
        super(name, birthDate, gender);
        this.isPredator = true;
    }

    // Переопределение общих для всех животных навыков для кошки с учетом пола
    @Override
    public void eat() {
        if (this.gender == 'f')
            System.out.println("Ваша кошка по имени " + this.name + " кушает");
        else
            System.out.println("Ваш кот по имени " + this.name + " кушает");
    }

    @Override
    public void jump() {
        if (this.gender == 'f')
            System.out.println("Ваша кошка по имени " + this.name + " прыгает");
        else
            System.out.println("Ваш кот по имени " + this.name + " прыгает");
    }

    @Override
    public void walk() {
        if (this.gender == 'f')
            System.out.println("Ваша кошка по имени " + this.name + " прохаживается");
        else
            System.out.println("Ваш кот по имени " + this.name + " прохаживается");
    }

    // Переопределение навыков питомцев (дать себя погладить) для кошки с учетом
    // пола
    @Override
    public void bePetted() {
        if (this.gender == 'f')
            System.out.println("Ваша кошка по имени " + this.name + " позволяет себя погладить");
        else
            System.out.println("Ваш кот по имени " + this.name + " позволяет себя погладить");
    }

    // Уникальный навык кошки - мяукать
    public void meow() {
        if (this.gender == 'f')
            System.out.println("Ваша кошка по имени " + this.name + " мяукает");
        else
            System.out.println("Ваш кот по имени " + this.name + " мяукает");
    }

    @Override
    public String toString() {
        return String.format("Кошка (имя: " + this.name +
                ", пол: " + this.gender + ", дата рождения: " + this.birthDate +
                ", явл.хищником: " + this.isPredator + ")");
    }

    public List<String> getCommands() {
        return this.commands;
    }

    @Override
    public void newCommand(String newCommand) {
        List<String> list = new ArrayList<>();
        for (String command : this.commands) {
            list.add(command);
        }
        list.add(newCommand);
        this.commands = list;
    }

}
