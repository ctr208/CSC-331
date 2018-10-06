package lineDrawing;


import java.awt.Color;
import java.awt.Graphics;


public class Rectangle extends Shape{	

	private static final long serialVersionUID = 1L;
	
	private int startX, startY;	
	private int width, height;
	
	private Color color;

	
	public Rectangle(int sx, int sy, int w, int h){
		
		startX = sx;
		startY = sy;
		width = w;
		height = h;
	}

	public void draw(Graphics g1) {
		color = getTheColor();
		g1.setColor(color);
		g1.drawRect(startX, startY, width, height);	
	}


	public boolean contains(int x, int y) {
		
		if (x >= getStartX() && x <= (getStartX() + width)){
			if (y >= getStartY() && y <= (getStartY() + height)){
				return true;
			}
		}
		return false;
	}
	
	public int getStartX(){
		return startX;
	}

	public int getStartY(){
		return startY;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

}
