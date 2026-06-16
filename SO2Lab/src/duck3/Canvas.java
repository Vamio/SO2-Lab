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
		btnPanel.setLayout(new GridLayout(5, 2, 0, 0));
		
		btnSizePlus = createButton("MAKE EM BIGGER", btnPanel);
		btnSizeMinus = createButton("MAKE EM SMALLER", btnPanel);
		btnNewGlasses = createButton("Change Glasses", btnPanel);
		
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
			else if(e.getSource() == btnNewGlasses) {
				myApp.changeGlasses();
				canvasPanel.repaint();
			}
		}
		
		private JButton createButton(String title, JPanel jp) {
			JButton btn = new JButton(title);
			btn.addActionListener(this);
			jp.add(btn);
			return btn;
			
		}
		
		public static void main(String[] args) {
			new Canvas("Some art");
		}
}