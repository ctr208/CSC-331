package chaserobisontest2;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class GameTileTest extends JButton {

	private static int width = 100, height = 100;
	private Color color;
	private int num;
	
	public GameTileTest(int number) {
		setPreferredSize(new Dimension(width, height));
		this.num = number;
		setText(Integer.toString(number));
	}
	
	public int getNum() {
		return num;
	}
	
	public void changeColor(Color color) {
		this.color = color;
		setBackground(color);
		paintImmediately(0, 0, width, height);
	}
	
}
