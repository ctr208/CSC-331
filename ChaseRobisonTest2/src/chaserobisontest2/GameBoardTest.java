package chaserobisontest2;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;


public class GameBoardTest extends JFrame {
	
	private GameTileTest [] tiles = new GameTileTest[100];
	private EventHandler eh = new EventHandler();
	
	public static void main(String[] args) {
		new GameBoardTest();
	}

	public GameBoardTest() {
		setSize(600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Bunch of Tiles");

		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName() );
		} catch (Exception e) {
		            e.printStackTrace();
		}

		Container c = getContentPane();
		JPanel p = createGamePanel(new Random());
		c.add(p);

		setVisible(true);
	}

	private JPanel createGamePanel(Random r) {
		JPanel p = new JPanel();

		p.setLayout(new GridLayout(10, 10));

		for (int i = 0; i < 100; i++) {
			tiles[i] = new GameTileTest(r.nextInt(20));
			tiles[i].addActionListener(eh);
			p.add(tiles[i]);
		}

		return p;
	}
	
	private class EventHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (GameTileTest t: tiles) {
				t.changeColor(Color.WHITE);
			}
			GameTileTest clickedTile = (GameTileTest) arg0.getSource();
			System.out.println(clickedTile.getNum());
			clickedTile.changeColor(Color.GREEN);
			for (GameTileTest t: tiles) {
				if(t.getNum() == clickedTile.getNum()) {
					t.changeColor(Color.GREEN);
				}
				if(t.getNum() > clickedTile.getNum()) {
					t.changeColor(Color.RED);
				}
				if(t.getNum() < clickedTile.getNum()) {
					t.changeColor(Color.ORANGE);
				}

			}
			
			
		}
		
	}

}
