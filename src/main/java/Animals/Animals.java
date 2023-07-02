package Animals;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Нужно создать несколько классов животных:
//        1. Пес (Собака)
//        2. Кот (Кошка)
//        3. ... придумать еще парочку
//
//        Каждое животное имеет: (поля)
//        1. Имя (кличка)
//        2. Возраст
//        3. ... придумать еще какие-то параметры
//
//        Каждое животное может: (методы)
//        1. Подавать голос
//        2. Питаться (съедает какое-то количество еды, переданное в метод)
//        3. Двигаться
//        4. ... все, что сумеете придумать
//
//        Нужно выделить базовый тип с общими атрибутами, инкапсулировать то, что является внутренним, внурь класса.
//        Создать массив с животными и в цикле заставить их поесть (какое-то количество еды) и заставить подать голос
public abstract class Animals {
    protected String name;
    protected String color;
    protected int old;
    protected double weight;
    protected int ID;
    protected double portion;
    private static int numberAnimals = 0;

    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
    public int getOld() {
        return old;
    }
    public double getWeight() { return weight; }

    public static int getNumberAnimals() { return numberAnimals; }
    public void setName(String name) { this.name = name; }
    public void setColor(String color) { this.color = color; }
    public void setOld(int old) { this.old = old; }
    public void setWeight(double weight) { this.weight = weight; }


    protected Animals(String name,String color, int old, double weight) {
        numberAnimals++;
        this.ID = numberAnimals;
        this.name = name;
        this.color = color;
        this.old = old;
        this.weight = weight;

    }

    protected Animals(String name,String color, int old) {
        this(name,color,old,-1);
    }
    protected Animals(String name,String color) {
        this(name,color,-1,-1);
    }

    protected Animals(String name) {
        this(name,"Не определен",-1,-1);
    }

    @Override
    public String toString() {
        return "Звери{" +
                this.getClass().getName().toString() +
                " ID = " + ID +
                ", name = '" + name + '\'' +
                ", color = '" + color + '\'' +
                ", old = " + old +
                ", weight = " + weight +
                '}';
    }

    public abstract String getVoice();
    public abstract String getPlay();
    public abstract String getMoving();

    protected abstract double getEat(double eat);
}
