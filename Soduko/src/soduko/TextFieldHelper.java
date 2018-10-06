//
//package soduko;
//
//import javax.swing.text.AttributeSet;
//import javax.swing.text.BadLocationException;
//import javax.swing.text.PlainDocument;
//
//@SuppressWarnings("serial")
//public class TextFieldHelper extends PlainDocument {
//	private int limit = 1;
//
//
//	public void insertString(int offset, String str, AttributeSet set) throws BadLocationException {
//		if (str == null) {
//			return;
//		} else if (getLength() + str.length() <= limit) {
//			super.insertString(offset, str, set);
//		}
//	}
//
//}
