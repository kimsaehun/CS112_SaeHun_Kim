/*
 * Sae Hun Kim
 * SAC CS 112
 * week 9 homework game
 */
package homework;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WeekNineGame {
	public static void main(String[] args) {
		WeekNineDice die;
		Scanner scan = new Scanner(System.in);
		boolean playing = true;
		int round = 1, wins = 0, ties = 0;
		String ans;// used to store input of a string
		int ansInt = 0;// used to store input of an int
		boolean invalid = true;// used to check the input
		ArrayList<Integer> guesses = new ArrayList<Integer>(); // keeps track of
																// guesses

		System.out.println("Lets play a game with a dice where you guess "
				+ "the number rolled!");
		System.out.print("Do you want to create your own custom die "
				+ "(default is 6 sides), y/n?: ");
		if (scan.nextLine().toLowerCase().charAt(0) == 'y') {
			System.out.println("How many sides do you want on the die?\n"
					+ "Enter a digit: ");
			while (invalid) {
				System.out.println("Guess what number was rolled: ");
				try {
					ansInt = scan.nextInt();
					if (ansInt < 1) {
						System.out.print("Invalid input. Enter a digit"
								+ " greater than or equal to 1: ");
					} else {
						invalid = false;
					}
				} catch (InputMismatchException e) {
					System.out.print("Invalid input. Enter a digit"
							+ " greater than or equal to 1: ");
				}
			}
			// clean up after the input checking process
			scan.nextLine();// clear the enter key
			invalid = true;
			die = new WeekNineDice(ansInt);
		} else {
			System.out.println("You chose the default 6 sided die.");
			die = new WeekNineDice();
		}

		while (playing) {// start of game
			die.roll();
			System.out.println("ROUND " + round + " START");
			System.out.println("The dice was rolled!");
			while (invalid) {
				System.out.println("Guess what number was rolled: ");
				try {
					ansInt = scan.nextInt();
					if (ansInt < 1 || ansInt > die.getSides()) {
						System.out.println("Invalid input. Enter a digit "
								+ "between 1 and " + die.getSides());
					} else {
						invalid = false;
					}
				} catch (InputMismatchException e) {
					System.out.println("Invalid input. Enter a digit "
							+ "between 1 and " + die.getSides());
				}
			}
			// clean up after the input checking process
			scan.nextLine();// clear the enter key
			invalid = true;
			guesses.add(ansInt);

			die.guess();
			System.out.println("The computer guessed a "
					+ die.getGuesses(round - 1));// round - 1 because the array
													// list starts at 0

			// calculate wins and ties
			if (!(die.getGuesses(round - 1) == die.getNum() && guesses
					.get(round - 1) == die.getNum())) {
				if (guesses.get(round - 1) == die.getNum()) {
					System.out.println("You got it correct!");
					wins++;
				} else {
					System.out.println("Bzzz! You got it wrong!");
				}
				if (die.getGuesses(round - 1) == die.getNum()) {
					System.out.println("The computer got it correct!");
					die.win();
				} else {
					System.out.println("The computer got it wrong!");
				}
			} else {
				System.out.println("The computer and you both got it right! "
						+ "It's a tie!");
				ties++;
			}

			System.out.print("Play again, y/n? ");
			System.out.print("Do you want to play again, y/n? ");
			ans = scan.nextLine();
			while (!(ans.toLowerCase().charAt(0) == 'y' || ans.toLowerCase()
					.charAt(0) == 'n')) {
				System.out.println("Invalid input. Try again.");
				System.out.print("Do you want to play again, y/n? ");
				ans = scan.nextLine();
			}
			if (ans.toLowerCase().charAt(0) == 'y') {
				System.out.println("Time for the next round!");
				round++;
			} else {
				playing = false;
			}
		}// end of game
		System.out.println("Here are the results");
		System.out.println("Number of rounds played: " + round);
		System.out.println("Number of ties: " + ties);
		System.out.println("Player wins: " + wins);
		System.out.printf("Player win percentage: %%%.2f\n",
				((float) wins / round) * 100);
		System.out.println("Computer wins: " + die.getWins());
		System.out.printf("Computer win percentage: %%%.2f\n",
				((float) die.getWins() / round) * 100);
	}
}
