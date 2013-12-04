/*
 * Sae Hun Kim
 * CS 112 Lab 3
 * week 15
 */

package labWork.WeekFifteen;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LabThreeButton extends JPanel implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Color color = getBackground(); // color will be set
		Object source = arg0.getSource();
		String com = arg0.getActionCommand();
		if (com.equals("RED")) {
			color = Color.red;
		} else if (com.equals("BLUE")) {
			color = Color.blue;
		} else if (com.equals("YELLOW")) {
			color = Color.yellow;
		} else if (com.equals("GREEN")) {
			color = Color.green;
		} else if (com.equals("BLACK")) {
			color = Color.black;
		} else if (com.equals("WHITE")) {
			color = Color.white;
		} else if (com.equals("GRAY")) {
			color = Color.gray;
		} else if (com.equals("PURPLE")) {
			color = Color.magenta;
		} else if (com.equals("PINK")) {
			color = Color.pink;
		} else if (com.equals("1")) {
			System.out.println("ONE");
		} else if (com.equals("2")) {
			System.out.println("TWO");
		} else if (com.equals("3")) {
			System.out.println("THREE");
		} else if (com.equals("4")) {
			System.out.println("FOUR");
		} else if (com.equals("5")) {
			System.out.println("FIVE");
		} else if (com.equals("6")) {
			System.out.println("SIX");
		} else if (com.equals("7")) {
			System.out.println("SEVEN");
		} else if (com.equals("8")) {
			System.out.println("EIGHT");
		} else if (com.equals("9")) {
			System.out.println("NINE");
		}
		setBackground(color);
		repaint();
	}

	private JButton redButton;
	private JButton blueButton;
	private JButton yellowButton;
	private JButton greenButton;
	private JButton blackButton;
	private JButton whiteButton;
	private JButton grayButton;
	private JButton purpleButton;
	private JButton pinkButton;
	private JButton silverButton;
	String[] buttons = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };

	public LabThreeButton() {
		this.setLayout(new GridLayout(6, 3));
		// create buttons
		redButton = new JButton("RED");
		blueButton = new JButton("BLUE");
		yellowButton = new JButton("YELLOW");
		greenButton = new JButton("GREEN");
		blackButton = new JButton("BLACK");
		whiteButton = new JButton("WHITE");
		grayButton = new JButton("GRAY");
		purpleButton = new JButton("PURPLE");
		pinkButton = new JButton("PINK");
		add(redButton); // add button to current panel
		add(blueButton); // add button to current panel
		add(yellowButton); // add button to current panel
		add(greenButton); // add button to current panel
		add(blackButton); // add button to current panel
		add(whiteButton); // add button to current panel
		add(grayButton); // add button to current panel
		add(purpleButton); // add button to current panel
		add(pinkButton); // add button to current panel
		// register the current panel as listener for the buttons
		redButton.addActionListener(this);
		blueButton.addActionListener(this);
		yellowButton.addActionListener(this);
		greenButton.addActionListener(this);
		blackButton.addActionListener(this);
		whiteButton.addActionListener(this);
		grayButton.addActionListener(this);
		purpleButton.addActionListener(this);
		pinkButton.addActionListener(this);
		for (int i = 0; i < buttons.length; i++) {
			JButton bt = new JButton(buttons[i]);
			add(bt);
			bt.addActionListener(this);
		}
	} // ButtonPanel constructor
}