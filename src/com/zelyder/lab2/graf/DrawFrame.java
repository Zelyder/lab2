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
		GrafDataTitle GTitle = new GrafDataTitle("Проверка", "", 0, 0, 0, 0, "ед", "нс");
		
		//Формируем данные для построения графика
		ArrayList <Float> X = new ArrayList();
		X.add(0F);
		X.add(10F);
		X.add(100F);
		X.add(1000F);
		X.add(10000F);

		ArrayList <Float> Y = new ArrayList();
		Y.add(0F);
		Y.add(2F);
		Y.add(4F);
		Y.add(9F);
		Y.add(16F);	
						
		DrawGraf DG = new DrawGraf(new GrafData(GTitle, X, Y), true, false, new Color(255, 0, 0));
		add(DG);
		pack();
	}

}