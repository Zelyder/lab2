package com.zelyder.lab2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Logger {
    public static Boolean isLogging = true;

    public static long getTotalAddTime() {
        return totalAddTime;
    }

    public static long getTotalRemoveTime() {
        return totalRemoveTime;
    }

    private static long totalAddTime = 0;
    private static long countAdd = 0;
    private static long totalRemoveTime = 0;
    private static long countRemove = 0;
    static void log(Type type, String message) {
        if(isLogging){
            try (FileWriter writer = new FileWriter("log.txt", true)){
                writer
                        .append(getNowTime())
                        .append(" - ")
                        .append(type.name)
                        .append(": ")
                        .append(message)
                        .append('\n');
                writer.flush();
            }catch (IOException exception){
                System.err.println(exception.getMessage());
            }
        }
    }

    static void info(String message){
        log(Type.INFO, message);
    }

    static void error(String errorMessage){
        log(Type.ERROR, errorMessage);
    }

    static void add(int index, long time) {
        log(Type.ADD, "index=" + index + " ,time=" + time);
        totalAddTime += time;
        countAdd += 1;
    }

    static void remove(int index, long time) {
        log(Type.REMOVE, "index=" + index + " ,time=" + time);
        totalRemoveTime += time;
        countRemove += 1;
    }

    static void resetAddTime() {
        totalAddTime = 0;
        countAdd = 0;
    }

    static void resetRemoveTime() {
        totalRemoveTime = 0;
        countRemove = 0;
    }

    static void resetTime() {
        resetAddTime();
        resetRemoveTime();
    }

    static long getAverageAddTime() {
        if (countAdd != 0){
            return totalAddTime / countAdd;
        }
        return 0;
    }

    static long getAverageRemoveTime() {
        if (countAdd != 0){
            return totalRemoveTime / countRemove;
        }
        return 0;
    }

    static String getNowTime(){
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd ' время' hh:mm:ss a zzz");

        return formatForDateNow.format(dateNow);
    }

    enum Type { INFO("INFO"), ERROR("ERROR"), ADD("ADD"), REMOVE("REMOVE");
        public String name;
        Type(String val) {
            name = val;
        }
    }
}
