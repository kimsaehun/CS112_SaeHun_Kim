/*
 * Sae Hun Kim
 * SAC CS 112
 * week 9 homework game
 */
package homework;

import java.util.ArrayList;
import java.util.Scanner;

public class WeekNineGame {
	public static void main(String[] args) {
		WeekNineDice die;
		Scanner scan = new Scanner(System.in);
		boolean playing = true;
		int round = 1, wins = 0, tie = 0;
		double winPer; // used to calculate win percentage
		ArrayList<Integer> guesses = new ArrayList<Integer>(); // keeps track of
																// guesses

		System.out.println("Lets play a game with a dice where you guess "
				+ "the number rolled!");
		System.out.println("Do you want to create your own custom die "
				+ "(default is 6 sides), y/n?: ");
		if (scan.nextLine().toLowerCase().charAt(0) == 'y') {
			System.out.println("How many sides do you want on the die?\n"
					+ "Enter a number: ");
			die = new WeekNineDice(scan.nextInt());
		} else {
			System.out.println("You choose the default 6 sided die.");
			die = new WeekNineDice();
		}

		while (playing) {
			die.roll();
			System.out.println("The dice was rolled!\n"
					+ "Guess what number it rolled: ");
			guesses.add(scan.nextInt());
			die.guess();
			System.out.println("The computer guessed a "
					+ die.getGuesses(round - 1));// round - 1 because the array
													// list starts at 0
			if (guesses.get(round - 1) == die.getNum()) {
				System.out.println("You got it correct!");
				wins++;
			} else {
				System.out.println();
			}
		}
	}
}
