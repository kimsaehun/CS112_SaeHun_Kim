/*
 * Sae Hun Kim
 * CS 112 Final Project
 * Tic Tac Toe Game with GUI
 * Main Class
 */

package FinalProject;

import javax.swing.JFrame;

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
		frame.setLocationRelativeTo(null);
	}
}
