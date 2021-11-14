package com.zelyder.lab2;

import java.util.ArrayList;

public class ErrHandler {
    private static final ArrayList<Exception> ErrList = new ArrayList<>();

    //Добавляем ошибку в список ошибок
    public static int addErr(Exception e) {
        ErrList.add(e);
        return ErrList.size();
    }

    //Добавляем ошибку в список ошибок и в лог
    public static int addErrWithLog(Exception e) {
        ErrList.add(e);
        //Код записи сообщения в лог
        Logger.log(Logger.Type.ERROR, e.getMessage());
        return ErrList.size();
    }

    //Добавляем ошибку в список ошибок и в лог
    public static int addErrWithLog(Exception e, String message) {
        ErrList.add(e);
        //Код записи сообщения в лог
        Logger.log(Logger.Type.ERROR, e.getMessage() + "\n" + message);
        return ErrList.size();
    }

    //Получаем количество ошибок
    public static int getErrCount() {
        return ErrList.size();
    }

    //Выводим информацию об ошибке
    public static void showErrText(Exception e) {
        System.err.println(e.getMessage());
    }

    //Генерим (пробрасываем ошибку) с фиксацией в списке ошибок
    public static Exception makeErr(Exception e) {
        addErr(e);
        return new Exception(e);
    }


}
