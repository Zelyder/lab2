package com.zelyder.lab2.graf;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;


/**
 * A frame that contains a panel with drawings
 */
public class DrawFrame extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public DrawFrame(ArrayList<Float> Y1, ArrayList<Float> Y2) {

        //Формируем заголовок-описание графика
        GrafDataTitle GTitle1 = new GrafDataTitle(
                " ",
                "",
                0,
                0,
                0,
                0,
                "size",
                "time"
        );
//        GrafDataTitle GTitle2 = new GrafDataTitle(
//                "LinkedList",
//                "",
//                0,
//                0,
//                0,
//                0,
//                "size",
//                "time"
//        );


		ArrayList <Float> X = new ArrayList<>();
		X.add(0F);
		X.add(10F);
		X.add(100F);
		X.add(1000F);
		X.add(10000F);
		X.add(100000F);
        DrawGraf Dg1;
        DrawGraf Dg2;

        if(getMax(Y1) < getMax(Y2)){
            Dg1 = new DrawGraf(new GrafData(GTitle1, X, Y1), true, false, new Color(255, 0, 0));
            Dg2 = new DrawGraf(new GrafData(GTitle1, X, Y2), true, false, new Color(0, 255, 0));

        } else {
            Dg2 = new DrawGraf(new GrafData(GTitle1, X, Y2), true, false, new Color(0, 255, 0));
            Dg1 = new DrawGraf(new GrafData(GTitle1, X, Y1), true, false, new Color(255, 0, 0));
        }
        add(Dg1);
        pack();
        add(Dg2);
        pack();
    }

    private float getMax(ArrayList<Float> arrayList){
        float max = arrayList.get(0);
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i) > max) {
                max = arrayList.get(i);
            }
        }
        return max;
    }

}