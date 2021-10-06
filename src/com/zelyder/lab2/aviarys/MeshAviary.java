package com.zelyder.lab2.aviarys;

import com.zelyder.lab2.animals.Animal;
import com.zelyder.lab2.animals.Feathered;

import java.io.Serializable;

public class MeshAviary extends Aviary implements Serializable {
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
