package soduko;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameBoard extends JFrame {
	private JPanel main;
	private JMenuBar menuBar;
	private EventHandler eh;
	private BigSquare[] bigSquareArray = new BigSquare[9];
	private boolean assist = false;

	public static void main(String[] arg0) {
		new GameBoard();

	}

	public GameBoard() {
		setTitle("Soduko");
		setSize(900, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		eh = new EventHandler();

		createMain();
		createMenuBar();
		// checkValidNumbers();

		setVisible(true);
	}

	private void checkValidNumbers() {
		for (BigSquare bs : bigSquareArray) {
			for (LittleSquare ls : bs.getLittleSquareArray()) {
				ls.updateValue();

				try {

					if (ls.getValue().equals("")) {
						String bsCheck = checkBigSquare(ls); // finds invalid numbers in bigSquare
						String horizontalCheck = checkHorizontal(ls);
						String verticalCheck = checkVertical(ls);

						String nonPossibleNums = bsCheck.concat(horizontalCheck).concat(verticalCheck); // combines all
																										// invalid
																										// numbers
						String noDupsNPN = removeDups(nonPossibleNums); // removes duplication of numbers
						String orderedNoDupsNPN = order(noDupsNPN); // do not think this step is necessary

						ArrayList<String> validNums = compare(orderedNoDupsNPN);// returns valid numbers for this
																				// LittleSquare

						String x = validNums.toString();

						String v = "";
						for (String num : validNums) {
							v = v.concat(num);
						}

						if (v.equals(""))
							ls.setToolTipText("No Possible answer");
						else
							ls.setToolTipText(x);
						ls.setValidNums(v);
					} else
						ls.setToolTipText(null);
					// ls.setValidNums("");

				} catch (NumberFormatException e) {
					break;
				}

			}
		}
	}

	private ArrayList<String> compare(String invalidNums) {
		ArrayList<String> validNums = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
		Iterator<String> iter = validNums.iterator(); // Iterator used to remove invalidNums

		while (iter.hasNext()) {
			String num = iter.next();

			for (int j = 0; j < invalidNums.length(); j++) {
				String num2 = invalidNums.substring(j, j + 1);

				if (num.equals(num2)) {
					iter.remove();

				}
			}
		}

		return validNums;
	}

	private String order(String nums) { // Converts String to array of int to sort then converts back to String
		String[] listNums = nums.split("");
		Integer[] intValues = new Integer[listNums.length];
		for (int i = 0; i < listNums.length; i++)
			intValues[i] = Integer.parseInt(listNums[i].trim());

		Collections.sort(Arrays.asList(intValues));

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < intValues.length; i++) {
			Integer intValue = intValues[i];
			sb.append(intValue);
		}

		return sb.toString();
	}

	private String removeDups(String nonPossibleNums) {
		char[] chars = nonPossibleNums.toCharArray();
		Set<Character> charSet = new LinkedHashSet<Character>(); // Set is used to remove duplicates
		for (char c : chars) {
			charSet.add(c);
		}

		StringBuilder sb = new StringBuilder();
		for (Character character : charSet) { // Convert from Set<Character> back to a String of numbers
			sb.append(character);
		}

		return sb.toString();
	}

	private String checkVertical(LittleSquare currentLS) {
		String x = "";
		for (BigSquare bs : bigSquareArray) {
			for (LittleSquare ls : bs.getLittleSquareArray()) {
				if (currentLS.getCol() == ls.getCol())
					if (!(ls.getValue().equals("0")))
						x = x.concat(ls.getValue());
			}
		}
		return x;

	}

	private String checkBigSquare(LittleSquare currentLS) {
		String x = "";
		for (BigSquare bs : bigSquareArray) {
			for (LittleSquare ls : bs.getLittleSquareArray()) {
				if (currentLS.getBS() == ls.getBS()) {
					if (!(ls.getValue().equals("0")))
						x = x.concat(ls.getValue());

				}
			}
		}
		return x;
	}

	private String checkHorizontal(LittleSquare currentLS) {
		String x = "";
		for (BigSquare bs : bigSquareArray) {
			for (LittleSquare ls : bs.getLittleSquareArray()) {
				if (currentLS.getRow() == ls.getRow())
					if (!(ls.getValue().equals("0")))
						x = x.concat(ls.getValue());
			}
		}
		return x;

	}

	private void createMenuBar() {
		menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		menuBar.add(file);
		JMenuItem menuItem = new JMenuItem("NEW");
		menuItem.addActionListener(eh);
		file.add(menuItem);
		JMenuItem menuItem1 = new JMenuItem("CLEAR");
		menuItem1.addActionListener(eh);
		file.add(menuItem1);
		JMenuItem menuItem2 = new JMenuItem("READ");
		menuItem2.addActionListener(eh);
		file.add(menuItem2);
		JMenuItem menuItem3 = new JMenuItem("SAVE");
		menuItem3.addActionListener(eh);
		file.add(menuItem3);
		JMenuItem menuItem4 = new JMenuItem("EXIT");
		menuItem4.addActionListener(eh);
		file.add(menuItem4);
		setJMenuBar(menuBar);
	}

	public void createMain() {
		main = new JPanel();
		main.setLayout(new GridLayout(3, 3));
		add(main);

		for (int i = 0; i < 9; i++) {
			BigSquare bs = new BigSquare();
			bigSquareArray[i] = bs;

			main.add(bs);
		}
		int bsCounter = 0; // links 9 littleSquares to a bigSquare
		int oldRow;
		int colCounter = 0;
		int rowCounter = 0;
		for (BigSquare bs : bigSquareArray) {
			bsCounter++;

			// Sets column counter
			if (bsCounter == 1 || bsCounter == 4 || bsCounter == 7)
				colCounter = 1;
			if (bsCounter == 2 || bsCounter == 5 || bsCounter == 8)
				colCounter = 4;
			if (bsCounter == 3 || bsCounter == 6 || bsCounter == 9)
				colCounter = 7;

			// Sets row counter
			if (bsCounter == 1 || bsCounter == 2 || bsCounter == 3)
				rowCounter = 1;
			if (bsCounter == 4 || bsCounter == 5 || bsCounter == 6)
				rowCounter = 4;
			if (bsCounter == 7 || bsCounter == 8 || bsCounter == 9)
				rowCounter = 7;

			// Assigns row, column, and bigSquare value for each LittleSquare
			for (int i = 1; i < 10; i++) {
				if (bsCounter <= 9) {
					oldRow = rowCounter;
					LittleSquare ls = new LittleSquare(bsCounter, rowCounter, colCounter);
					ls.gettextField().addKeyListener(eh);
					int x = rowCounter;
					int s = colCounter;
					int j = bsCounter;
					ls.setToolTipText("Row: " + Integer.toString(x) + " " + "Col: " + Integer.toString(s)
							+ " BigSquare: " + Integer.toString(j));
					bs.addLittleSquare(ls);
					ls.gettextField().addMouseListener(eh);
					bs.add(ls);
					if (i % 3 == 0)
						rowCounter++;
					if (oldRow < rowCounter)
						colCounter = colCounter - 2;
					else if (oldRow > rowCounter)
						colCounter++;
					else
						colCounter++;
				}
			}

		}
	}

	private class EventHandler implements ActionListener, KeyListener, MouseListener {
		private JFileChooser fc;
		// private File file;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getActionCommand().equals("NEW")) {// New option is selected
				for (BigSquare bs : bigSquareArray) {
					for (LittleSquare ls : bs.getLittleSquareArray()) {
						ls.setValue("0");
					}
				}
			}

			if (arg0.getActionCommand().equals("CLEAR")) {// Clear option is selected
				for (BigSquare bs : bigSquareArray) {
					for (LittleSquare ls : bs.getLittleSquareArray()) {
						if (!(ls.getStart())) {
							ls.setValue("0");
						}
					}
				}
				checkValidNumbers();
			}

			fc = new JFileChooser();
			fc.setCurrentDirectory(new java.io.File("Resourses"));
			if (arg0.getActionCommand().equals("READ")) { // Read option is selected
				int returnVal = fc.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					readFile(file);
				}
			}

			if (arg0.getActionCommand().equals("SAVE")) { // Save option is selected
				BufferedWriter write;
				File file = null;

				int returnVal = fc.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					file = fc.getSelectedFile();
				}

				try {
					write = new BufferedWriter(new FileWriter(file));
					for (BigSquare bs : bigSquareArray) {
						for (LittleSquare ls : bs.getLittleSquareArray()) {
							String x = ls.gettextField().getText();
							if (x.equals("")) {
								write.write("0");
							} else {
								if (ls.getStart())
									write.write("*" + x);
								else
									write.write(x);
							}
							write.newLine();
						}
					}
					write.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (arg0.getActionCommand().equals("EXIT")) { // Exit option is selected
				System.exit(0);
			}

		}

		@Override
		public void keyPressed(KeyEvent arg0) {

		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			checkValidNumbers();
//			checkValidNumbers();

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			char c = arg0.getKeyChar();
			// if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) || c ==
			// KeyEvent.VK_DELETE) {// prevents anything
			// // that is not a
			// // number to be
			// // typed
			// arg0.consume();
			// }
			try {
				LittleSquare x = (LittleSquare) arg0.getComponent().getParent();
				String validNums = x.getValidNums();
				boolean check = false;
				for (int j = 0; j < validNums.length(); j++) {
					String num = validNums.substring(j, j + 1);
					if (Character.toString(c).equals(num)) {
						check = true;
					}
				}

				if (!(check)) {
					arg0.consume();
				}
			} catch (NullPointerException e) {

			}
		}

		private void readFile(File file) {
			Scanner input = null;
			String val;
			try {
				input = new Scanner(file, "UTF-8");
			} catch (FileNotFoundException e) {
				System.out.println("No file found");
			}
			for (BigSquare bs : bigSquareArray) {
				for (LittleSquare ls : bs.getLittleSquareArray()) {
					val = input.nextLine().trim();
					if (val.length() == 2) {
						ls.startNums(val);
					} else
						ls.setValue(val);
				}
			}
			checkValidNumbers();
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {

			for (BigSquare bs : bigSquareArray) { // Reset color of all LittleSquares to White
				for (LittleSquare ls : bs.getLittleSquareArray()) {
					ls.changeColor(Color.WHITE);
				}
			}
			if (arg0.getClickCount() == 2) // turns off/on aid with double click
				if (assist)
					assist = false;
				else
					assist = true;

			if (assist) {
				LittleSquare currentLS = (LittleSquare) arg0.getComponent().getParent();
				for (BigSquare bs : bigSquareArray) {
					for (LittleSquare ls : bs.getLittleSquareArray()) {
						if (currentLS.getRow() == ls.getRow() || currentLS.getCol() == ls.getCol()) { // Colors
																										// LittleSquares
																										// if
																										// it appears in
																										// same col or
																										// row
							ls.changeColor(Color.GREEN);
						}
					}
				}
			}

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}
}
