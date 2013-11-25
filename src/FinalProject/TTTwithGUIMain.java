/*
 * Sae Hun Kim
 * CS 112 Final Project
 * Tic Tac Toe Game with GUI
 */

package FinalProject;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TTTwithGUIMain {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	public static void createAndShowGUI() {
		JFrame frame = new JFrame("Tic Tac Toe");
		TTTwithGUI game = new TTTwithGUI(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.paintGUI();
		frame.pack();
		frame.setVisible(true);
	}
}
