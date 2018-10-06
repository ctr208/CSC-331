package soduko;

import java.awt.BorderLayout;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

@SuppressWarnings("serial")
public class LittleSquare extends JPanel {
	private JTextField textField;
	private String value = "";
	private boolean startNum = false;
	private int row;
	private int col;
	private int bsLocation;
	private String validNums;

	public LittleSquare(int bigSquareQuadrant, int row, int col) {
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		bsLocation = bigSquareQuadrant;
		this.row = row;
		this.col = col;

		createTextField();
	}

	private void createTextField() {
		textField = new JTextField(1);
		textField.setText("");
		textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textField.setFont(textField.getFont().deriveFont(50f));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setDocument(new TextFieldHelper());
		add(textField, BorderLayout.CENTER);

	}

	public void startNums(String num) {
		this.value = num.substring(1);
		textField.setText(num.substring(1));
		textField.setEditable(false);
		this.startNum = true;
	}

	public void updateValue() {
		value = textField.getText();
		if (!(value.equals(""))) {
			validNums = "";
		}

	}

	public void changeColor(Color color) {
		setBackground(color);
	}

	public void setValidNums(String validNums) {
		this.validNums = validNums;
	}

	public void setValue(String num) {
		if (num.equals("0")) {
			this.value = num;
			textField.setText("");
			textField.setEditable(true);
		} else {
			this.value = num;
			textField.setText(num);

		}

	}

	public String getValue() {
		return value;
	}

	public JTextField gettextField() {
		return textField;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public int getBS() {
		return bsLocation;
	}

	public String getValidNums() {
		return validNums;
	}

	public boolean getStart() {
		return startNum;
	}

	private class TextFieldHelper extends PlainDocument {
		private int limit = 1;

		public void insertString(int offset, String str, AttributeSet set) throws BadLocationException {
			if (str == null) {
				return;
			} else if (getLength() + str.length() <= limit) {
				super.insertString(offset, str, set);
			}
		}

	}

}
