package Java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Animal {
    protected String name;
    protected LocalDate birthDate;
    protected char gender;
    protected boolean isPredator;

    List<String> commands = Arrays.asList("кушать", "прыгать", "пройтись");

    protected Animal(String name, LocalDate birthDate, char gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.isPredator = false;
    };

    // Общие навыки, которыми обладают все животные - есть, прыгать, ходить
    public abstract void eat();

    public abstract void jump();

    public abstract void walk();

    public abstract List<String> getCommands();
}
