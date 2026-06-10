package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import duck2.RandomNumber;

public class ButtonPanel extends JPanel implements ActionListener{
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JTextField instruction;
	private JButton expectedButton;
	
	public ButtonPanel() {
		setLayout(new BorderLayout());
		
		JPanel jp = new JPanel();
		add(jp, BorderLayout.CENTER);
		jp.setLayout(new GridLayout(2, 2, 20, 20));
		
		instruction = new JTextField();
		add(instruction, BorderLayout.NORTH);
		
		button1 = createButton("1", jp);
		button2 = createButton("2", jp);
		button3 = createButton("3", jp);
		button4 = createButton("4", jp);
		
		instructUser();
	}
	
	private JButton createButton(String title, JPanel jp) {
		JButton btn = new JButton(title);
		btn.addActionListener(this);
		jp.add(btn);
		return btn;
		
	}
	
	private void instructUser() {
		int randBtn = RandomNumber.between(1, 4);
		instruction.setText("Push button " + randBtn);
		switch(randBtn) {
		case 1:
			expectedButton = button1;
			break;
		case 2:
			expectedButton = button2;
			break;
		case 3:
			expectedButton = button3;
			break;
		case 4:
			expectedButton = button4;
			break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1) {
			System.out.println("button1 has been pushed");
			verifyInput(button1);
		}
		else if(e.getSource() == button2) {
			System.out.println("button2 has been pushed");
			verifyInput(button2);
		}
		else if(e.getSource() == button3) {
			System.out.println("button3 has been pushed");
			verifyInput(button3);
		}
		else if(e.getSource() == button4) {
			System.out.println("button4 has been pushed");
			verifyInput(button4);
		}
	}

	private void verifyInput(JButton button) {
		if (button == expectedButton) {
			instructUser();
		} else {
			instruction.setText("WRONG!");
			System.exit(0);
		}
		
	}
	
}
