package duck3;

import javax.swing.JButton;

/**
 * Provides a panel which can be used for drawing.
 * 
 * @author Björn Gottfried
 * @version 1.0
 */

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.GridLayout;
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
	private JButton btnNewGlasses;
	private JButton btnNewHat;
	private JButton btnQuit;
	private JButton btnBodyColor;
	private JButton btnHeadColor;
	private JButton btnEyeColor;
	
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
		
		JPanel btnPanel = new JPanel();
		add(btnPanel, BorderLayout.WEST);
		btnPanel.setLayout(new GridLayout(0, 1, 80, 4));
		btnPanel.add(new JLabel("Distance from the Ducks", JLabel.CENTER));
		btnSizePlus  = createButton("Come Closer to the Ducks", btnPanel);
		btnSizeMinus = createButton("Step Back from the Ducks", btnPanel);
		btnPanel.add(new JLabel("Styling", JLabel.CENTER));
		btnNewGlasses = createButton("Change Glasses", btnPanel);
		btnNewHat = createButton("Change Hats", btnPanel);
		btnBodyColor = createButton("Change Body Color", btnPanel);
		btnHeadColor = createButton("Change Head Color", btnPanel);
		btnEyeColor  = createButton("Change Eye Color", btnPanel);
		btnPanel.add(new JLabel("", JLabel.CENTER)); // Empty JLabel for spacing
		btnQuit = createButton("Quit", btnPanel);
		
		Dimension screenSize = getToolkit().getScreenSize();
		
		setBounds(0, 0, screenSize.width, screenSize.height);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// for Lab3
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnSizePlus) {
				// Make Ducks larger button
				myApp.makeBigger();
				canvasPanel.repaint();
			}
			else if (e.getSource() == btnSizeMinus) {
				// Make Ducks smaller button
				myApp.makeSmaller();
				canvasPanel.repaint();
			}
			else if(e.getSource() == btnNewGlasses) {
				// Change Glasses button
				myApp.changeGlasses();
				canvasPanel.repaint();
			}
			else if(e.getSource() == btnNewHat) {
				// Change Hats button
				myApp.changeHats();
				canvasPanel.repaint();
			}
			else if(e.getSource() == btnBodyColor) {
				// Change Body Color button
				myApp.changeBodyColor();
				canvasPanel.repaint();
			}
			else if(e.getSource() == btnHeadColor) {
				// Change Head Color button
				myApp.changeHeadColor();
				canvasPanel.repaint();
			}
			else if(e.getSource() == btnEyeColor) {
				// Change Eye Color button
				myApp.changeEyeColor();
				canvasPanel.repaint();
			}
			else if(e.getSource() == btnQuit) {
				// Quit button
				System.exit(0);
			}
		}
		
		private JButton createButton(String title, JPanel jp) {
			JButton btn = new JButton(title);
			btn.addActionListener(this);
			jp.add(btn);
			return btn;
			
		}
		
		public static void main(String[] args) {
			new Canvas("Cool Ducks");
		}
}