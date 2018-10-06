package basiclinepix;

import java.awt.Graphics;

public class Rectangle extends Shape {
	private int startX, startY;
	private int width, height;
	
	public Rectangle(int sx, int sy, int w, int h) {
		startX = sx;
		startY = sy;
		width = w;
		height = h;
		
	}
	
	public void draw(Graphics g) {
		g.drawRect(startX, startY, width, height);
		
	}

}
