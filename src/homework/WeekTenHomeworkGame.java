/*
 * Sae Hun Kim
 * Cs 112
 * Week ten homework dice game
 */

package homework;

import java.util.ArrayList;
import java.util.Scanner;

public class WeekTenHomeworkGame {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		WeekTenHomework dice;
		boolean playing = true;
		int round = 1, numOfDices, pWins = 0, pLosses = 0, cWins = 0, cLosses = 0, ties = 0;
		ArrayList<Integer> pGuesses = new ArrayList<Integer>();
		ArrayList<Integer> cGuesses = new ArrayList<Integer>();

		System.out.println("Welcome to the Dice Game!");
		System.out.println("Guess the average value of the dices rolled!");
		System.out.println("All dices have 6 values.");
		System.out.print("How many dices do you want to play with? ");
		// assumes input will be an integer
		dice = new WeekTenHomework(numOfDices = scan.nextInt());
		scan.nextLine();
		System.out.println("Lets START!");
		while (playing) {
			System.out.println("ROUND " + round);
			dice.Throw(numOfDices, 1);// throw the num of dices but
										// only 1 times

			// get the guesses from computer and player
			System.out.println("Guess a number! ");// assumes the input is
													// between 1-6
			pGuesses.add(scan.nextInt());
			scan.nextLine();
			cGuesses.add((int) (Math.random() * 6 + 1));
			System.out.println("The computer guessed "
					+ cGuesses.get(round - 1));

			// calculate who wins
			if ((pGuesses.get(round - 1) == dice.getReturnValue())
					&& (cGuesses.get(round - 1) == dice.getReturnValue())) {
				System.out
						.println("Both you and the computer got it right! Its a tie!");
				ties++;
			} else {
				if (pGuesses.get(round - 1) == dice.getReturnValue()) {
					System.out.println("You got it right!");
					pWins++;
				} else {
					System.out.println("You got it wrong!");
					pLosses++;
				}
				if (cGuesses.get(round - 1) == dice.getReturnValue()) {
					System.out.println("The computer got it right!");
					cWins++;
				} else {
					System.out.println("The computer got it wrong!");
					cLosses++;
				}
			}

			System.out.print("Do you want to play again, y/n? ");
			// assumes input will start with a 'y' or a 'n'
			if (scan.nextLine().charAt(0) == 'n') {
				playing = false;
			} else {
				round++;
			}
		} // end of while(playing) loop
		System.out.println("Here are the results");
		System.out.println("Total number of rounds: " + round);
		System.out.println("Player Wins: " + pWins + "\tPlayer Losses: "
				+ pLosses);
		System.out.println("Computer Wins: " + cWins + "\tComputer Losses: "
				+ cLosses);
		System.out.println("Ties: " + ties);
		System.out.print("Your guesses were:           ");
		for (int i = 0; i < pGuesses.size(); i++) {
			System.out.print(pGuesses.get(i) + " ");
		}
		System.out.println();
		System.out.print("The computer's guesses were: ");
		for (int i = 0; i < cGuesses.size(); i++) {
			System.out.print(cGuesses.get(i) + " ");
		}
		System.out.println();
		System.out.print("The correct values were:     ");
		dice.getHistory();
	}
}
