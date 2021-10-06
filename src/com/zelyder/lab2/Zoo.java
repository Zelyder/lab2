package com.zelyder.lab2;

import com.sun.istack.internal.Nullable;
import com.zelyder.lab2.animals.Animal;
import com.zelyder.lab2.aviarys.Aviary;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Zoo implements Serializable {
    public final static String PATH_TO_DB = "zoo.db";
    public final static String PATH_TO_LOG = "log.txt";

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

    public boolean saveToFile(){
        try{
            //создаем 2 потока для сериализации объекта и сохранения его в файл
            FileOutputStream fileOutputStream = new FileOutputStream(PATH_TO_DB);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // сохраняем zoo в файл
            objectOutputStream.writeObject(this);
            //закрываем поток и освобождаем ресурсы
            objectOutputStream.close();
            return true;
        }catch (IOException exception){
            exception.printStackTrace();
            return false;
        }
    }

    @Nullable
    public static Zoo getFromFile(){
        try{
            FileInputStream fileInputStream = new FileInputStream(PATH_TO_DB);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Zoo zooList = (Zoo) objectInputStream.readObject();
            objectInputStream.close();
            return zooList;
        }catch (Exception exception){
            exception.printStackTrace();
            return null;
        }
    }
}
