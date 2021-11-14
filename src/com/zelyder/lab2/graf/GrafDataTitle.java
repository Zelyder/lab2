package com.zelyder.lab2.graf;

public class GrafDataTitle {
/**
 * Класс для описания параметров графика, кроме пар данных для x и Y
 */
	
	/**
	 * Назваие графика
	 */
	private String Name = "";

	/**
	 * Описание графика
	 */
	private String Descr = "";

	/**
	 * Минимальное значение по X
	 */	
	private float MinX = 0;

	/**
	 * Минимальное значение по Y
	 */	
	private float MinY = 0;

	/**
	 * Максимальное значение по X
	 */
	private float MaxX = 0;

	/**
	 * Максимальное значение по Y
	 */	
	private float MaxY = 0;

	/**
	 * Описание единицы измерения по X
	 */	
	private String MeansX = "";

	/**
	 * Описание единицы измерения по Y
	 */	
	private String MeansY = "";
	
	/**
	 * Конструктор описания графика
	 * @param Name
	 * @param Descr
	 * @param MinX
	 * @param MaxX
	 * @param MinY
	 * @param MaxY
	 * @param MeansX
	 * @param MeansY
	 */
	
	GrafDataTitle(
			String Name, 
			String Descr, 
			float MinX, 
			float MaxX, 
			float MinY, 
			float MaxY, 
			String MeansX, 
			String MeansY) {
		
		this.setName(Name);
		this.setDescr(Descr);
		this.setMinX(MinX);
		this.setMaxX(MaxX);
		this.setMinY(MinY);
		this.setMaxY(MaxY);
		this.setMeansX(MeansX);
		this.setMeansY(MeansY);
		
	}

	
	//------------------ set ------------------ 
	
	
	public void setName(String Name) {
		this.Name = Name;
	}

	public void setDescr(String Descr) {
		this.Descr = Descr;
	}	

	public void setMaxX(float MaxX) {
		this.MaxX = MaxX;
	}

	public void setMaxY(float MaxY) {
		this.MaxY = MaxY;
	}

	public void setMinX(float MinX) {
		this.MinX = MinX;
	}

	public void setMinY(float MinY) {
		this.MinY = MinY;
	}	

	public void setMeansX(String MeansX) {
		this.MeansX = MeansX;
	}

	public void setMeansY(String MeansY) {
		this.MeansY = MeansY;
	}
	
	
	//------------------ get ------------------

	public String getName() {
		return Name;
	}

	public String getDescr() {
		return Descr;
	}	

	public float getMaxX() {
		return MaxX;
	}

	public float getMaxY() {
		return MaxY;
	}

	public float getMinX() {
		return MinX;
	}

	public float getMinY() {
		return MinY;
	}	

	public String getMeansX() {
		return MeansX;
	}

	public String getMeansY() {
		return MeansY;
	}	
	
}
