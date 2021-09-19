package com.zelyder.lab2;

import com.zelyder.lab2.animals.ColdBlooded;
import com.zelyder.lab2.animals.Feathered;
import com.zelyder.lab2.animals.Ungulates;
import com.zelyder.lab2.animals.Waterfowl;
import com.zelyder.lab2.aviarys.Aquarium;
import com.zelyder.lab2.aviarys.MeshAviary;
import com.zelyder.lab2.aviarys.NightAviary;
import com.zelyder.lab2.aviarys.OpenAviary;

/**
 * Вариант 6
 * @author Андрей Корощупов
 * @version 1.0
 */
public class Main {

    /**
     * Точка входа в программу
     * @param args аргументы косандной строки
     */
    public static void main(String[] args) {

        // Иницилизация вальеров
        Aquarium aquarium = new Aquarium();
        MeshAviary meshAviary = new MeshAviary();
        NightAviary nightAviary = new NightAviary();
        OpenAviary openAviary = new OpenAviary();

        // Инициализация животных
        Waterfowl fish = new Waterfowl(1.5f, 1);
        Feathered bird = new Feathered(0.5f, 3);
        ColdBlooded snake = new ColdBlooded(3, 5);
        Ungulates bull = new Ungulates(450, 4);

        // Перемещаем животных в соответсвующие вальеры
        fish.move(aquarium);
        bird.move(meshAviary);
        snake.move(nightAviary);
        bull.move(openAviary);

        // Проверим, что мы не можем поместить животное в не подходящий вальер
        bird.move(aquarium);

    }
}
