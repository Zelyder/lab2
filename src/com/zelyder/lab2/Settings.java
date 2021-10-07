package com.zelyder.lab2;

import com.sun.istack.internal.Nullable;

import java.io.*;

public class Settings implements Serializable {
    public final static String PATH_TO_SETTINGS = "Settings.bin";
    public String login;
    public boolean writeLog;

    public Settings() {
        login = null;
        writeLog = false;
    }
    public Settings(String login, boolean writeLog){
        this.login = login;
        this.writeLog = writeLog;
    }

    public boolean saveToFile(){
        try{
            //создаем 2 потока для сериализации объекта и сохранения его в файл
            FileOutputStream fileOutputStream = new FileOutputStream(PATH_TO_SETTINGS);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // сохраняем настройки в файл
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
    public static Settings getFromFile(){
        try{
            FileInputStream fileInputStream = new FileInputStream(PATH_TO_SETTINGS);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Settings settings = (Settings) objectInputStream.readObject();
            objectInputStream.close();
            return settings;
        }catch (Exception exception){
            exception.printStackTrace();
            return null;
        }
    }
}
