package Java;

import java.time.LocalDate;

public abstract class PackAnimal extends Animal {

    protected PackAnimal(String name, LocalDate birthDate, char gender) {
        super(name, birthDate, gender);
    }

    // Уникальные умения вьючных животных - катать на себе ездока и перевозить на
    // себе грузы
    public abstract void transportRider();

    public abstract void transportLoad();
}
