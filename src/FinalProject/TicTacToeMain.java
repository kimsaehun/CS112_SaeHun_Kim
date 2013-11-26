/*
 * Sae Hun Kim
 * CS 112
 * Final Project Tic Tac Toe game
 * 
 * This class is the main program
 */

package FinalProject;

import java.util.Scanner;

public class TicTacToeMain {
	public static void main(String[] args) {
		// constants are used as arguments for the method increment(arg0) in the
		// TicTacToe class
		final int ROUND = 0;
		final int PLAYERSCORE = 1;
		final int COMPSCORE = 2;
		TicTacToe game = new TicTacToe();
		String inputCoord;// coordinated inputed by player
		char playerMark, compMark, result;// result is used to see who won
		Scanner scan = new Scanner(System.in);
		boolean playing = true, inRound = true;
		boolean movesFirst;// set true if player moves first

		System.out.println("Get Ready For Some Tic Tac Toe!");
		while (playing) {
			System.out.println("Do you want to be X or O?\n"
					+ "(Note: X goes first)");
			while (((playerMark = scan.nextLine().toUpperCase().charAt(0)) != 'X')
					&& (playerMark != 'O')) {
				System.out.println("Invalid input. Try again: ");
			}
			if (playerMark == 'X') {
				compMark = 'O';
				movesFirst = true;
			} else {
				playerMark = 'O';
				compMark = 'X';
				movesFirst = false;
			}
			System.out.println("Lets GO!");
			game.increment(ROUND);
			while (inRound) {
				if (movesFirst) {
					game.printGame();
					System.out.print("Enter the coordinates of your move\n"
							+ "(example: (1,2) for the upper middle box and "
							+ "(1,3) for the lower left box): ");
					while ((!game.isValidCoord(inputCoord = scan.nextLine()))
							|| (game.isMarked(game.convertCoord(inputCoord)))) {
						System.out.println("Invalid input. Make sure that you "
								+ "included the parenthesis and there are no "
								+ "spaces in your input and the space is not "
								+ "marked.");
					}
					game.mark(playerMark, game.convertCoord(inputCoord));
					// check to see if the player won
					result = game.checkWin();
					if (result == playerMark) {
						inRound = false;
						game.increment(PLAYERSCORE);
					} else if (result == compMark) {
						inRound = false;
						game.increment(COMPSCORE);
					} else if (result == 't') {
						inRound = false;
					} else { // if the player didn't win te computer gets to
								// make its move
						game.makeCompMove(compMark);// computer move
					}
				} else {// player moves second
					game.makeCompMove(compMark);// computer move
					game.printGame();
					// check to see if the computer won
					result = game.checkWin();
					if (result == playerMark) {
						inRound = false;
						game.increment(PLAYERSCORE);
					} else if (result == compMark) {
						inRound = false;
						game.increment(COMPSCORE);
					} else if (result == 't') {
						inRound = false;
					} else {// if the computer didn't win the player gets to
							// play
						System.out.print("Enter the coordinates of your move\n"
								+ "(example: (1,2) for the upper middle "
								+ "box and (1,3) for the lower left box): ");
						while ((!game
								.isValidCoord(inputCoord = scan.nextLine()))
								|| (game.isMarked(game.convertCoord(inputCoord)))) {
							System.out.println("Invalid input. Make sure that "
									+ "you included the parenthesis and there "
									+ "are no spaces in your input and the "
									+ "space is not marked.");
						}
						game.mark(playerMark, game.convertCoord(inputCoord));
					}
				}
				game.printMap();
				if (result == playerMark) {
					System.out.println("Great Job! You Won!");
				} else if (result == compMark) {
					System.out.println("Sorry but you lost! The computer "
							+ "beat you!");
				} else if (result == 't') {
					System.out.println("It's a cat's game! No one won!");
				}
			}// end while(inRound) loop

			System.out.print("Do you want to play again, y/n? ");
			while (playing) {
				char ans = scan.nextLine().toLowerCase().charAt(0);
				if (ans != 'y' && ans != 'n') {
					System.out.println("Invalid input. Please try again.");
					System.out.print("Do you want to play again, y/n? ");
				} else if (ans == 'y') {
					System.out.println("Ok! Get for the next round!");
					break;
				} else if (ans == 'n') {
					playing = false;
				}
			}
			game.mapClear();
			inRound = true;
		}// end while(playing) loop

		System.out.println("All right then, we'll see you next time!");

	}
}
