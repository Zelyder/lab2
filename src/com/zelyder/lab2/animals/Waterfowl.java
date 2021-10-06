package com.zelyder.lab2.animals;

import com.zelyder.lab2.aviarys.Aquarium;
import com.zelyder.lab2.aviarys.Aviary;
import com.zelyder.lab2.aviarys.OpenAviary;

import java.io.Serializable;

public class Waterfowl extends Animal implements Serializable {

    public Waterfowl(double weight, int age) {
        super(weight, age);
    }

    @Override
    public String toString() {
        return "Водоплавающие " + super.toString();
    }

    @Override
    public boolean move(Aviary aviary) {
        if (aviary instanceof Aquarium && aviary.canAdd(this)) {
            System.out.println(this + " перевозят в новый акувариум");
            aviary.addAnimal(this);
            return true;
        } else {
            System.out.println("Водоплавающие животное не возможно переместить в вальер типа " +
                    aviary.getClass().getSimpleName());
            return false;
        }
    }
}
