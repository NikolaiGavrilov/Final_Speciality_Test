package Java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hamster extends Pet {
    List<String> commands = Arrays.asList("кушать", "прыгать", "пройтись", "дать себя погладить",
            "притвориться мёртвым");

    public Hamster(String name, LocalDate birthDate, char gender) {
        super(name, birthDate, gender);
        this.isPredator = false;
    }

    // Переопределение общих для всех животных навыков для хомяка с учетом пола
    @Override
    public void eat() {
        if (this.gender == 'f')
            System.out.println("Ваша хомячиха по имени " + this.name + " кушает");
        else
            System.out.println("Ваш хомяк по имени " + this.name + " кушает");
    }

    @Override
    public void jump() {
        if (this.gender == 'f')
            System.out.println("Ваша хомячиха по имени " + this.name + " прыгает");
        else
            System.out.println("Ваш хомяк по имени " + this.name + " прыгает");
    }

    @Override
    public void walk() {
        if (this.gender == 'f')
            System.out.println("Ваша хомячиха по имени " + this.name + " прохаживается");
        else
            System.out.println("Ваш хомяк по имени " + this.name + " прохаживается");
    }

    // Переопределение навыков питомцев (дать себя погладить) для хомяка с учетом
    // пола
    @Override
    public void bePetted() {
        if (this.gender == 'f')
            System.out.println("Ваша хомячиха по имени " + this.name + " позволяет себя погладить");
        else
            System.out.println("Ваш хомяк по имени " + this.name + " позволяет себя погладить");
    }

    // Уникальный навык хомяка - притвориться мертвым

    public void playDead() {
        if (this.gender == 'f')
            System.out.println("Ваша хомячиха по имени " + this.name + " притворяется мёртвой");
        else
            System.out.println("Ваш хомяк по имени " + this.name + " притворяется мёртвым");
    }

    @Override
    public String toString() {
        return String.format("Хомяк (имя: " + this.name +
                ", пол: " + this.gender + ", дата рождения: " + this.birthDate +
                ", явл.хищником: " + this.isPredator + ")");
    }

    @Override
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
