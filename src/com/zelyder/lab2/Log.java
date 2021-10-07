package com.zelyder.lab2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Log {
    static void info(String message){
        try (FileWriter writer = new FileWriter("log.txt", true)){
            writer.append(getNowTime()).append(" - INFO: ").append(message).append('\n');
            writer.flush();
        }catch (IOException exception){
            Log.error(exception.getMessage());
        }
    }

    static void error(String errorMessage){
        try (FileWriter writer = new FileWriter("log.txt", true)){
            writer.append(getNowTime()).append(" - Error: ").append(errorMessage).append('\n');
            writer.flush();
        }catch (IOException exception){
            Log.error(exception.getMessage());
        }
    }

    static String getNowTime(){
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd ' время' hh:mm:ss a zzz");

        return formatForDateNow.format(dateNow);
    }
}
