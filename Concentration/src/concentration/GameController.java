package concentration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class GameController implements ActionListener {
	private int counter = 0;
	private int matches = 0;
	private int numOfPairs;
	private Card first;
	private boolean start = true;

	public GameController(int num) {
		this.numOfPairs = num;
	}

	public void actionPerformed(ActionEvent arg0) {

		Card clickedCard = (Card) arg0.getSource();
		this.counter++;

		if (clickedCard.getFace()) {

			if (start) {
				clickedCard.faceUp();
				first = clickedCard;
				start = false;
			} else {
				clickedCard.faceUp();
				if (first.getColor().equals(clickedCard.getColor())) {
					matches++;
				} else {
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					first.faceDown();
					clickedCard.faceDown();
				}
				first = null;
				start = true;

			}

		}

		if (matches == numOfPairs) {
			System.out.println("YOU WON");
			System.out.println("It took you " + counter + " tries.");
		}

		// clickedCard.faceUp();

	}

	public int getCounter() {
		return counter;
	}

	public int getMatches() {
		return matches;
	}

}
