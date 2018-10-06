package basicui;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class BasicUI extends JFrame{
	public BasicUI() {
		setTitle("Basic User Interface");
		setSize(400, 500);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BasicUI();
	}
	

}
