package Java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Camel extends PackAnimal {
    List<String> commands = Arrays.asList("кушать", "прыгать", "пройтись", "покатать на себе",
            "понести груз", "плюнуть");

    public Camel(String name, LocalDate birthDate, char gender) {
        super(name, birthDate, gender);
        this.isPredator = false;
    }

    // Переопределение общих для всех животных навыков для верблюда с учетом пола
    @Override
    public void eat() {
        if (this.gender == 'f')
            System.out.println("Ваша верблюдица по имени " + this.name + " кушает");
        else
            System.out.println("Ваш верблюд по имени " + this.name + " кушает");
    }

    @Override
    public void jump() {
        if (this.gender == 'f')
            System.out.println("Ваша верблюдица по имени " + this.name + " прыгает");
        else
            System.out.println("Ваш верблюд по имени " + this.name + " прыгает");
    }

    @Override
    public void walk() {
        if (this.gender == 'f')
            System.out.println("Ваша верблюдица по имени " + this.name + " прохаживается");
        else
            System.out.println("Ваш верблюд по имени " + this.name + " прохаживается");
    }

    // Переопределение навыков вьючных животных для верблюда с учетом пола
    @Override
    public void transportRider() {
        if (this.gender == 'f')
            System.out.println("Ваша верблюдица по имени " + this.name + " катает вас на себе");
        else
            System.out.println("Ваш верблюд по имени " + this.name + " катает вас на себе");
    }

    @Override
    public void transportLoad() {
        if (this.gender == 'f')
            System.out.println("Ваша верблюдица по имени " + this.name + " везет на себе ваш груз");
        else
            System.out.println("Ваш верблюд по имени " + this.name + " везет на себе ваш груз");
    }

    // Уникальный собственный навык верблюда - плеваться
    public void spit() {
        if (this.gender == 'f')
            System.out.println("Ваша верблюдица по имени " + this.name + " плюётся в вас");
        else
            System.out.println("Ваш верблюд по имени " + this.name + " плюётся в вас");
    }

    @Override
    public String toString() {
        return String.format("Верблюд (имя: " + this.name +
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
