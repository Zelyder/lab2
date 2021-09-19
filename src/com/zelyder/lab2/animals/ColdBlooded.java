package com.zelyder.lab2.animals;

import com.zelyder.lab2.aviarys.Aviary;
import com.zelyder.lab2.aviarys.NightAviary;

public class ColdBlooded extends Animal {

    public ColdBlooded(float weight, int age) {
        super(weight, age);
    }

    @Override
    public String toString() {
        return "Хладнокровное " + super.toString();
    }

    @Override
    public void move(Aviary aviary) {
        if (aviary instanceof NightAviary) {
            System.out.println(this + " перевозят в новый вальер с инфракрасным освещением");
        } else {
            System.out.println("Хладнокровное животное не возможно переместить в вальер типа " +
                    aviary.getClass().getSimpleName());
        }
    }
}
