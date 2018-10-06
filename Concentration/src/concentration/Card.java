package concentration;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Card extends JButton {

	private static int width = 200, height = 200;

	private Color faceColor;

	private static Color backgroundColor;

	private boolean isFaceDown = true;

	public Card(Color fc) {
		setPreferredSize(new Dimension(width, height));

		faceColor = fc;
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	}

	public void faceUp() {
		isFaceDown = false;
		changeColor(faceColor);
	}

	public void faceDown() {
		isFaceDown = true;
		changeColor(backgroundColor);
	}

	private void changeColor(Color c) {
		setBackground(c);
		paintImmediately(0, 0, width, height);
	}

	public boolean equals(Object other) {
		Card otherCard = (Card) other;
		return faceColor.equals(otherCard.faceColor);
	}

	public String getColor() {
		String x = faceColor.toString();
		return x;
	}

	public boolean getFace() {
		return isFaceDown;
	}

}
