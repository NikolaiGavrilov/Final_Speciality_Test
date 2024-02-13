package Java;

import java.time.LocalDate;

public class Hamster extends Pet {

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

}
