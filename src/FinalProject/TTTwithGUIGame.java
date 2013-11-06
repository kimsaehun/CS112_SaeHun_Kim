/*
 * Sae Hun Kim
 * CS 112 Final Project
 * Tic Tac Toe Game with GUI
 */

package FinalProject;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TTTwithGUIGame {
	public static void main(String[] args) {
		TTTwithGUI game = new TTTwithGUI();
		JFrame frame = new JFrame("Tic Tac Toe");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		TTTwithGUI.setToGameMap(frame.getContentPane());
		frame.pack();
	}
}
