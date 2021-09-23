package com.zelyder.lab2.aviarys;

import com.zelyder.lab2.animals.Animal;
import com.zelyder.lab2.animals.Ungulates;

public class OpenAviary extends Aviary{
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
