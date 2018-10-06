package soduko;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BigSquare extends JPanel {
	
	private LittleSquare[] littleSquares = new LittleSquare[9];
	private int indexCounter = 0;
	
	public BigSquare() {
		setLayout(new GridLayout(3,3));
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
	}
	
	public void addLittleSquare(LittleSquare ls){
		littleSquares[indexCounter] = ls;
		indexCounter++;
	}
	
//	public LittleSquare getLittleSquare(int index) {
//		LittleSquare ls = littleSquares[index];
//		return ls;
//	}
//	
	public LittleSquare[] getLittleSquareArray() {
		return littleSquares;
	}
	
	

}
