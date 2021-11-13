package com.zelyder.lab2.aviarys;

import com.zelyder.lab2.animals.Animal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public abstract class Aviary implements Serializable {
    private final String id;
    private String name = "";
    private int capacity = 5;
    private ArrayList<Animal> animals = new ArrayList<>();

    public Aviary() {
        id = UUID.randomUUID().toString();
    }

    public Aviary(int capacity){
        this();
        this.capacity = capacity;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean addAnimal(Animal animal){
        if (canAdd(animal)) {
            animals.add(animal);
            capacity--;
            return true;
        }
        return false;
    }

    public void removeAnimal(Animal animal){
        animals.remove(animal);
        capacity++;
    }

    public void removeAnimal(String id){
        animals.removeIf(animal -> animal.getId().equals(id));
        capacity++;
    }

    public boolean canAdd(Animal animal){
        return capacity > 0;
    }

    @Override
    public String toString() {
        return "Вальер типа " + this.getClass().getSimpleName() +
                "{id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", animals=" + animals + "}";
    }
}
