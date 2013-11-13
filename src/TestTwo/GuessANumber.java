/*
 * Sae Hun Kim
 * Week 12 Test 2
 * Main program for the Guess a number game
 */

package TestTwo;

import java.util.ArrayList;
import java.util.Scanner;

public class GuessANumber {
	public static void main(String[] args) {
		Dice dice;
		ArrayList<Integer> userHistory = new ArrayList<Integer>();
		ArrayList<Integer> compHistory = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		boolean playing = true;
		int numOfDice, guess, round = 0, userWin = 0, compWin = 0, tie = 0;
		String ans;

		System.out.println("Welcome to the GuessANumber Game!");
		System.out
				.print("How many dices do you want to play with, 1, 2, or 3? ");
		while ((numOfDice = scan.nextInt()) < 1 || numOfDice > 3) {
			System.out.println("Invalid input, try again.");
		}
		dice = new Dice(numOfDice);

		while (playing) {
			round++;
			System.out.println("ROUND " + round);

			// roll dice and make computer move
			dice.rollDice();
			compHistory.add((int) ((Math.random() * (6 * numOfDice)) + 1));

			// user input and show computer guess
			System.out.println("Guess a number between 1 and "
					+ (6 * numOfDice));
			while ((guess = scan.nextInt()) < 1 || guess > (6 * numOfDice)) {
				scan.nextLine();
				System.out.println("Invalid input, try again.");
			}
			userHistory.add(guess);
			System.out.println("The computer guessed "
					+ compHistory.get(round - 1));

			// check if someone got the number correct
			if (dice.getValue() == guess
					&& dice.getValue() == compHistory.get(round - 1)) {
				System.out
						.println("It's a tie! Both you and the computer got it right!");
				tie++;
			} else if (dice.getValue() == guess) {
				System.out.println("You got it right!");
				userWin++;
			} else if (dice.getValue() == compHistory.get(round - 1)) {
				System.out
						.println("You got it wrong but the computer got it right!");
				compWin++;
			} else {
				System.out.println("No one got it right!");
			}

			// ask for replay
			scan.nextLine(); // consumes the /n character
			System.out.print("Do you want to play again, y/n? ");
			ans = scan.nextLine();
			while (!(ans.toLowerCase().charAt(0) == 'y' || ans.toLowerCase()
					.charAt(0) == 'n')) {
				System.out.println("Invalid input. Try again.");
				System.out.print("Do you want to play again, y/n? ");
				ans = scan.nextLine();
			}
			if (ans.toLowerCase().charAt(0) == 'n') {
				playing = false;
			}
		}// end of while(playing) loop

		// print results
		System.out.println("Rounds played: " + round);
		System.out.println("Your wins: " + userWin + "\tComputer wins: "
				+ compWin + "\tNumber of ties: " + tie);
		System.out.println(dice);
		System.out.println("Your guesses:       " + userHistory);
		System.out.println("Computer's guesses: " + compHistory);

	}
}
