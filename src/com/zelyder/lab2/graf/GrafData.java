package com.zelyder.lab2.graf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GrafData {
/**
 * Класс содержит данные для построения графика
 */
	
	private String temp = "";
	private boolean Correct = false;
	private GrafDataTitle Title;
	/**
	 * Описание графика
	 */
	private Map <String, ArrayList> DataValues;
	/**
	 * Данные графика
	 */	
	
	GrafData() {
		this.Title = null;
		this.DataValues = null;
		this.Correct = false;
	}

	/**
	 * Создаем объект данных графика из описания и двух массивов
	 * @param Title
	 * @param X
	 * @param Y
	 */
	GrafData(GrafDataTitle Title, ArrayList <Float> X, ArrayList <Float> Y) {
		
		if( checkTitle(Title) && !X.isEmpty() && !Y.isEmpty() && X.size() == Y.size() ) {
			this.Title = Title;
			this.DataValues = new HashMap <String, ArrayList>();
			DataValues.put("X", X);
			DataValues.put("Y", Y);
			makeTitleFromDataArray();
			this.Correct = true;
		}
	}
	
	
	//------------------ set ------------------

	/**
	 * Проверяем переданное описание графика
	 * @param Title
	 * @return
	 */
	private boolean checkTitle(GrafDataTitle Title) {
		boolean Result = true;
			if(Title.getName().equals("") || Title.getName()==null) {
				Result = false;
			}
		return Result;
	}
	
	
	//------------------ get ------------------
	
	/**
	 * Возвращаем описание данных графика
	 * @return
	 */
	public GrafDataTitle getTitle() {
		return this.Title;
	}
	
	public ArrayList <Float> getGrafDataX() {
		return this.DataValues.get("X");
	}
	
	public ArrayList <Float> getGrafDataY() {
		return this.DataValues.get("Y");
	}
	
	public Map <String, ArrayList> getValues() {
		return this.DataValues;
	}
	
	
	
	//------------------ status ------------------
	
	boolean isCorrect() {
		return this.Correct;
	}
	
	
	
	//------------------ private ------------------
	
	/**
	 * Метод устанавливает максимальные и минимальные значения в title 
	 */
	private void makeTitleFromDataArray() {
		ArrayList <Float> X = this.DataValues.get("X");
		ArrayList <Float> Y = this.DataValues.get("Y");
		
		float min = X.get(0);
		float max = X.get(X.size()-1);
		
		for(float temp : X) {
			if( temp < min ) min = temp;
			if( temp > max ) max = temp;
		}
		
		this.Title.setMaxX(max);
		this.Title.setMinX(min);

		min = Y.get(0);
		max = Y.get(Y.size()-1);
		
		for(float temp : Y) {
			if( temp < min ) min = temp;
			if( temp > max ) max = temp;
		}		

		this.Title.setMaxY(max);
		this.Title.setMinY(min);		
	}
}
