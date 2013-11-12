/*
 * Sae Hun Kim
 * CS 112 Final Project
 * Tic Tac Toe Game with GUI
 */

package FinalProject;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TTTwithGUIMain {
	public static void main(String[] args) {
		final int INTRO = 1;
		final int ASK_MARK = 2;
		final int WIN = 3;
		final int LOSE = 4;
		final int TIE = 5;
		final int ASK_PLAY = 6;
		final int END = 7;

		JOptionPane.showMessageDialog(new JFrame(), "Let's Play Tic Tac Toe!");

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
				System.out.println("FEF");
			}
		});
	}

	private static void createAndShowGUI() {
		TTTwithGUI game = new TTTwithGUI();
		JFrame frame = new JFrame("Tic Tac Toe");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		game.setToGameMap(frame.getContentPane());
		frame.pack();
	}
}
