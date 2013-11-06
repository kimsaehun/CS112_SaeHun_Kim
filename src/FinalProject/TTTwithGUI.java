/*
 * Sae Hun Kim
 * CS 112 final Project
 * Tic Tac Toe with GUI
 */

package FinalProject;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TTTwithGUI {
	private static JPanel pane = new JPanel();// shows the tic tac toe map
	private static JPanel printPanel = new JPanel();// panel used to print stuff
													// to the player
	private static char[][] map = { { 's', '|', 's', '|', 's' },
			{ 's', '|', 's', '|', 's' }, { 's', '|', 's', '|', 's' } };
	private static int round = 0, playerScore = 0, compScore = 0;
	// arraylist to hold the coordinates of open spaces in the tic tac toe map
	private ArrayList<Integer> availableMoves = new ArrayList<Integer>();

	public static void setToGameMap(Container pane) {
		pane.setLayout(new GridBagLayout());
		pane.setBackground(Color.WHITE);
		GridBagConstraints c = new GridBagConstraints();

		JTextArea score = new JTextArea();
		score.setText("          Round " + round + "\n Player vs Computer"
				+ "\n             " + playerScore + " : " + compScore);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = .5;
		c.weighty = .5;
		c.gridy = 0;
		c.anchor = GridBagConstraints.CENTER;
		pane.add(score, c);

		JTextArea coordX = new JTextArea("          x: 1 2 3");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = .5;
		c.weighty = .5;
		c.gridy = 1;
		pane.add(coordX, c);

		JTextArea coordY1 = new JTextArea("y:1");
		c.weightx = .5;
		c.weighty = .5;
		c.gridx = 0;
		c.gridy = 2;
		pane.add(coordY1, c);

		JTextArea coordY2 = new JTextArea("y:2");
		c.weightx = .5;
		c.weighty = .5;
		c.gridx = 0;
		c.gridy = 3;
		pane.add(coordY2, c);

		JTextArea coordY3 = new JTextArea("y:3");
		c.weightx = .5;
		c.weighty = .5;
		c.gridx = 0;
		c.gridy = 4;
		pane.add(coordY3, c);

		for (int row = 2; row < map.length + 2; row++) {
			for (int col = 2; col < map[row - 2].length + 2; col++) {
				c.gridx = col;
				c.gridy = row;
				c.weightx = c.weighty = .5;
				c.anchor = GridBagConstraints.CENTER;
				if (map[row - 2][col - 2] == 's') {
					pane.add(new JButton(), c);
				} else {
					pane.add(new JTextArea("" + map[row - 2][col - 2]), c);
				}
			}
		}

	}
}
