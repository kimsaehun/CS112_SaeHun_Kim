/*
 * Sae Hun Kim
 * CS 112 final Project
 * Tic Tac Toe with GUI
 * Logic class
 */

package FinalProject;

import java.util.ArrayList;

public class TTTwithGUILogic {
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
	private int round = 1, playerScore = 0, compScore = 0, tie = 0;;
	private char[][] map = { { 's', '|', 's', '|', 's' },
			{ 's', '|', 's', '|', 's' }, { 's', '|', 's', '|', 's' } };
	private char playerMark, compMark;
	private ArrayList<Integer> availableMoves = new ArrayList<Integer>();

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

	public int checkWin() {// check to see if anyone won or if its a tie
		for (int row = 0; row < 3; row++) {
			if (map[row][0] == map[row][2] && map[row][2] == map[row][4]) {
				// checks if there are 3 of the same marks in a single row
				if (map[row][0] == playerMark) {
					return WIN;
				} else if (map[row][0] == compMark) {
					return LOSE;
				}
			}
		}
		for (int col = 0; col < 5; col += 2) {
			if (map[0][col] == map[1][col] && map[1][col] == map[2][col]) {
				// checks if there are 3 of the same marks in a single
				// column
				if (map[0][col] == playerMark) {
					return WIN;
				} else if (map[0][col] == compMark) {
					return LOSE;
				}
			}
		}
		if (map[1][2] == map[0][0] && map[1][2] == map[2][4]) {
			// checks \ diagonal
			if (map[1][2] == playerMark) {
				return WIN;
			} else if (map[1][2] == compMark) {
				return LOSE;
			}
		}
		if (map[1][2] == map[0][4] && map[1][2] == map[2][0]) {
			// checks / diagonal
			if (map[1][2] == playerMark) {
				return WIN;
			} else if (map[1][2] == compMark) {
				return LOSE;
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
			return TIE;
		}
		availableMoves.clear();// clear the arrayList or it will keep on growing
		return GAME;
	}

	public void clearMap() {// clears the map or a new game
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 5; col += 2) {
				map[row][col] = 's';
			}
		}
	}

	public void incrementRound() {
		round++;
	}

	public void incrementPlayerScore() {
		playerScore++;
	}

	public void incrementCompScore() {
		compScore++;
	}

	public void incrementTie() {
		tie++;
	}

	public char[][] getMap() {
		return map;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public int getPlayerScore() {
		return playerScore;
	}

	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}

	public int getCompScore() {
		return compScore;
	}

	public int getTie() {
		return tie;
	}

	public void setCompScore(int compScore) {
		this.compScore = compScore;
	}

	public char getPlayerMark() {
		return playerMark;
	}

	public char getCompMark() {
		return compMark;
	}

	public void setPlayerMark(char playerMark) {
		this.playerMark = playerMark;
	}

	public void setCompMark(char compMark) {
		this.compMark = compMark;
	}
}
