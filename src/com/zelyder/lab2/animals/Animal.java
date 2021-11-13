package com.zelyder.lab2.animals;

import com.zelyder.lab2.aviarys.Aviary;

import java.io.Serializable;
import java.util.UUID;

public abstract class Animal implements Serializable {
    private final String id;
    private double weight = 0;
    private int age = 0;

    public Animal() {
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight >= 0) {
            this.weight = weight;
        } else {
            System.out.println("Вес не может быть отрицательным!");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Возраст не может быть отрицательным!");
        }
    }

    public Animal(double weight, int age) {
        this();
        setWeight(weight);
        setAge(age);
    }

    public abstract boolean move(Aviary aviary);

    @Override
    public String toString() {
        return "животное " +
                " весом " + (Math.ceil(weight * 100) / 100) +
                " кг и возрастом " + age + " месяцов \n" +
                "id = " + id;
    }
}
