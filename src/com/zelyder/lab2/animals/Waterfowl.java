package com.zelyder.lab2.animals;

import com.zelyder.lab2.aviarys.Aquarium;
import com.zelyder.lab2.aviarys.Aviary;
import com.zelyder.lab2.aviarys.OpenAviary;

public class Waterfowl extends Animal{

    public Waterfowl(float weight, int age) {
        super(weight, age);
    }

    @Override
    public String toString() {
        return "Водоплавающие " + super.toString();
    }

    @Override
    public void move(Aviary aviary) {
        if (aviary instanceof Aquarium) {
            System.out.println(this + " перевозят в новый акувариум");
        } else {
            System.out.println("Водоплавающие животное не возможно переместить в вальер типа " +
                    aviary.getClass().getSimpleName());
        }
    }
}
