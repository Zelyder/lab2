package com.zelyder.lab2.aviarys;

import com.zelyder.lab2.animals.Animal;
import com.zelyder.lab2.animals.Waterfowl;

public class Aquarium extends Aviary{

    public Aquarium(){
        super();
    }
    public Aquarium(int capacity){
        super(capacity);
    }

    @Override
    public boolean canAdd(Animal animal) {
        return super.canAdd(animal) && animal instanceof Waterfowl;
    }
}
