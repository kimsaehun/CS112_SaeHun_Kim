/*
 * Sae Hun Kim
 * CS 112 final Project
 * Tic Tac Toe with GUI
 */

package FinalProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TTTwithGUI {
	private static char[][] map = { { 's', '|', 's', '|', 's' },
			{ 's', '|', 's', '|', 's' }, { 's', '|', 's', '|', 's' } };
	private static int round = 0, playerScore = 0, compScore = 0;
	// arraylist to hold the coordinates of open spaces in the tic tac toe map
	private ArrayList<Integer> availableMoves = new ArrayList<Integer>();
	private char playerMark, compMark;

	private JButton leftButton = new JButton();// used for the function
	private JButton rightButton = new JButton();// setToPrintPanel
	private JButton spaceButton;// used to represent spaces in the tic tac toe
								// map

	private ButtonListener listener = new ButtonListener();// action listener
															// for the buttons

	// show that screen for asking questions and getting input
	public void setToPrintPanel(Container pane, int page) {
		JPanel pPanel = new JPanel();
		pPanel.setLayout(new BorderLayout());
		pPanel.setBackground(Color.WHITE);

		JTextArea text = new JTextArea();

		leftButton.addActionListener(listener);
		rightButton.addActionListener(listener);

		switch (page) {
		case 1:// Page 1 = Introduction
			text.setText("Let's play some Tic Tac Toe!");
			pPanel.add(text, BorderLayout.CENTER);
			break;

		case 2: // Page 2 = Ask whether the player wants to go first or not
			text.setText("Do you want to be X or O?\n(Note: X goes first)");
			pPanel.add(text, BorderLayout.PAGE_START);
			leftButton.setText("X");
			rightButton.setText("O");
			pPanel.add(leftButton, BorderLayout.LINE_START);
			pPanel.add(leftButton, BorderLayout.LINE_END);
			break;

		case 3:// Page 3 = Winning results
			text.setText("Great Job! You Won!");
			pPanel.add(text, BorderLayout.CENTER);
			break;

		case 4:// Page 4 = Losing results
			text.setText("Sorry but you lost! The computer beat you!");
			pPanel.add(text, BorderLayout.CENTER);
			break;

		case 5:// Page 5 = Tie results
			text.setText("It's a cat's game! No one won!");
			pPanel.add(text, BorderLayout.CENTER);
			break;

		case 6:// Page 6 = Ask to play again
			text.setText("Do you want to play again? ");
			pPanel.add(text, BorderLayout.PAGE_START);
			leftButton.setText("Yes");
			rightButton.setText("No");
			pPanel.add(leftButton, BorderLayout.LINE_START);
			pPanel.add(leftButton, BorderLayout.LINE_END);
			break;

		case 7:// Page 7 = Closure
			text.setText("All right then, we'll see you next time!");
			pPanel.add(text, BorderLayout.CENTER);
			break;
		}
		pane.removeAll();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		pane.add(pPanel);
	}

	public void setToGameMap(Container pane) {// shows the game map
		pane.removeAll();
		JPanel gmPanel = new JPanel();
		gmPanel.add(printScore());
		gmPanel.add(printMap());
		pane.add(gmPanel);
	}

	// method made private because only this class will use it
	private JPanel printScore() {// prints score
		JPanel sPanel = new JPanel();
		sPanel.setLayout(new GridBagLayout());
		sPanel.setBackground(Color.WHITE);
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.NONE;
		JTextArea score = new JTextArea();
		score.setText("          Round " + round + "\n Player vs Computer"
				+ "\n             " + playerScore + " : " + compScore);
		sPanel.add(score, c);
		return sPanel;
	}

	// method made private because only this class will use it
	private JPanel printMap() {// prints the map
		JPanel gPanel = new JPanel();
		gPanel.setBackground(Color.WHITE);
		gPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		for (int i = 1; i < 4; i++) {// adds the x coordinates
			c.weightx = .5;
			c.weighty = .5;
			c.gridx = (i * 2) - 1;
			c.gridy = 0;
			gPanel.add(new JTextArea(" " + i + " "), c);
		}

		c.weightx = .5;
		c.weighty = .5;
		c.gridx = 0;
		c.gridy = 0;
		gPanel.add(new JTextArea("  x:"), c);
		for (int i = 1; i < 4; i++) {// adds the y coordinates
			c.weightx = .5;
			c.weighty = .5;
			c.gridx = 0;
			c.gridy = i;
			gPanel.add(new JTextArea("y:" + i), c);
		}

		// prints out the tic tac toe map
		for (int row = 1; row < map.length + 1; row++) {
			for (int col = 1; col < map[row - 1].length + 1; col++) {
				c.weightx = .5;
				c.weighty = .5;
				c.gridx = col;
				c.gridy = row;
				if (map[row - 1][col - 1] == 's') {
					spaceButton = new JButton();
					spaceButton.setName("" + ((col - 1) * 10 + (row - 1)));
					spaceButton.addActionListener(listener);
					gPanel.add(spaceButton, c);
				} else {
					gPanel.add(
							new JTextArea(" " + map[row - 1][col - 1] + " "), c);
				}
			}
		}
		return gPanel;
	}

	public char getPlayerMark() {
		return playerMark;
	}

	public char getCompMark() {
		return compMark;
	}

	public void mark(char mark, int coord) {
		// the x value would be the column and the y value would be the row
		int col = coord / 10;// the x value
		int row = coord - (col * 10);// the y value
		map[row][col] = mark;
	}

	public void makeCompMove(char mark) {// makes the computer's move by
		// randomly selecting an available
		// space
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 5; col++) {
				if (map[row][col] == 's') {
					availableMoves.add(col * 10 + row);
				}
			}
		}
		if (availableMoves.size() != 0) {
			mark(compMark,
					availableMoves.get((int) (Math.random() * (availableMoves
							.size()))));
		}
		availableMoves.clear();// clear the arrayList or it will keep on
		// growing
	}

	public char checkWin() {// check to see if anyone won or if its a tie
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 5; col++) {
				if (map[row][col] == 's') {
					availableMoves.add(col * 10 + row);
				}
			}
		}
		if (availableMoves.size() == 0) {
			// checks for a cats game(tie)
			return 't';
		}
		availableMoves.clear();// clear the arrayList or it will keep on growing
		for (int row = 0; row < 3; row++) {
			if (map[row][0] == map[row][2] && map[row][2] == map[row][4]) {
				if (map[row][0] != 's') {
					// checks if there are 3 of the same marks in a single row
					return map[row][0];
				}
			}
		}
		for (int col = 0; col < 5; col += 2) {
			if (map[0][col] == map[1][col] && map[1][col] == map[2][col]) {
				// checks if there are 3 of the same marks in a single
				// column
				if (map[0][col] != 's') {
					// checks if there are 3 of the same marks in a single row
					return map[0][col];
				}
			}
		}
		if (map[1][2] == map[0][0] && map[1][2] == map[2][4]) {
			// checks \ diagonal
			if (map[1][2] != 's') {
				return map[1][2];
			}
		}
		if (map[1][2] == map[0][4] && map[1][2] == map[2][0]) {
			// checks / diagonal
			if (map[1][2] != 's') {
				return map[1][2];
			}
		}
		return 'z';
	}

	public void mapClear() {// clears the map or a new game
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 5; col += 2) {
				map[row][col] = 's';
			}
		}
	}

	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// X also means Yes
			// O also means No
			if (arg0.getSource() == leftButton) {
				playerMark = 'X';
				compMark = 'O';
			} else if (arg0.getSource() == rightButton) {
				playerMark = 'O';
				compMark = 'X';
			} else {
				mark(playerMark, Integer.parseInt(((JButton) arg0.getSource())
						.getName()));
			}
		}
	}
}
