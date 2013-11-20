/*
 * Sae Hun Kim
 * CS 112 Final Project
 * Tic Tac Toe Game with GUI
 */

package FinalProject;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TTTwithGUIMain implements Runnable {
	TTTwithGUI game = new TTTwithGUI();

	public static void main(String[] args) {
		TTTwithGUI game = new TTTwithGUI();
		JFrame frame = new JFrame("Tic Tac Toe");

		boolean playing = true;

		JOptionPane.showMessageDialog(new JFrame(), "Let's Play Tic Tac Toe!");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.WHITE);
		/*
		 * while (playing) { showGUI(frame, game, ASK_MARK); while
		 * (!game.isNeedRepaint()) { System.out.print(""); }
		 * game.setNeedRepaint(false); showGUI(frame, game, GAME); playing =
		 * false; }
		 */
	}

	/*
	 * // used to show the GUI public static void showGUI(JFrame f, TTTwithGUI
	 * g, int mode) { if (mode == 0) { g.setToGameMap(f.getContentPane()); }
	 * else { g.setToPrintPanel(f.getContentPane(), mode); } f.setVisible(true);
	 * f.pack(); }
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (game.isNeedRepaint()) {
			game.paintGUI();
		}
	}
}
