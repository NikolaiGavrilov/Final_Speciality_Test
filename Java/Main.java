package Java;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // AnimalRegistry.addAnimal();
        Cat cat = new Cat("Elfi", LocalDate.parse("2010-10-10"), 'f');
        AnimalRegistry.getCommands(cat);
    }
}