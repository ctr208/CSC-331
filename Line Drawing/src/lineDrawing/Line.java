package lineDrawing;

import java.awt.Color;
import java.awt.Graphics;


public class Line extends Shape{

	private static final long serialVersionUID = 1L;
	
	private int startX, startY, endX, endY;
	
	private Color color;

	
	public Line(int sx, int sy, int ex, int ey){	
		startX = sx;
		startY = sy;
		endX = ex;
		endY = ey;
	}
	
	public void draw(Graphics g1) {		

		g1.drawLine(startX, startY, endX, endY);
	}

	
	public boolean contains(int x, int y) {
		
		if (x >= getStartX() && x <= (getStartX() + getEndX())){
			if (y >= getStartY() && y <= (getStartY() + getEndY())){
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
	
	public int getEndX(){
		return endX;
	}
	
	public int getEndY(){
		return endY;
	}
}
