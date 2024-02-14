package Java;

import java.time.LocalDate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Horse extends PackAnimal {
    List<String> commands = Arrays.asList("кушать", "прыгать", "пройтись", "покатать на себе",
            "понести груз", "заржать");

    public Horse(String name, LocalDate birthDate, char gender) {
        super(name, birthDate, gender);
        this.isPredator = false;
    }

    // Переопределение общих для всех животных навыков для лошади с учетом пола
    @Override
    public void eat() {
        if (this.gender == 'f')
            System.out.println("Ваша лошадь по имени " + this.name + " кушает");
        else
            System.out.println("Ваш конь по имени " + this.name + " кушает");
    }

    @Override
    public void jump() {
        if (this.gender == 'f')
            System.out.println("Ваша лошадь по имени " + this.name + " прыгает");
        else
            System.out.println("Ваш конь по имени " + this.name + " прыгает");
    }

    @Override
    public void walk() {
        if (this.gender == 'f')
            System.out.println("Ваша лошадь по имени " + this.name + " прохаживается");
        else
            System.out.println("Ваш конь по имени " + this.name + " прохаживается");
    }

    // Переопределение навыков вьючных животных для лошади с учетом пола
    @Override
    public void transportRider() {
        if (this.gender == 'f')
            System.out.println("Ваша лошадь по имени " + this.name + " катает вас на себе");
        else
            System.out.println("Ваш конь по имени " + this.name + " катает вас на себе");
    }

    @Override
    public void transportLoad() {
        if (this.gender == 'f')
            System.out.println("Ваша лошадь по имени " + this.name + " везет на себе ваш груз");
        else
            System.out.println("Ваш конь по имени " + this.name + " везет на себе ваш груз");
    }

    // Уникальный навык лошади - ржать
    public void neigh() {
        if (this.gender == 'f')
            System.out.println("Ваша лошадь по имени " + this.name + " издаёт ржание");
        else
            System.out.println("Ваш конь по имени " + this.name + " издаёт ржание");
    }

    @Override
    public String toString() {
        return String.format("Лошадь (имя: " + this.name +
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
