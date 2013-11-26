/*
 * Sae Hun Kim
 * CS 112 final Project
 * Tic Tac Toe with GUI
 */

package FinalProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TTTwithGUI extends JFrame {
	private static int mode;
	// list of modes
	final int GAME = 0;
	final int INTRO = 1;
	final int ASK_MARK = 2;
	final int WIN = 3;
	final int LOSE = 4;
	final int TIE = 5;
	final int REPLAY = 6;
	final int END = 7;

	private char[][] map = { { 's', '|', 's', '|', 's' },
			{ 's', '|', 's', '|', 's' }, { 's', '|', 's', '|', 's' } };
	private int round = 1, playerScore = 0, compScore = 0;
	// arraylist to hold the coordinates of open spaces in the tic tac toe map
	private ArrayList<Integer> availableMoves = new ArrayList<Integer>();
	private char playerMark, compMark;

	private JButton leftButton = new JButton();// used for the function
	private JButton rightButton = new JButton();// setToPrintPanel
	private JButton spaceButton;// used to represent spaces in the tic tac toe
								// map

	private ButtonListener listener = new ButtonListener();// action listener
															// for the buttons

	// check to see if something needs to be repainted
	private boolean movesFirst;

	private Container pane;
	private JFrame frame;

	public TTTwithGUI(JFrame f) {
		frame = f;
		pane = frame.getContentPane();
		mode = INTRO;
	}

	public void paintGUI() {
		if (mode == GAME) {
			// if the player doesn't move first, make the computer move so and
			// then set moveFirst to false. Computer moves will be made in the
			// actionPerformed method
			if (!movesFirst) {
				makeCompMove();
				movesFirst = true;
			}
			setToGameMap();
		} else {
			setToPrintPanel(mode);
		}
		frame.pack();
	}

	// show that screen for asking questions and getting input
	public void setToPrintPanel(int page) {
		pane.removeAll();
		JPanel pPanel = new JPanel();
		pPanel.setLayout(new BorderLayout());
		pPanel.setBackground(Color.WHITE);
		JTextArea text = new JTextArea();

		// the if statements are necessary because multiple listeners would be
		// added every time this method was called
		if (leftButton.getActionListeners().length < 1) {
			leftButton.addActionListener(listener);
		}
		if (rightButton.getActionListeners().length < 1) {
			rightButton.addActionListener(listener);
		}

		switch (page) {
		case INTRO:// Page 1 = Introduction
			text.setText("Let's play some Tic Tac Toe!");
			leftButton.setText("Next");
			pPanel.add(text, BorderLayout.PAGE_START);
			pPanel.add(leftButton, BorderLayout.LINE_END);
			break;

		case ASK_MARK: // Page 2 = Ask whether the player wants to go first or
						// not
			text.setText("Do you want to be O or X?\n(Note: O goes first)");
			leftButton.setText("O");
			rightButton.setText("X");
			pPanel.add(text, BorderLayout.PAGE_START);
			pPanel.add(leftButton, BorderLayout.LINE_START);
			pPanel.add(rightButton, BorderLayout.LINE_END);
			break;

		case WIN:// Page 3 = Winning resultsJPanel gmPanel = new JPanel();
			text.setText("Great Job! You Won!");
			leftButton.setText("Next");
			pPanel.add(text, BorderLayout.PAGE_START);
			pPanel.add(leftButton, BorderLayout.LINE_END);
			pPanel.add(printMap());
			break;

		case LOSE:// Page 4 = Losing results
			text.setText("Sorry but you lost! The computer beat you!");
			leftButton.setText("Next");
			pPanel.add(text, BorderLayout.PAGE_START);
			pPanel.add(leftButton, BorderLayout.LINE_END);
			pPanel.add(printMap());
			break;

		case TIE:// Page 5 = Tie results
			text.setText("It's a cat's game! No one won!");
			leftButton.setText("Next");
			pPanel.add(text, BorderLayout.PAGE_START);
			pPanel.add(leftButton, BorderLayout.LINE_END);
			pPanel.add(printMap());
			break;

		case REPLAY:// Page 6 = Ask to play again
			text.setText("Do you want to play again? ");
			leftButton.setText("Yes");
			rightButton.setText("No");
			pPanel.add(text, BorderLayout.PAGE_START);
			pPanel.add(leftButton, BorderLayout.LINE_START);
			pPanel.add(rightButton, BorderLayout.LINE_END);
			break;

		case END:// Page 7 = Closure
			text.setText("All right then, Here are the scores.\n"
					+ "Rounds Played: " + round + "\nPlayer Wins: "
					+ playerScore + "\nComputer Wins: " + compScore
					+ "\nExit the window to close.");
			pPanel.add(text, BorderLayout.CENTER);
			break;
		}
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		pane.add(pPanel);
	}

	public void setToGameMap() {// shows the game map
		pane.removeAll();
		JPanel gmPanel = new JPanel();
		gmPanel.add(printScore());
		gmPanel.add(printMap());
		pane.add(gmPanel);
	}

	public JPanel printScore() {// prints score
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

	public JPanel printMap() {// prints the map
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

	public void mark(char mark, int coord) {
		// the x value would be the column and the y value would be the row
		int col = coord / 10;// the x value
		int row = coord - (col * 10);// the y value
		map[row][col] = mark;
	}

	public void makeCompMove() {// makes the computer's move by randomly
								// selecting an available space
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

	public void checkWin() {// check to see if anyone won or if its a tie
		for (int row = 0; row < 3; row++) {
			if (map[row][0] == map[row][2] && map[row][2] == map[row][4]) {
				if (map[row][0] != 's') {
					// checks if there are 3 of the same marks in a single row
					if (map[row][0] == playerMark) {
						mode = WIN;
					} else if (map[row][0] == compMark) {
						mode = LOSE;
					}
				}
			}
		}
		for (int col = 0; col < 5; col += 2) {
			if (map[0][col] == map[1][col] && map[1][col] == map[2][col]) {
				// checks if there are 3 of the same marks in a single
				// column
				if (map[0][col] != 's') {
					// checks if there are 3 of the same marks in a single row
					if (map[0][col] == playerMark) {
						mode = WIN;
					} else if (map[0][col] == compMark) {
						mode = LOSE;
					}
				}
			}
		}
		if (map[1][2] == map[0][0] && map[1][2] == map[2][4]) {
			// checks \ diagonal
			if (map[1][2] != 's') {
				if (map[1][2] == playerMark) {
					mode = WIN;
				} else if (map[1][2] == compMark) {
					mode = LOSE;
				}
			}
		}
		if (map[1][2] == map[0][4] && map[1][2] == map[2][0]) {
			// checks / diagonal
			if (map[1][2] != 's') {
				if (map[1][2] == playerMark) {
					mode = WIN;
				} else if (map[1][2] == compMark) {
					mode = LOSE;
				}
			}
		}

		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 5; col++) {
				if (map[row][col] == 's') {
					availableMoves.add(col * 10 + row);
				}
			}
		}
		if (availableMoves.size() == 0) {
			// checks for a cats game(tie)
			mode = TIE;
		}
		availableMoves.clear();// clear the arrayList or it will keep on growing
	}

	public void clearMap() {// clears the map or a new game
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 5; col += 2) {
				map[row][col] = 's';
			}
		}
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// LeftButton is Yes or O or Next
			// RightButton is No or X
			if (arg0.getSource() == leftButton) {
				if (mode == INTRO) {
					mode = ASK_MARK;
				} else if (mode == ASK_MARK) {
					playerMark = 'O';
					movesFirst = true;
					compMark = 'X';
					mode = GAME;
				} else if (mode == WIN || mode == LOSE || mode == TIE) {
					if (mode == WIN) {
						playerScore++;
					} else if (mode == LOSE) {
						compScore++;
					}
					mode = REPLAY;
				} else if (mode == REPLAY) {
					round++;
					mode = ASK_MARK;
					clearMap();
				}
			} else if (arg0.getSource() == rightButton) {
				if (mode == ASK_MARK) {
					playerMark = 'X';
					movesFirst = false;
					compMark = 'O';
					mode = GAME;
				} else if (mode == REPLAY) {
					mode = END;
				}
			} else {// clicking on an empty space button on the game map results
					// in this. After Making a move, the computer will make a
					// move.
				mark(playerMark, Integer.parseInt(((JButton) arg0.getSource())
						.getName()));
				makeCompMove();
				checkWin();
			}
			paintGUI();
		}
	}
}
