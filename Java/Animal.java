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
    protected int trainingPoints = 0;

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

    public abstract void newCommand(String newCommand);

    public void addTrainingPoints() {
        this.trainingPoints += 10;
    }

    public void dance() {
        if (this.trainingPoints > 0) {
            if (this.gender == 'f')
                System.out.println(this.name + " встает на задние лапы и танцует");
            else
                System.out.println(this.name + " встает на задние лапы и танцует");
        } else {
            if (this.gender == 'f')
                System.out.println(this.name
                        + " смотрит на вас и непонимающе моргает. Может, вам стоит разучить с ней этот прием с помощью trainAnimal?");
            else
                System.out.println(this.name
                        + " смотрит на вас и непонимающе моргает. Может, вам стоит разучить с ним этот прием с помощью trainAnimal?");
        }
    }

    public void bringItToMe(String object) {
        if (this.trainingPoints > 10) {
            if (this.gender == 'f')
                System.out.println(this.name + " приносит вам предмет: " + object);
            else
                System.out.println(this.name + " приносит вам предмет: " + object);
        } else {
            if (this.gender == 'f')
                System.out.println(this.name
                        + " смотрит на вас и непонимающе моргает. Может, вам стоит разучить с ней этот прием с помощью trainAnimal?");
            else
                System.out.println(this.name
                        + " смотрит на вас и непонимающе моргает. Может, вам стоит разучить с ним этот прием с помощью trainAnimal?");
        }
    }

    public void backFlip() {
        if (this.trainingPoints > 20) {
            if (this.gender == 'f')
                System.out.println(this.name + " делает обратное сальто");
            else
                System.out.println(this.name + " делает обратное сальто");
        } else {
            if (this.gender == 'f')
                System.out.println(this.name
                        + " смотрит на вас и непонимающе моргает. Может, вам стоит разучить с ней этот прием с помощью trainAnimal?");
            else
                System.out.println(this.name
                        + " смотрит на вас и непонимающе моргает. Может, вам стоит разучить с ним этот прием с помощью trainAnimal?");
        }
    }

    public void frontFlip() {
        if (this.trainingPoints > 20) {
            if (this.gender == 'f')
                System.out.println(this.name + " делает переднее сальто");
            else
                System.out.println(this.name + " делает переднее сальто");
        } else {
            if (this.gender == 'f')
                System.out.println(this.name
                        + " смотрит на вас и непонимающе моргает. Может, вам стоит разучить с ней этот прием с помощью trainAnimal?");
            else
                System.out.println(this.name
                        + " смотрит на вас и непонимающе моргает. Может, вам стоит разучить с ним этот прием с помощью trainAnimal?");
        }
    }
}
