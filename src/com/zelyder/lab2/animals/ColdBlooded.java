package com.zelyder.lab2.animals;

import com.zelyder.lab2.aviarys.Aviary;
import com.zelyder.lab2.aviarys.NightAviary;

public class ColdBlooded extends Animal {

    public ColdBlooded(double weight, int age) {
        super(weight, age);
    }

    @Override
    public String toString() {
        return "Хладнокровное " + super.toString();
    }

    @Override
    public boolean move(Aviary aviary) {
        if (aviary instanceof NightAviary && aviary.canAdd(this)) {
            System.out.println(this + " перевозят в новый вальер с инфракрасным освещением");
            aviary.addAnimal(this);
            return true;
        } else {
            System.out.println("Хладнокровное животное не возможно переместить в вальер типа " +
                    aviary.getClass().getSimpleName());
            return false;
        }
    }
}
