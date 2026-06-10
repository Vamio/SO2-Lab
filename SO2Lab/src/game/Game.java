package game;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JFrame{
	private ButtonPanel ButtonPanel;
	
	public Game(String title) {
		super(title);
		Dimension d = getToolkit().getScreenSize();
		setBounds(0, 0, d.width, d.height - 100);
		
		ButtonPanel bp = new ButtonPanel();
		setContentPane(bp);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Game("Another Sony Exclusive");
	}
}
