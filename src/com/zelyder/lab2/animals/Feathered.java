package com.zelyder.lab2.animals;

import com.zelyder.lab2.aviarys.Aviary;
import com.zelyder.lab2.aviarys.MeshAviary;

public class Feathered extends Animal{

    public Feathered(float weight, int age) {
        super(weight, age);
    }

    @Override
    public String toString() {
        return "Пернатое " + super.toString();
    }

    @Override
    public void move(Aviary aviary) {
        if (aviary instanceof MeshAviary) {
            System.out.println(this + " перевозят в новый вальер покрытый сеткой");
        } else {
            System.out.println("Пернатое животное не возможно переместить в вальер типа " +
                    aviary.getClass().getSimpleName());
        }
    }
}
