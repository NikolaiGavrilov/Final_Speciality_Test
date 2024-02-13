package Java;

import java.time.LocalDate;

public class Dog extends Pet {

    public Dog(String name, LocalDate birthDate, char gender) {
        super(name, birthDate, gender);
        this.isPredator = true;
    }

    // Переопределение общих для всех животных навыков для собаки с учетом пола
    @Override
    public void eat() {
        if (this.gender == 'f')
            System.out.println("Ваша собака по имени " + this.name + " кушает");
        else
            System.out.println("Ваш пёс по имени " + this.name + " кушает");
    }

    @Override
    public void jump() {
        if (this.gender == 'f')
            System.out.println("Ваша собака по имени " + this.name + " прыгает");
        else
            System.out.println("Ваш пёс по имени " + this.name + " прыгает");
    }

    @Override
    public void walk() {
        if (this.gender == 'f')
            System.out.println("Ваша собака по имени " + this.name + " прохаживается");
        else
            System.out.println("Ваш пёс по имени " + this.name + " прохаживается");
    }

    // Переопределение навыков питомцев (дать себя погладить) для собаки с учетом
    // пола
    @Override
    public void bePetted() {
        if (this.gender == 'f')
            System.out.println("Ваша собака по имени " + this.name + " позволяет себя погладить");
        else
            System.out.println("Ваш пёс по имени " + this.name + " позволяет себя погладить");
    }

    // Уникальный навык собаки - лаять
    public void bark() {
        if (this.gender == 'f')
            System.out.println("Ваша собака по имени " + this.name + " гавкает");
        else
            System.out.println("Ваш пёс по имени " + this.name + " гавкает");
    }

}
