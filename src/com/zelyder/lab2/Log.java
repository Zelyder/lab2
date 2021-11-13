package com.zelyder.lab2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Log {
    public static Boolean isLogging = true;
    static void log(String message, Type type) {
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
                Log.error(exception.getMessage());
            }
        }
    }

    static void info(String message){
        log(message, Type.INFO);
    }

    static void error(String errorMessage){
        log(errorMessage, Type.ERROR);
    }

    static String getNowTime(){
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd ' время' hh:mm:ss a zzz");

        return formatForDateNow.format(dateNow);
    }

    enum Type { INFO, ERROR }
}
