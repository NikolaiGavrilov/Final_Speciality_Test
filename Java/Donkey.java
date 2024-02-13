package Java;

import java.time.LocalDate;

public class Donkey extends PackAnimal {

    public Donkey(String name, LocalDate birthDate, char gender) {
        super(name, birthDate, gender);
        this.isPredator = false;
    }

    // Переопределение общих для всех животных навыков для осла с учетом пола
    @Override
    public void eat() {
        if (this.gender == 'f')
            System.out.println("Ваша ослица по имени " + this.name + " кушает");
        else
            System.out.println("Ваш осёл по имени " + this.name + " кушает");
    }

    @Override
    public void jump() {
        if (this.gender == 'f')
            System.out.println("Ваша ослица по имени " + this.name + " прыгает");
        else
            System.out.println("Ваш осёл по имени " + this.name + " прыгает");
    }

    @Override
    public void walk() {
        if (this.gender == 'f')
            System.out.println("Ваша ослица по имени " + this.name + " прохаживается");
        else
            System.out.println("Ваш осёл по имени " + this.name + " прохаживается");
    }

    // Переопределение навыков вьючных животных для осла с учетом пола
    @Override
    public void transportRider() {
        if (this.gender == 'f')
            System.out.println("Ваша ослица по имени " + this.name + " катает вас на себе");
        else
            System.out.println("Ваш осёл по имени " + this.name + " катает вас на себе");
    }

    @Override
    public void transportLoad() {
        if (this.gender == 'f')
            System.out.println("Ваша ослица по имени " + this.name + " везет на себе ваш груз");
        else
            System.out.println("Ваш осёл по имени " + this.name + " везет на себе ваш груз");
    }

    // Уникальный навык осла - кричать "И-а!"
    public void heeHaw() {
        if (this.gender == 'f')
            System.out.println("Ваша ослица по имени " + this.name + " кричит 'ИА!'");
        else
            System.out.println("Ваш осёл по имени " + this.name + " кричит 'ИА!'");
    }

}
