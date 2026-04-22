package duck;

/**
 * Provides a panel which can be used for drawing.
 * 
 * @author Björn Gottfried
 * @version 1.0
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class Canvas extends JFrame {
	public static Graphics PEN;
	private Application myApp;
	
	private class CanvasPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics pen) {
			super.paintComponent(pen);
			PEN = pen;
			myApp.draw();
		}
	}
	
	public Canvas(String title) {
		super(title);
		setLayout(new BorderLayout());
		myApp = new Application();
		add(new CanvasPanel(), BorderLayout.CENTER);
		Dimension screenSize = getToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Canvas("Some art");
	}
}