/*
 * Sae Hun Kim
 * CS 112 final Project
 * Tic Tac Toe with GUI
 * GUI class
 */

package FinalProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TTTwithGUI extends JFrame {
	private static int state;
	// list of states
	final int GAME = 0;
	final int INTRO = 1;
	final int ASK_MARK = 2;
	final int WIN = 3;
	final int LOSE = 4;
	final int TIE = 5;
	final int REPLAY = 6;
	final int END = 7;

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

	private TTTwithGUILogic logic = new TTTwithGUILogic();

	public TTTwithGUI(JFrame f) {
		frame = f;
		pane = frame.getContentPane();
		state = INTRO;
	}

	public void paintGUI() {
		if (state == GAME) {
			// if the player doesn't move first, make the computer move so and
			// then set moveFirst to false. Computer moves will be made in the
			// actionPerformed method
			if (!movesFirst) {
				logic.makeCompMove();
				movesFirst = true;
			}
			setToGameMap();
		} else {
			setToPrintPanel(state);
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
			rightButton.setText("Next");
			pPanel.add(text, BorderLayout.PAGE_START);
			pPanel.add(rightButton, BorderLayout.LINE_END);
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
			rightButton.setText("Next");
			pPanel.add(text, BorderLayout.PAGE_START);
			pPanel.add(rightButton, BorderLayout.LINE_END);
			pPanel.add(printMap());
			break;

		case LOSE:// Page 4 = Losing results
			text.setText("Sorry but you lost! The computer beat you!");
			rightButton.setText("Next");
			pPanel.add(text, BorderLayout.PAGE_START);
			pPanel.add(rightButton, BorderLayout.LINE_END);
			pPanel.add(printMap());
			break;

		case TIE:// Page 5 = Tie results
			text.setText("It's a cat's game! No one won!");
			rightButton.setText("Next");
			pPanel.add(text, BorderLayout.PAGE_START);
			pPanel.add(rightButton, BorderLayout.LINE_END);
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
					+ "Rounds Played: " + logic.getRound() + "\nPlayer Wins: "
					+ logic.getPlayerScore() + "\nComputer Wins: "
					+ logic.getCompScore() + "\nNumber of Ties: "
					+ logic.getTie() + "\nExit the window to close.");
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
		score.setText("          Round " + logic.getRound()
				+ "\n Player vs Computer" + "\n             "
				+ logic.getPlayerScore() + " : " + logic.getCompScore());
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
		for (int row = 1; row < logic.getMap().length + 1; row++) {
			for (int col = 1; col < logic.getMap()[row - 1].length + 1; col++) {
				c.weightx = .5;
				c.weighty = .5;
				c.gridx = col;
				c.gridy = row;
				if (logic.getMap()[row - 1][col - 1] == 's') {
					if (state == WIN || state == LOSE || state == TIE) {
						gPanel.add(new JTextArea("  "), c);
					} else {
						spaceButton = new JButton();
						spaceButton.setName("" + ((col - 1) * 10 + (row - 1)));
						spaceButton.addActionListener(listener);
						gPanel.add(spaceButton, c);
					}
				} else {
					gPanel.add(new JTextArea(" "
							+ logic.getMap()[row - 1][col - 1] + " "), c);
				}
			}
		}
		return gPanel;
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// LeftButton is Yes or O or Next
			// RightButton is No or X
			switch (state) {
			case GAME:
				logic.mark(logic.getPlayerMark(), Integer
						.parseInt(((JButton) arg0.getSource()).getName()));
				state = logic.checkWin();
				if (state == GAME) {
					logic.makeCompMove();
					state = logic.checkWin();
				}
				break;
			case INTRO:
				if (arg0.getSource() == rightButton) {
					state = ASK_MARK;
				}
				break;
			case ASK_MARK:
				if (arg0.getSource() == leftButton) {
					logic.setPlayerMark('O');
					movesFirst = true;
					logic.setCompMark('X');
					state = GAME;
				}
				if (arg0.getSource() == rightButton) {
					logic.setPlayerMark('X');
					movesFirst = false;
					logic.setCompMark('O');
					state = GAME;
				}
				break;
			case WIN:
				if (arg0.getSource() == rightButton) {
					logic.incrementPlayerScore();
					state = REPLAY;
				}
				break;
			case LOSE:
				if (arg0.getSource() == rightButton) {
					logic.incrementCompScore();
					state = REPLAY;
				}
				break;
			case TIE:
				if (arg0.getSource() == rightButton) {
					logic.incrementTie();
				}
				break;
			case REPLAY:
				if (arg0.getSource() == leftButton) {
					logic.incrementRound();
					state = ASK_MARK;
					logic.clearMap();
				}
				if (arg0.getSource() == rightButton) {
					state = END;
				}
				break;
			}
			paintGUI();
		}
	}
}
