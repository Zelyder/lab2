package com.zelyder.lab2.aviarys;

import com.zelyder.lab2.animals.Animal;
import com.zelyder.lab2.animals.Ungulates;

import java.io.Serializable;

public class OpenAviary extends Aviary implements Serializable {
    public OpenAviary(){
        super();
    }
    public OpenAviary(int capacity){
        super(capacity);
    }

    @Override
    public boolean canAdd(Animal animal) {
        return super.canAdd(animal) && animal instanceof Ungulates;
    }
}
