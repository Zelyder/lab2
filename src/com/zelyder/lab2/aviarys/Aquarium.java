package com.zelyder.lab2.aviarys;

import com.zelyder.lab2.animals.Animal;
import com.zelyder.lab2.animals.Waterfowl;

import java.io.Serializable;

public class Aquarium extends Aviary implements Serializable {

    public Aquarium(){
        super();
        type = Type.Aquarium;
    }
    public Aquarium(int capacity){
        super(capacity);
    }

    @Override
    public boolean canAdd(Animal animal) {
        return super.canAdd(animal) && animal instanceof Waterfowl;
    }
}
