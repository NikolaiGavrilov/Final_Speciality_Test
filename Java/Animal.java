package Java;

import java.time.LocalDate;

public abstract class Animal {
    protected String name;
    protected LocalDate birthDate;
    protected char gender;
    protected boolean isPredator;

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

}
