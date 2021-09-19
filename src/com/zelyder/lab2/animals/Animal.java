package com.zelyder.lab2.animals;

import com.zelyder.lab2.aviarys.Aviary;

public abstract class Animal {
    private float weight = 0;
    private int age = 0;

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
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

    public Animal(float weight, int age) {
        setWeight(weight);
        setAge(age);
    }

    public abstract void move(Aviary aviary);

    @Override
    public String toString() {
        return "животное " +
                "весом " + weight +
                " кг и возрастом " + age;
    }
}
