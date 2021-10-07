package com.zelyder.lab2;

import com.zelyder.lab2.animals.*;
import com.zelyder.lab2.aviarys.Aquarium;
import com.zelyder.lab2.aviarys.MeshAviary;
import com.zelyder.lab2.aviarys.NightAviary;
import com.zelyder.lab2.aviarys.OpenAviary;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Вариант 6
 *
 * @author Андрей Корощупов
 * @version 1.0
 */
public class Main {

    /**
     * Точка входа в программу
     * Управление
     * 0) Выход
     * 1) Показать весь зоопарк
     * 2) Добавить случайное животное в зоопарк
     * 3) Загрузить БД из файла
     * 4) Сохранить БД в файл
     *
     * @param args аргументы косандной строки
     */

    public static void main(String[] args) {

        // Инициализация зоопарка
        Zoo zoo = initZoo();

        // Загрузка настроек
        Settings settings = initSettings();
        if (settings != null){
            System.out.println("Добро пожаловать " + settings.login);
            System.out.println("Запись в лог:" + settings.writeLog);
            Log.info("Страт программы под логином " + settings.login);
        }else {
            System.out.println("Ошибка инициализации настроек");
        }



        // Вывод на экран главного меню
        printMenu();
        // Обработка действий пользователя
        handleInputMenu(zoo);
    }

    private static void printMenu() {
        System.out.println(
                "0) Выход \n1) Показать весь зоопарк \n2) Добавить случайное животное в зоопарк \n3) Загрузить БД из файла \n4) Сохранить БД в файл"
        );
    }

    private static void handleInputMenu(Zoo zoo) {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                switch (sc.nextInt()) {
                    case 0:
                        Log.info("Выход из программы");
                        return;
                    case 1:
                        if (zoo != null) {
                            System.out.println(zoo);
                        } else {
                            System.out.println("Zoo не инициализирован!");
                            Log.error("Zoo не инициализирован!");
                        }
                        break;
                    case 2:
                        if (zoo != null) {
                            zoo.addAnimal(randomAnimal());
                        } else {
                            System.out.println("Zoo не инициализирован!");
                            Log.error("Zoo не инициализирован!");
                        }
                        break;
                    case 3:
                        if (Zoo.getFromFile() != null) {
                            zoo = Zoo.getFromFile();
                            System.out.println("Файл успешно загружен!");
                        } else {
                            System.out.println("Ошибка загрузки! Проверьте наличие файла " + Zoo.PATH_TO_DB);
                        }
                        break;
                    case 4:
                        if (zoo != null) {
                            if (zoo.saveToFile()) {
                                System.out.println("БД успешно сохранена в файл " + Zoo.PATH_TO_DB);
                            } else {
                                System.out.println("Ошибка Сохранения файла!");
                            }
                        }

                        break;
                    default:
                        System.out.println("Введина не существующая команда!\nИспользуйте одну из этих команд:");
                }
                printMenu();
            } catch (Exception ex) {
                System.out.println("Ошибка ввода!\nИспользуйте одну из этих команд:");
                Log.error("Ошибка ввода!");
                printMenu();
            }
        }
    }

    private static Animal randomAnimal() {
        Animal animal;
        switch (getRandomIntegerBetweenRange(1, 4)) {
            case 1:
                animal = new ColdBlooded(getRandomDoubleBetweenRange(0.1, 10), getRandomIntegerBetweenRange(1, 10));
                break;
            case 2:
                animal = new Feathered(getRandomDoubleBetweenRange(0.5, 5), getRandomIntegerBetweenRange(1, 10));
                break;
            case 3:
                animal = new Ungulates(getRandomDoubleBetweenRange(1, 500), getRandomIntegerBetweenRange(1, 20));
                break;
            case 4:
                animal = new Waterfowl(getRandomDoubleBetweenRange(0.1, 20), getRandomIntegerBetweenRange(1, 10));
                break;
            default:
                throw new IllegalStateException("Unexpected value");
        }
        return animal;
    }

    private static Zoo initZoo() {
        // Иницилизация вальеров
        Aquarium aquarium = new Aquarium();
        MeshAviary meshAviary = new MeshAviary();
        NightAviary nightAviary = new NightAviary();
        OpenAviary openAviary = new OpenAviary();

        Zoo zoo = new Zoo();
        zoo.addAviary(aquarium);
        zoo.addAviary(meshAviary);
        zoo.addAviary(nightAviary);
        zoo.addAviary(openAviary);
        return zoo;
    }

    private static @Nullable Settings initSettings() {
        if (Settings.getFromFile() == null){
            try {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Введите логин: ");
                String login = scanner.next();

                boolean writeLog = false;
                System.out.println("Записывать ли логи?\nВведите да или нет:");
                boolean correctInput = false;
                while (!correctInput){
                    switch (scanner.next().trim().toLowerCase(Locale.ROOT)){
                        case "да":
                            writeLog = true;
                            correctInput = true;
                            break;
                        case "нет":
                            correctInput = true;
                            break;
                        default:
                            System.out.println("Неверный ввод!\nВведите да или нет:");
                    }
                }
                Settings settings = new Settings(login, writeLog);
                settings.saveToFile();
                return settings;
            }catch (Exception exception){
                Log.error(exception.getMessage());
                return null;
            }
        }
        else {
            return Settings.getFromFile();
        }
    }

    public static int getRandomIntegerBetweenRange(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }

    public static double getRandomDoubleBetweenRange(double min, double max) {
        return (Math.random() * ((max - min) + 1)) + min;
    }
}
