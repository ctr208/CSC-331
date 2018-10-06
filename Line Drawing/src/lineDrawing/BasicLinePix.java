package lineDrawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class BasicLinePix extends JFrame{
	
	private ArrayList<Shape> everything = new ArrayList<>();
	
	private JPanel drawingPanel; // user draws here

	private JPanel statusBar;
	private JLabel statusLabel;// used to show informational messages

	private JMenuBar menuBar;
	private JMenu fileMenu;
	private EventHandler eh;
	
	private Color theColor = Color.BLUE;
	
	private Color[] colorList = new Color[4];

	public static void main(String[] args) {
		BasicLinePix lp = new BasicLinePix();
		lp.setVisible(true);
	}

	public BasicLinePix() {
		setTitle("Basic Line Pix 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp;

		cp = getContentPane();
		cp.setLayout(new BorderLayout());

		eh = new EventHandler();

		drawingPanel = makeDrawingPanel();
		drawingPanel.addMouseListener(eh);
		drawingPanel.addMouseMotionListener(eh);

		statusBar = createStatusBar();

		cp.add(drawingPanel, BorderLayout.CENTER);
		cp.add(statusBar, BorderLayout.SOUTH);

		buildMenu();

		pack();
	}

	private void buildMenu() {
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");

		JMenuItem menuItem = new JMenuItem("New");
		fileMenu.add(menuItem);

		menuItem = new JMenuItem("Open");
		fileMenu.add(menuItem);

		menuItem = new JMenuItem("Save");
		fileMenu.add(menuItem);

		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(eh);
		fileMenu.add(menuItem);

		menuBar.add(fileMenu);

		setJMenuBar(menuBar);
	}

	private JPanel makeDrawingPanel() {
		JPanel p = new JPanel();
		p.setPreferredSize(new Dimension(500, 400));
		p.setBackground(Color.YELLOW);

		return p;
	}

	private JPanel createStatusBar() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		statusLabel = new JLabel("No message");
		panel.add(statusLabel, BorderLayout.CENTER);

		panel.setBorder(new BevelBorder(BevelBorder.LOWERED));

		return panel;
	}

	// this method overrides the paint method defined in JFrame
	// add code here for drawing the lines on the drawingPanel
	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Graphics g1 = drawingPanel.getGraphics();

		// Send a message to each line in the drawing to
		// draw itself on g1
		
		for (Shape s: everything)
			
			s.draw(g1); // Polymorphic method		
	}

	// Inner class - instances of this class handle action events
	private class EventHandler implements ActionListener, MouseListener, MouseMotionListener {

		private int startX, startY; // line's start coordinates
		private int lastX, lastY; // line's most recent end point

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getActionCommand().equals("Exit")) {
				statusLabel.setText("Exiting program...");
				System.exit(0);
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {

			startX = e.getX();
			startY = e.getY();

			// initialize lastX, lastY
			lastX = startX;
			lastY = startY;

		}

		@Override
		public void mouseDragged(MouseEvent e) {
			
			// Implement rubber-band cursor
			Graphics g = drawingPanel.getGraphics();
			
			
			g.setColor(theColor);
			
			g.setXORMode(drawingPanel.getBackground());

			// REDRAW the line that was drawn
			// most recently during this drag
			// XOR mode means that yellow pixels turn black
			// essentially erasing the existing line
			g.drawLine(startX, startY, lastX, lastY);

			// draw line to current mouse position
			// XOR mode: yellow pixels become black
			// black pixels, like those from existing lines, temporarily become
			// yellow
			g.drawLine(startX, startY, e.getX(), e.getY());
			lastX = e.getX();
			lastY = e.getY();
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			Line l1 = new Line(startX, startY, arg0.getX(), arg0.getY());

			colorList = generateColorList();
			
			int randomNum = ThreadLocalRandom.current().nextInt(0, 4);
			
			theColor = colorList[randomNum];
			
			Graphics g = drawingPanel.getGraphics();
			
			
			g.setColor(theColor);
			
			everything.add(l1);
			everything.add(new Rectangle(startX, startY, arg0.getX() - startX, arg0.getY() - startY));
			
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			if(arg0.isControlDown()){
				
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
		}		

		@Override
		public void mouseExited(MouseEvent arg0) {
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
		}
		
		public Color[] generateColorList(){
			
			Color[] theList = new Color[4];
			
			theList[0] = Color.RED;
			theList[1] = Color.GREEN;
			theList[2] = Color.BLUE;
			theList[3] = Color.MAGENTA;
			
			return theList;		
		}

	}
}
