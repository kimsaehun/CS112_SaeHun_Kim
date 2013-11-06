/*
 * Sae Hun Kim
 * CS 112 Final Project
 * Tic Tac Toe game
 */

package FinalProject;

import java.util.ArrayList;

public class TicTacToe {
	private char[][] map = { { ' ', '|', ' ', '|', ' ' },
			{ ' ', '|', ' ', '|', ' ' }, { ' ', '|', ' ', '|', ' ' } };
	private int round = 0;
	private int playerScore = 0, compScore = 0;
	// arraylist to hold the coordinates of open spaces in the tic tac toe map
	private ArrayList<Integer> availableMoves = new ArrayList<Integer>();

	public void printGame() {
		printScore();
		printMap();
	}

	public void printScore() {
		System.out.println("      Round " + round);
		System.out.println(" Player vs Computer");
		System.out.println("       " + playerScore + " : " + compScore);
	}

	public void printMap() {
		System.out.println("    x: 1 2 3");
		for (int row = 0; row < 3; row++) {
			System.out.print("y:" + (row + 1) + "    ");
			for (int col = 0; col < 5; col++) {
				System.out.print(map[row][col]);
			}
			System.out.println();
		}
	}

	public boolean isValidCoord(String coord) {
		// returns true if the players inputCoord was valid
		if ((Character.getNumericValue(coord.charAt(1)) < 4)
				&& (Character.getNumericValue(coord.charAt(1)) > 0)
				&& (Character.getNumericValue(coord.charAt(3)) < 4)
				&& (Character.getNumericValue(coord.charAt(3)) > 0)) {
			return true;
		} else {
			return false;
		}
	}

	public int convertCoord(String coord) {
		// converts input coordinates to tic tac toe map coordinates as a 2
		// digit integer where the x value(the column) is in the ten's place and
		// the y value(the row) is in the one's place
		int mapCoord = (Character.getNumericValue(coord.charAt(1)) * 2 - 2) * 10;
		mapCoord += (Character.getNumericValue(coord.charAt(3)) - 1);
		return mapCoord;
	}

	public boolean isMarked(int coord) {
		// the x value would the column and the y value would be the row
		int col = coord / 10;// the x value
		int row = coord - (col * 10);// the y value
		if (map[row][col] == ' ') {
			return false;
		} else {
			return true;
		}
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
				if (map[row][col] == ' ') {
					availableMoves.add(col * 10 + row);
				}
			}
		}
		if (availableMoves.size() != 0) {
			mark(mark,
					availableMoves.get((int) (Math.random() * (availableMoves
							.size()))));
			availableMoves.clear();// clear the arrayList or it will keep on
									// growing
		}
	}

	public char checkWin() {// check to see if anyone won or if its a tie
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 5; col++) {
				if (map[row][col] == ' ') {
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
				if (map[row][0] != ' ') {
					// checks if there are 3 of the same marks in a single row
					return map[row][0];
				}
			}
		}
		for (int col = 0; col < 5; col += 2) {
			if (map[0][col] == map[1][col] && map[1][col] == map[2][col]) {
				// checks if there are 3 of the same marks in a single
				// column
				if (map[0][col] != ' ') {
					// checks if there are 3 of the same marks in a single row
					return map[0][col];
				}
			}
		}
		if (map[1][2] == map[0][0] && map[1][2] == map[2][4]) {
			// checks \ diagonal
			if (map[1][2] != ' ') {
				return map[1][2];
			}
		}
		if (map[1][2] == map[0][4] && map[1][2] == map[2][0]) {
			// checks / diagonal
			if (map[1][2] != ' ') {
				return map[1][2];
			}
		}

		return 'z';
	}

	public void increment(int arg0) {// parameter are integers representing what
		// to increment.
		switch (arg0) {
		case 0:
			round++;
			break;
		case 1:
			playerScore++;
			break;
		case 2:
			compScore++;
			break;
		}
	}

	public void mapClear() {// clears the map or a new game
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 5; col += 2) {
				map[row][col] = ' ';
			}
		}
	}

	public int getRound() {
		return round;
	}
}
