package basiclinepix;

import java.awt.Graphics;

public class Line extends Shape {
	private int startX, startY, endX, endY;
	
	public Line(int sx, int sy, int ex,int ey) {
		startX = sx;
		startY = sy;
		endX = ex;
		endY = ey;
		
	}

	public void draw(Graphics g1) {
		// TODO Auto-generated method stub
		g1.drawLine(startX, startY, endX, endY);
	}

}
