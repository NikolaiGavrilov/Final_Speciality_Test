package Java;

import java.time.LocalDate;

public abstract class Pet extends Animal {

    protected Pet(String name, LocalDate birthDate, char gender) {
        super(name, birthDate, gender);
    }

    // Уникальное умение питомцев - дают себя погладить
    public abstract void bePetted();

}
