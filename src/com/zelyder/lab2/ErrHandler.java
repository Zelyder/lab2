package com.zelyder.lab2;

import java.util.ArrayList;

public class ErrHandler {
    private static ArrayList<Exception> ErrList;

    public ErrHandler() {
        ErrList = new ArrayList<>();
    }

    //Добавляем ошибку в список ошибок
    public int addErr(Exception e) {
        ErrList.add(e);
        return ErrList.size();
    }

    //Добавляем ошибку в список ошибок и в лог
    public int addErrWithLog(Exception e) {
        ErrList.add(e);
        //Код записи сообщения в лог
        Logger.log(Logger.Type.INFO, e.getMessage());
        return ErrList.size();
    }

    //Получаем количество ошибок
    public int getErrCount() {
        return ErrList.size();
    }

    //Выводим информацию об ошибке
    public void showErrText(Exception e) {
        System.err.println(e.getMessage());
    }

    //Генерим (пробрасываем ошибку) с фиксацией в списке ошибок
    public Exception makeErr(Exception e) {
        addErr(e);
        return new Exception(e);
    }


}
