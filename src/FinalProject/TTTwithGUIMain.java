/*
 * Sae Hun Kim
 * CS 112 Final Project
 * Tic Tac Toe Game with GUI
 * Main Class
 */

package FinalProject;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

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
		game.paintGUI();
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int confirmed = JOptionPane.showConfirmDialog(null,
						"Do you want to quit?", "Confirm Quit",
						JOptionPane.YES_NO_OPTION);
				// Close if user confirmed
				if (confirmed == JOptionPane.YES_OPTION) {
					// Close frame
					System.exit(0);
				}
				// System.exit(0);
			} // windowClosing
		});// addWindowListener
	}
}
