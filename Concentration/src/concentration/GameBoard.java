package concentration;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class GameBoard extends JFrame {

	private JPanel statusBar;
	private JPanel main;
	private JLabel statusLabel;
	private Color[] startColors = new Color[] { Color.ORANGE, Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN,
			Color.MAGENTA };
	private ArrayList<Color> colors = new ArrayList<Color>();

	private static GameController gc;
	private static int numOfPairs;
	private static int row = 0;
	private static int col = 0;

	public static void main(String[] args) {
		String str1 = JOptionPane.showInputDialog("Enter number of pairs");
		numOfPairs = Integer.valueOf(str1);
		getDimensions();
		new GameBoard();
		// GameBoard.gameOver();

	}

	public GameBoard() {

		gc = new GameController(numOfPairs);

		setTitle("Concentration Game");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		createMainPanel();
		main.setLayout(new GridLayout(row, col));

		statusBar = createStatusBar();
		statusBar.setToolTipText("Just click any card to begin!");
		add(statusBar, BorderLayout.SOUTH);
		
		addCards();

		setVisible(true);

	}

	private static void getDimensions() {
		
		if (numOfPairs % 2 == 0) { //test to see if numOfPairs is even
			if (numOfPairs == 2) {
				row = 2;
				col = 2;
			}else {
				row = numOfPairs / 2;
				col = (numOfPairs * 2) / row;
			}
		} else { 
			int counter = 1;
			int num = numOfPairs - 1;
			while (counter < numOfPairs) { 
				if (numOfPairs % num == 0) {
					row = num;
					col = (numOfPairs * 2) / row;
					break;
				} else if (num == 2) {
					row = num;
					col = numOfPairs;
					break;
				}

				else
					num--;
				counter++;
			}
		}
		

	}

	private void addCards() {

		for (int i = 1; i - 1 < numOfPairs; i++) { // generates and adds cards to gameBaord without their matches
			int index = new Random().nextInt(startColors.length);
			Color newColor = startColors[index];
			colors.add(newColor);
			Card c1 = new Card(newColor);

			main.add(c1);
			c1.addActionListener(gc);
		}

		while (colors.size() != 0) { // generates and adds cards to gameBaord that match the previous set of cards
			int index = new Random().nextInt(colors.size());
			Color newColor = colors.get(index);
			colors.remove(index);
			Card c1 = new Card(newColor);

			main.add(c1);
			c1.addActionListener(gc);
		}

	}

	private void createMainPanel() {
		main = new JPanel();
		add(main);
	}

	private JPanel createStatusBar() {
		JPanel statusPanel = new JPanel();
		statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		add(statusPanel, BorderLayout.SOUTH);
		statusPanel.setPreferredSize(new Dimension(getWidth(), 16));
		statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
		statusLabel = new JLabel("The Console will display your clicks once finsihed. Good luck!");
		statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		statusPanel.add(statusLabel);
		return statusPanel;
	}

}
