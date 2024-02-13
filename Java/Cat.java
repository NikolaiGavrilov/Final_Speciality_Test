package Java;

import java.time.LocalDate;

public class Cat extends Pet {

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

}
