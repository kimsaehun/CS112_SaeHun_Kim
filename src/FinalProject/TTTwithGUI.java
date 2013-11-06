/*
 * Sae Hun Kim
 * CS 112 final Project
 * Tic Tac Toe with GUI
 */

package FinalProject;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TTTwithGUI {
	private static JPanel gameMap = new JPanel();// shows the tic tac toe map
	private static JPanel printPanel = new JPanel();// panel used to print stuff
													// to the player
	private char[][] map = { { 's', '|', 's', '|', 's' },
			{ 's', '|', 's', '|', 's' }, { 's', '|', 's', '|', 's' } };
	private int round = 0;
	private int playerScore = 0, compScore = 0;
	// arraylist to hold the coordinates of open spaces in the tic tac toe map
	private ArrayList<Integer> availableMoves = new ArrayList<Integer>();

	public  JPanel setToGameMap() {
		gameMap.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		JTextArea score = new JTextArea();
		score.setText("          Round " + round + "\n Player vs Computer"
				+ "\n             " + playerScore + " : " + compScore);
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = .5;
		c.weighty = .5;
		gameMap.add(score);
		/*
		 *       Round 1
 Player vs Computer
       0 : 0
    x: 1 2 3
y:1     | | 
y:2     | | 
y:3     | | 
		 */
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[row].length; col++) {

			}
		}
		return gameMap;
	}
}
