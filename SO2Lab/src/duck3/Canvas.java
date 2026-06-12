package duck3;

import javax.swing.JButton;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Canvas extends JFrame implements ActionListener{
	public static Graphics PEN;
	private CanvasPanel canvasPanel;
	private Application myApp;
	
	private JButton btnSizePlus; 
	private JButton btnSizeMinus;
	private JButton btnNewHats;
	
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
		add(canvasPanel = new CanvasPanel(), BorderLayout.CENTER);
		
		btnSizePlus = new JButton(); 
		btnSizePlus.addActionListener(this); 
		add(btnSizePlus, BorderLayout.WEST); 
		
		btnSizeMinus = new JButton(); 
		btnSizeMinus.addActionListener(this); 
		add(btnSizeMinus, BorderLayout.EAST); 
		
		Dimension screenSize = getToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// for Lab3
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnSizePlus) {
				myApp.makeBigger();
				canvasPanel.repaint();
			}
			else if (e.getSource() == btnSizeMinus) {
				myApp.makeSmaller();
				canvasPanel.repaint();
			}
			else if(e.getSource() == btnNewHats) {
				myApp.changeHats(RandomNumber.between(0, 2));
				canvasPanel.repaint();
			}
		}
		
		public static void main(String[] args) {
			new Canvas("Some art");
		}
}