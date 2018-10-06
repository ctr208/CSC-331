package lineDrawing;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Shape implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Color theColor;
	
	private Color[] colorList = new Color[4];
	//private integer lineThickness;
	
	
	public void setColor(Color c){
		
//		colorList = generateColorList();
//		
//		int randomNum = ThreadLocalRandom.current().nextInt(0, 4);
//		
//		theColor = colorList[randomNum];
		
		theColor = c;
	}

		
	/*
	 * We create the Shape class because we want to be able to draw any kind of
	 * shape and store them all in one array list.
	 * 
	 */
	public abstract void draw(Graphics g);
		
	public abstract boolean contains(int x, int y);
	
//	public Color[] generateColorList(){
//		
//		Color[] theList = new Color[4];
//		
//		theList[0] = Color.RED;
//		theList[1] = Color.GREEN;
//		theList[2] = Color.BLUE;
//		theList[3] = Color.MAGENTA;
//		
//		return theList;		
//	}
	
	public Color getTheColor(){
		return theColor;
	}
}
