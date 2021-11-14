package com.zelyder.lab2.aviarys;

import com.zelyder.lab2.animals.Animal;
import com.zelyder.lab2.animals.ColdBlooded;

import java.io.Serializable;

public class NightAviary extends Aviary implements Serializable {
    public NightAviary(){
        super();
        type = Type.Night;
    }
    public NightAviary(int capacity){
        super(capacity);
    }

    @Override
    public boolean canAdd(Animal animal) {
        return super.canAdd(animal) && animal instanceof ColdBlooded;
    }
}
