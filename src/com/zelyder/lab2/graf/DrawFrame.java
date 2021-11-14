package com.zelyder.lab2.graf;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;


/**
 * A frame that contains a panel with drawings
 */
public class DrawFrame extends JFrame
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DrawFrame() {
		
		//Формируем заголовок-описание графика
		GrafDataTitle GTitle = new GrafDataTitle("Проверка", "", 0, 0, 0, 0, "size", "time");
		
		//Формируем данные для построения графика суммарного времени добавления для ArrayList
		ArrayList <Float> X1 = new ArrayList<>();
		X1.add(0F);
		X1.add(10F);
		X1.add(100F);
		X1.add(1000F);
		X1.add(10000F);
		X1.add(100000F);

		ArrayList <Float> Y1 = new ArrayList<>();
		Y1.add(0F);
		Y1.add(17000F);
		Y1.add(108300F);
		Y1.add(633100F);
		Y1.add(1840500F);
		Y1.add(12326100F);

		//Формируем данные для построения графика суммарного времени добавления для LinkedList
		ArrayList <Float> X2 = new ArrayList<>();
		X2.add(0F);
		X2.add(10F);
		X2.add(100F);
		X2.add(1000F);
		X2.add(10000F);
		X2.add(100000F);

		ArrayList <Float> Y2 = new ArrayList<>();
		Y2.add(0F);
		Y2.add(31500F);
		Y2.add(254200F);
		Y2.add(713000F);
		Y2.add(1915800F);
		Y2.add(7634300F);

		//Формируем данные для построения графика среднего времени добавления для ArrayList
		ArrayList <Float> X3 = new ArrayList<>();
		X3.add(0F);
		X3.add(10F);
		X3.add(100F);
		X3.add(1000F);
		X3.add(10000F);
		X3.add(100000F);

		ArrayList <Float> Y3 = new ArrayList<>();
		Y3.add(0F);
		Y3.add(1700F);
		Y3.add(1083F);
		Y3.add(633F);
		Y3.add(184F);
		Y3.add(123F);

		//Формируем данные для построения графика среднего времени добавления для LinkedList
		ArrayList <Float> X4 = new ArrayList<>();
		X4.add(0F);
		X4.add(10F);
		X4.add(100F);
		X4.add(1000F);
		X4.add(10000F);
		X4.add(100000F);

		ArrayList <Float> Y4 = new ArrayList<>();
		Y4.add(0F);
		Y4.add(3150F);
		Y4.add(2542F);
		Y4.add(713F);
		Y4.add(191F);
		Y4.add(76F);


		// Remove ----------------------------------------------------------------------------------------------------

		//Формируем данные для построения графика суммарного времени удаления для ArrayList
		ArrayList <Float> X5 = new ArrayList<>();
		X5.add(0F);
		X5.add(10F);
		X5.add(100F);
		X5.add(1000F);
		X5.add(10000F);
		X5.add(100000F);

		ArrayList <Float> Y5 = new ArrayList<>();
		Y5.add(0F);
		Y5.add(7100F);
		Y5.add(76000F);
		Y5.add(334100F);
		Y5.add(2205200F);
		Y5.add(88202300F);

		//Формируем данные для построения графика суммарного времени удаления для LinkedList
		ArrayList <Float> X6 = new ArrayList<>();
		X6.add(0F);
		X6.add(10F);
		X6.add(100F);
		X6.add(1000F);
		X6.add(10000F);
		X6.add(100000F);

		ArrayList <Float> Y6 = new ArrayList<>();
		Y6.add(0F);
		Y6.add(22200F);
		Y6.add(77600F);
		Y6.add(4794200F);
		Y6.add(86354700F);
		Y6.add(17853024900F);

		//Формируем данные для построения графика среднего времени удаления для ArrayList
		ArrayList <Float> X7 = new ArrayList<>();
		X7.add(0F);
		X7.add(10F);
		X7.add(100F);
		X7.add(1000F);
		X7.add(10000F);
		X7.add(100000F);

		ArrayList <Float> Y7 = new ArrayList<>();
		Y7.add(0F);
		Y7.add(7100F);
		Y7.add(7600F);
		Y7.add(3341F);
		Y7.add(2205F);
		Y7.add(8820F);

		//Формируем данные для построения графика среднего времени удаления для LinkedList
		ArrayList <Float> X8 = new ArrayList<>();
		X8.add(0F);
		X8.add(10F);
		X8.add(100F);
		X8.add(1000F);
		X8.add(10000F);
		X8.add(100000F);

		ArrayList <Float> Y8 = new ArrayList<>();
		Y8.add(0F);
		Y8.add(22200F);
		Y8.add(7760F);
		Y8.add(47942F);
		Y8.add(86354F);
		Y8.add(1785302F);

		//Total add time
		DrawGraf DgAddArrayListTotal = new DrawGraf(new GrafData(GTitle, X1, Y1), true, false, new Color(255, 0, 0));
		DrawGraf DgAddLinkedListTotal = new DrawGraf(new GrafData(GTitle, X2, Y2), true, false, new Color(0, 255, 0));

		// Average add time
		DrawGraf DgAddArrayListAverage = new DrawGraf(new GrafData(GTitle, X3, Y3), true, false, new Color(255, 0, 0));
		DrawGraf DgAddLinkedListAverage = new DrawGraf(new GrafData(GTitle, X4, Y4), true, false, new Color(0, 255, 0));


		//Total remove time
		DrawGraf DgRemoveArrayListTotal = new DrawGraf(new GrafData(GTitle, X5, Y5), true, false, new Color(255, 0, 0));
		DrawGraf DgRemoveLinkedListTotal = new DrawGraf(new GrafData(GTitle, X6, Y6), true, false, new Color(0, 255, 0));

		// Average remove time
		DrawGraf DgRemoveArrayListAverage = new DrawGraf(new GrafData(GTitle, X7, Y7), true, false, new Color(255, 0, 0));
		DrawGraf DgRemoveLinkedListAverage = new DrawGraf(new GrafData(GTitle, X8, Y8), true, false, new Color(0, 255, 0));

		add(DgRemoveArrayListAverage);
		pack();
		add(DgRemoveLinkedListAverage);
		pack();
	}

}