package com.zelyder.lab2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Logger {
    public static Boolean isLogging = true;
    static void log(Type type, String message) {
        if(isLogging){
            String typeName = "";
            if (type == Type.INFO){
                typeName = " - INFO: ";
            } else if (type == Type.ERROR){
                typeName = " - Error: ";
            }
            try (FileWriter writer = new FileWriter("log.txt", true)){
                writer.append(getNowTime()).append(typeName).append(message).append('\n');
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

    static String getNowTime(){
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd ' время' hh:mm:ss a zzz");

        return formatForDateNow.format(dateNow);
    }

    enum Type { INFO, ERROR }
}
