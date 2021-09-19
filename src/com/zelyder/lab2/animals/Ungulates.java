package com.zelyder.lab2.animals;

import com.zelyder.lab2.aviarys.Aviary;
import com.zelyder.lab2.aviarys.OpenAviary;

public class Ungulates extends Animal{

    public Ungulates(float weight, int age) {
        super(weight, age);
    }

    @Override
    public String toString() {
        return "Копытное " + super.toString();
    }

    @Override
    public void move(Aviary aviary) {
        if (aviary instanceof OpenAviary) {
            System.out.println(this + " перевозят в новый открытый вальер");
        } else {
            System.out.println("Копытное животное не возможно переместить в вальер типа " +
                    aviary.getClass().getSimpleName());
        }
    }
}
