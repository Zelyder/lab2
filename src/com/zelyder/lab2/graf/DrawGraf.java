package com.zelyder.lab2.graf;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * A component that displays rectangles and ellipses.
 */
class DrawGraf extends JComponent
{

	private static final long serialVersionUID = 1L;
	private int DefWidth = 700;
	private int DefHeight = 500;
	private float ScaleXW = 1;
	private float ScaleYH = 1;
	private boolean LogScale = false;
	private GrafData DataForDraw;
	private boolean noAxes = false;
	private Color color = Color.BLACK;
	private Color defcolor = Color.BLACK;
	
	private static int PredTitleY = 0; //Храним Y позицию последней подписи 
   
   DrawGraf() {
	   super();
   }

   DrawGraf(int w, int h) {
	   super();
	   this.DefHeight = h;
	   this.DefWidth = w;
   }
   
   DrawGraf(int w, int h, GrafData gd ) {
	   super();
	   this.DefHeight = h;
	   this.DefWidth = w;
	   this.DataForDraw = gd;
   }   

   DrawGraf(GrafData gd ) {
	   super();
	   this.DataForDraw = gd;
   }
   
   DrawGraf(GrafData gd, boolean log ) {
	   super();
	   this.DataForDraw = gd;
	   this.setLogScale(log);
   }    

   DrawGraf(GrafData gd, boolean log, boolean noAxes, Color color ) {
	   super();
	   this.DataForDraw = gd;
	   this.setLogScale(log);
	   this.noAxes = noAxes;
	   this.color = color;
   }
   
   public void setGrafData (GrafData gd, boolean log, boolean noAxes, Color color ) {
	   this.DataForDraw = gd;
	   this.setLogScale(log);
	   this.noAxes = noAxes;
	   this.color = color;
   }
   
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;

      //Рисуем рамку для графика

      double leftX = 50;
      double topY = 100;
      double width = 400;
      double height = 300;
      if( PredTitleY == 0 ) {
    	  PredTitleY = (int) (topY);
      }
      PredTitleY += 50;
      

      //Рисуем рамку графика
      if( !this.noAxes ) {
    	  Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
    	  g2.draw(rect);
      }
      
      //Рисуем подпись графика
	  Font FTitle = new Font("Arial", Font.PLAIN, 14);
	  g2.setFont(FTitle);
	  g2.setColor(color);
      g2.drawString(DataForDraw.getTitle().getName(), (int) (leftX+width+50), PredTitleY);       
      g2.setColor(defcolor);
      Font EdX = new Font("Arial", Font.PLAIN, 10);
	  g2.setFont(EdX);

      // draw a diagonal line
      if( DataForDraw.isCorrect() ) {
	      
	     

    	
    	//Рисуем подписи к осям
    	g2.drawString(DataForDraw.getTitle().getMeansX(), (int) (leftX+width), (int) (topY+height+30));
    	g2.drawString(DataForDraw.getTitle().getMeansY(), (int) (leftX-35), (int) (topY-15));
    	
    	  
    	//Если масштаб логарифмический, то по другому рассчитываем коэффициент масштаба по X
	      if( this.LogScale ) {
	    	  if( DataForDraw.getTitle().getMinX() != 0 )
	    		  this.ScaleXW = (float) (( Math.log10(DataForDraw.getTitle().getMaxX()) - Math.log10(DataForDraw.getTitle().getMinX()))/width);
	    	  else
	    		  this.ScaleXW = (float) (( Math.log10(DataForDraw.getTitle().getMaxX()))/width);
	      }
	      else {
	    	  this.ScaleXW = (float) ((DataForDraw.getTitle().getMaxX() - DataForDraw.getTitle().getMinX())/width);
	      }
	      this.ScaleYH = (float) ((DataForDraw.getTitle().getMaxY() - DataForDraw.getTitle().getMinY())/height);
	      
		      
	      for(int i = 0; i<DataForDraw.getGrafDataX().size()-1; i++) {
	    	  double FirstX;	    	  
	    	  double SecondX;	    	  
	    	  
	    	  //Если масштаб логарифмический, то по другому рассчитываем координаты точки
	    	  if( this.LogScale ) {
		    	  if( DataForDraw.getGrafDataX().get(i) != 0 )
		    		  FirstX = Math.round(Math.log10(DataForDraw.getGrafDataX().get(i))/this.ScaleXW)+leftX;
		    	  else
		    		  FirstX = leftX;  
		    	  SecondX = Math.round(Math.log10(DataForDraw.getGrafDataX().get(i+1))/this.ScaleXW+leftX);
	    	  }
	    	  else {
	    		  FirstX = Math.round(DataForDraw.getGrafDataX().get(i)/this.ScaleXW)+leftX;
		    	  SecondX = Math.round(DataForDraw.getGrafDataX().get(i+1)/this.ScaleXW+leftX);
	    	  }
	    	  	    	  
	    	  double FirstY = Math.round(height-DataForDraw.getGrafDataY().get(i)/this.ScaleYH+topY);	    	  
	    	  double SecondY = Math.round(height-DataForDraw.getGrafDataY().get(i+1)/this.ScaleYH+topY);
	    		  
	    	  
	    	  //Рисуем засечки на осях
	    	  g2.draw(new Line2D.Double(FirstX, height+topY-10, FirstX, height+topY+10));
	    	  g2.draw(new Line2D.Double(leftX-10, FirstY, leftX+10, FirstY));
	    	  
	    	  //Пишем значения
	    	  String messageX = DataForDraw.getGrafDataX().get(i).toString();
	    	  g2.drawString(messageX, (int) FirstX-5, (int) ((int) height+topY+20));
	    	  String messageY = DataForDraw.getGrafDataY().get(i).toString();
	    	  g2.drawString(messageY, (int) ((int) leftX-35), (int) FirstY);
	    	  
	      		//Устанавливаем цвет. 
	    	  	//Будет применяться для всего содержимого компонента: линий, текстов, заливки фигур 
	      		g2.setColor(color);
	      		
	      		//Рисуем квадраты, обозначающие точки	    	  
	      		Rectangle2D rec = new Rectangle2D.Double(FirstX-3, FirstY-3, 6, 6);
	      		g2.draw(rec);
	      		g2.fill(rec);
		    	
		    	  //Соединяем точки линиями
		    	  g2.draw(new Line2D.Double(FirstX, FirstY, SecondX, SecondY));
		    	  
	    	  //Особо обрабатываем последнюю точку
	    	  if( i == DataForDraw.getGrafDataX().size()-2 ) {
	    		  rec = new Rectangle2D.Double(SecondX-3, SecondY-3, 6, 6);
	    		  g2.draw(rec);
	    		  g2.fill(rec);
		    	  //Возвращаем цвет к значению по умолчанию 
	    		  g2.setColor(defcolor);
	    		  g2.draw(new Line2D.Double(SecondX, height+topY-10, SecondX, height+topY+10));
	    		  g2.draw(new Line2D.Double(leftX-10, SecondY, leftX+10, SecondY));
	    		  messageX = DataForDraw.getGrafDataX().get(i+1).toString();
	    		  messageY = DataForDraw.getGrafDataY().get(i+1).toString();
	    		  g2.drawString(messageX, (int) SecondX-5, (int) ((int) height+topY+20));
	    		  g2.drawString(messageY, (int) ((int) leftX-35), (int) SecondY);
	    	  }
	    	  
	    	  //Возвращаем цвет к значению по умолчанию 
	      		g2.setColor(defcolor);
	    		  
	      }
	      
      }
      else {
    	  System.out.println("Некорректно заполнен объект данных графика");
      }
   }
   
   public void setLogScale(boolean log) {
	   this.LogScale = log; 
   }
   
   public Dimension getPreferredSize() { return new Dimension(DefWidth, DefHeight); }
}