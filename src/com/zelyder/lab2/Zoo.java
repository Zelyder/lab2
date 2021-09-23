package com.zelyder.lab2;

import com.zelyder.lab2.animals.Animal;
import com.zelyder.lab2.aviarys.Aviary;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private ArrayList<Aviary> aviaries = new ArrayList<>();

    public ArrayList<Aviary> getAviaries() {
        return aviaries;
    }

    public void setAviaries(ArrayList<Aviary> aviaries) {
        this.aviaries = aviaries;
    }

    public void addAviary(Aviary aviary){
        aviaries.add(aviary);
    }

    public void removeAviary(Aviary aviary) {
        aviaries.remove(aviary);
    }

    public void addAnimal(Animal animal) {
        for (Aviary aviary: aviaries) {
            if (aviary.canAdd(animal)) {
                animal.move(aviary);
                break;
            }
        }
    }

    public void addAnimals(ArrayList<Animal> animals){
        for (Animal animal: animals) {
            addAnimal(animal);
        }
    }

    @Override
    public String toString() {
        if (aviaries.isEmpty()){
            return "Зоопарк пуст";
        }
        StringBuilder builder = new StringBuilder();
        for (Aviary aviary :aviaries){
            builder.append(aviary.toString());
            builder.append('\n');
        }
        return builder.toString();
    }
}
