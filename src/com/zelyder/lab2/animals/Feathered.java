package com.zelyder.lab2.animals;

import com.zelyder.lab2.aviarys.Aviary;
import com.zelyder.lab2.aviarys.MeshAviary;

import java.io.Serializable;

public class Feathered extends Animal implements Serializable {

    public Feathered(double weight, int age) {
        super(weight, age);
    }

    @Override
    public String toString() {
        return "Пернатое " + super.toString();
    }

    @Override
    public boolean move(Aviary aviary) {
        if (aviary instanceof MeshAviary && aviary.canAdd(this)) {
            System.out.println(this + " перевозят в новый вальер покрытый сеткой");
            aviary.addAnimal(this);
            return true;

        } else {
            System.out.println("Пернатое животное не возможно переместить в вальер типа " +
                    aviary.getClass().getSimpleName());
            return false;
        }
    }
}
