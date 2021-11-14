package com.zelyder.lab2;

import com.sun.istack.internal.Nullable;
import com.zelyder.lab2.animals.Animal;
import com.zelyder.lab2.aviarys.Aviary;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Zoo implements Serializable {
    public final static String PATH_TO_DB = "zoo.db";

    public Zoo(TypeOfList type) {
        if (type == TypeOfList.ArrayList) {
            aviaries = new ArrayList<>();
        } else if (type == TypeOfList.LinkedList) {
            aviaries = new LinkedList<>();
        }
    }

    private List<Aviary> aviaries;

    public ArrayList<Aviary> getArrayListAviaries() {
        return new ArrayList<>(aviaries);
    }

    public LinkedList<Aviary> getLinkedListAviaries() {
        return new LinkedList<>(aviaries);
    }

    public void setAviaries(List<Aviary> aviaries) {
        this.aviaries = aviaries;
    }

    public void addAviary(Aviary aviary) {
        long start = System.currentTimeMillis();
        aviaries.add(aviary);
        long end = System.currentTimeMillis();
        int index = aviaries.size() -1;
        long time = end - start;
        Logger.info("add, index=" + index + " ,time=" + time);
    }

    public void removeAviary(Aviary aviary) {
        aviaries.remove(aviary);
    }

    public void removeAviaryByIndex(int index) {
        long start = System.currentTimeMillis();
        aviaries.remove(index);
        long end = System.currentTimeMillis();
        long time = end - start;
        Logger.info("remove, index=" + index + " ,time=" + time);
    }

    public List<Aviary> switchAviaryListType(TypeOfList type) {
        if (type == TypeOfList.ArrayList) {
            aviaries = getArrayListAviaries();
        } else if (type == TypeOfList.LinkedList) {
            aviaries = getLinkedListAviaries();
        }
        return aviaries;
    }

    public void addAnimal(Animal animal) {
        for (Aviary aviary : aviaries) {
            if (aviary.canAdd(animal)) {
                animal.move(aviary);
                Logger.info("Добавлено животное:" + animal);
                break;
            }
        }
    }

    public void addAnimals(List<Animal> animals) {
        for (Animal animal : animals) {
            addAnimal(animal);
        }
    }

    @Override
    public String toString() {
        if (aviaries.isEmpty()) {
            return "Зоопарк пуст";
        }
        StringBuilder builder = new StringBuilder();
        for (Aviary aviary : aviaries) {
            builder.append(aviary.toString());
            builder.append('\n');
        }
        return builder.toString();
    }

    public boolean saveToFile() {
        try {
            //создаем 2 потока для сериализации объекта и сохранения его в файл
            FileOutputStream fileOutputStream = new FileOutputStream(PATH_TO_DB);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // сохраняем zoo в файл
            objectOutputStream.writeObject(this);
            //закрываем поток и освобождаем ресурсы
            objectOutputStream.close();
            Logger.info("БД успешно сохранено в файл" + PATH_TO_DB);
            return true;
        } catch (IOException exception) {
            Logger.error(exception.getMessage());
            return false;
        }
    }

    @Nullable
    public static Zoo getFromFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream(PATH_TO_DB);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Zoo zooList = (Zoo) objectInputStream.readObject();
            objectInputStream.close();
            Logger.info("БД успешно загружена из файла " + PATH_TO_DB);
            return zooList;
        } catch (Exception exception) {
            Logger.error("Ошибка записи в файл");
            return null;
        }
    }

    enum TypeOfList {ArrayList, LinkedList}
}
