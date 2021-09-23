package com.zelyder.lab2.aviarys;

import com.zelyder.lab2.animals.Animal;
import com.zelyder.lab2.animals.Feathered;

public class MeshAviary extends Aviary{
    public MeshAviary(){
        super();
    }
    public MeshAviary(int capacity){
        super(capacity);
    }
    @Override
    public boolean canAdd(Animal animal) {
        return super.canAdd(animal) &&  animal instanceof Feathered;
    }
}
