package com.zelyder.lab2;

import com.zelyder.lab2.animals.*;
import com.zelyder.lab2.aviarys.*;
import com.zelyder.lab2.graf.DrawFrame;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Writer;
import java.util.*;
import java.util.List;

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
     * 2) Удалить вальер по индексу
     * 3) Добавить случайное животное в зоопарк
     * 4) Загрузить БД из файла
     * 5) Сохранить БД в файл
     *
     * @param args аргументы косандной строки
     */

    public static void main(String[] args) {
        startUI();
    }

    private static void startUI() {
        {
            EventQueue.invokeLater(() -> {
                //Формируем данные для построения графика суммарного времени добавления для ArrayList (красный)
                //Формируем данные для построения графика суммарного времени добавления для LinkedList (Зеленый)

                drawGraf("Суммарное время добавления",
                        Arrays.asList(
                                0F,
                                17000F,
                                108300F,
                                633100F,
                                1840500F,
                                12326100F
                        ),
                        Arrays.asList(
                                0F,
                                31500F,
                                254200F,
                                713000F,
                                1915800F,
                                7634300F
                        )
                );
                drawGraf("среднее время добавления",
                        Arrays.asList(
                                0F,
                                1700F,
                                1083F,
                                633F,
                                184F,
                                123F
                        ),
                        Arrays.asList(
                                0F,
                                3150F,
                                2542F,
                                713F,
                                191F,
                                76F
                        )
                );
                drawGraf("Суммарное временя удаления",
                        Arrays.asList(
                                0F,
                                7100F,
                                76000F,
                                334100F,
                                2205200F,
                                88202300F
                        ),
                        Arrays.asList(
                                0F,
                                22200F,
                                77600F,
                                4794200F,
                                86354700F,
                                17853024900F
                        )
                );
                drawGraf("Среднее временя удаления",
                        Arrays.asList(
                                0F,
                                7100F,
                                7600F,
                                3341F,
                                2205F,
                                8820F
                        ),
                        Arrays.asList(
                                0F,
                                22200F,
                                7760F,
                                47942F,
                                86354F,
                                1785302F
                        )
                );
            });
        }
    }

    private static void drawGraf(String title, List<Float> Y1, List<Float> Y2) {
        JFrame frame = new DrawFrame(new ArrayList(Y1), new ArrayList(Y2));
        frame.setTitle(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void launchApp() {
        // Инициализация зоопарка
        Zoo zoo = initZoo();

        // Загрузка настроек
        Settings settings = initSettings();
        if (settings != null) {
            System.out.println("Добро пожаловать " + settings.login);
            System.out.println("Запись в лог:" + settings.writeLog);
            Logger.info("Страт программы под логином " + settings.login);
        } else {
            System.out.println("Ошибка инициализации настроек");
        }
        // Вывод на экран главного меню
        printMenu();
        // Обработка действий пользователя
        handleInputMenu(zoo);
        // Если были ошибки, то выводим их количество
        int countOfErrors = ErrHandler.getErrCount();
        if (countOfErrors != 0) {
            System.out.println("Количество ошибок: " + countOfErrors);
        }
    }

    private static void testLists(int countOfElements) {
        Zoo arrayZoo = new Zoo(Zoo.TypeOfList.ArrayList);
        Zoo linkedZoo = new Zoo(Zoo.TypeOfList.LinkedList);
        String result;

//        Logger.info("ArrayList");
//        System.out.println("ArrayList");
//        result = testList(arrayZoo, countOfElements);
//        System.out.println(result);
//        Logger.info("\n" + result);
//
//        System.out.println();
//        Logger.resetTime();

        Logger.info("LinkedList");
        System.out.println("LinkedList");
        result = testList(linkedZoo, countOfElements);
        System.out.println(result);
        Logger.info("\n" + result);

    }

    private static String testList(Zoo zoo, int countOfElements) {
        // Добовляем вальеры и заполняем их случайными животными
        for (int i = 0; i < countOfElements; i++) {
            Aviary aviary = randomAviary(100);
            fillAviary(aviary);
            zoo.addAviary(aviary);
        }
        // удаляем 10 % случайных элементов в списке
        for (int i = 0; i < countOfElements * 0.1; i++) {
            zoo.removeAviaryByIndex(
                    getRandomIntegerBetweenRange(
                            0,
                            zoo.getAviaries().size() - 1
                    )
            );
        }
        return "Add: Total time = " + Logger.getTotalAddTime() + ", Average time = " + Logger.getAverageAddTime() +
                "\nRemove: Total time = " + Logger.getTotalRemoveTime() + ", Average time = " +
                Logger.getAverageRemoveTime();
    }

    private static void printMenu() {
        System.out.println(
                "0) Выход \n1) Показать весь зоопарк \n2) Удалить вальер по индексу \n" +
                        "3) Добавить случайное животное в зоопарк\n4) Загрузить БД из файла \n5) Сохранить БД в файл"
        );
    }

    private static void handleInputMenu(Zoo zoo) {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                switch (sc.nextInt()) {
                    case 0:
                        Logger.info("Выход из программы");
                        return;
                    case 1:
                        if (isZooNoNull(zoo)) {
                            System.out.println(zoo);
                        }
                        break;
                    case 2:
                        if (isZooNoNull(zoo)) {
                            System.out.println("Введите индекс вальера, из который хотите удалить животное");
                            int index = sc.nextInt();
                            zoo.removeAviaryByIndex(index);
                        }
                        break;
                    case 3:
                        if (isZooNoNull(zoo)) {
                            Objects.requireNonNull(zoo).addAnimal(randomAnimal(Aviary.Type.Null));
                        }
                        break;
                    case 4:
                        if (Zoo.getFromFile() != null) {
                            zoo = Zoo.getFromFile();
                            System.out.println("Файл успешно загружен!");
                        } else {
                            System.out.println("Ошибка загрузки! Проверьте наличие файла " + Zoo.PATH_TO_DB);
                        }
                        break;
                    case 5:
                        if (isZooNoNull(zoo)) {
                            if (zoo.saveToFile()) {
                                System.out.println("БД успешно сохранена в файл " + Zoo.PATH_TO_DB);
                            } else {
                                System.out.println("Ошибка Сохранения файла!");
                            }
                        }
                    default:
                        System.out.println("Введина не существующая команда!\nИспользуйте одну из этих команд:");
                }
                printMenu();
            } catch (Exception ex) {
                System.out.println("Ошибка ввода!\nИспользуйте одну из этих команд:");
                ErrHandler.addErrWithLog(ex, "Ошибка ввода!");
                printMenu();
            }
        }
    }

    private static Aviary randomAviary(int capacity) {
        Aviary aviary;
        switch (getRandomIntegerBetweenRange(1, 4)) {
            case 1:
                aviary = new Aquarium(capacity);
                break;
            case 2:
                aviary = new MeshAviary(capacity);
                break;
            case 3:
                aviary = new NightAviary(capacity);
                break;
            case 4:
                aviary = new OpenAviary(capacity);
                break;
            default:
                throw new IllegalStateException("Unexpected value");
        }
        return aviary;
    }

    private static Animal randomAnimal(Aviary.Type type) {
        Animal animal;
        int animalInt = type.value;
        if (type == Aviary.Type.Null) {
            animalInt = getRandomIntegerBetweenRange(1, 4);
        }
        switch (animalInt) {
            case 1:
                animal = new Waterfowl(getRandomDoubleBetweenRange(0.1, 20), getRandomIntegerBetweenRange(1, 10));
                break;
            case 2:
                animal = new Feathered(getRandomDoubleBetweenRange(0.5, 5), getRandomIntegerBetweenRange(1, 10));
                break;
            case 3:
                animal = new ColdBlooded(getRandomDoubleBetweenRange(0.1, 10), getRandomIntegerBetweenRange(1, 10));
                break;
            case 4:
                animal = new Ungulates(getRandomDoubleBetweenRange(1, 500), getRandomIntegerBetweenRange(1, 20));
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

        Zoo zoo = new Zoo(Zoo.TypeOfList.ArrayList);
        zoo.addAviary(aquarium);
        zoo.addAviary(meshAviary);
        zoo.addAviary(nightAviary);
        zoo.addAviary(openAviary);
        return zoo;
    }

    private static void fillAviary(@NotNull Aviary aviary) {
        for (int i = 0; i < aviary.getCapacity(); i++) {
            aviary.addAnimal(randomAnimal(aviary.getType()));
        }
    }

    private static @Nullable Settings initSettings() {
        if (Settings.getFromFile() == null) {
            try {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Введите логин: ");
                String login = scanner.next();

                boolean writeLog = false;
                System.out.println("Записывать ли логи?\nВведите да или нет:");
                boolean correctInput = false;
                while (!correctInput) {
                    switch (scanner.next().trim().toLowerCase(Locale.ROOT)) {
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
                Logger.isLogging = writeLog;
                Settings settings = new Settings(login, writeLog);
                settings.saveToFile();
                return settings;
            } catch (Exception exception) {
                ErrHandler.addErrWithLog(exception);
                return null;
            }
        } else {
            return Settings.getFromFile();
        }
    }

    public static int getRandomIntegerBetweenRange(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }

    public static double getRandomDoubleBetweenRange(double min, double max) {
        return (Math.random() * ((max - min) + 1)) + min;
    }


    private static boolean isZooNoNull(@Nullable Zoo zoo) {
        if (zoo != null) {
            return true;
        } else {
            System.out.println("Zoo не инициализирован!");
            Logger.error("Zoo не инициализирован!");
        }
        return false;
    }
}
