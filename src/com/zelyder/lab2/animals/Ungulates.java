package com.zelyder.lab2.animals;

import com.zelyder.lab2.aviarys.Aviary;
import com.zelyder.lab2.aviarys.OpenAviary;

public class Ungulates extends Animal{

    public Ungulates(double weight, int age) {
        super(weight, age);
    }

    @Override
    public String toString() {
        return "Копытное " + super.toString();
    }

    @Override
    public boolean move(Aviary aviary) {
        if (aviary instanceof OpenAviary && aviary.canAdd(this)) {
            System.out.println(this + " перевозят в новый открытый вальер");
            aviary.addAnimal(this);
            return true;
        } else {
            System.out.println("Копытное животное не возможно переместить в вальер типа " +
                    aviary.getClass().getSimpleName());
            return false;
        }
    }
}
