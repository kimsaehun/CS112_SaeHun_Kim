/*
 * Sae Hun Kim
 * Sac CS 112
 * Week 9 lab 5
 * 
 * The OddOrEven class used was the fourth lab
 */
package labWork.WeekNine;

import java.util.Scanner;

public class LabFiveOddOrEvenGame {
	public static void main(String[] args) {
		LabFourOddOrEven ran;// using the lab four odd or even class
		int round = 1;
		Scanner scan = new Scanner(System.in);
		boolean playing = true, cWins, uWins;
		String ans;
		int cpuWins = 0, userWins = 0, ties = 0;
		String[] userGuesses = new String[100];
		int[] cpuGuesses = new int[100];
		System.out.println("Guess whether the random number is odd or even!");
		while (playing) {
			ran = new LabFourOddOrEven();
			// generate computer guess and calculate if it got it right or not
			cpuGuesses[round - 1] = (int) ((Math.random() * 2) + 1);
			if (cpuGuesses[round - 1] == ran.getValue()) {
				cWins = true;
			} else {
				cWins = false;
			}

			System.out.println("Random Number " + round);
			System.out.print("Is the number odd or even? ");
			ans = scan.nextLine();
			while (!(ans.toLowerCase().equals("odd") || ans.toLowerCase()
					.equals("even"))) {
				System.out.println("Invalid input. Try again. ");
				System.out.print("Is the number odd or even? ");
				ans = scan.nextLine();
			}

			// check to see if user got it right
			userGuesses[round - 1] = ans;
			if (ans.toLowerCase().equals("odd")) {
				if (ran.getValue() % 2 == 1) {
					System.out.println("You got it right!");
					uWins = true;
				} else {
					System.out.println("You got it wrong!");
					uWins = false;
				}
			} else {
				if (ran.getValue() % 2 == 0) {
					System.out.println("You got it right!");
					uWins = true;
				} else {
					System.out.println("You got it wrong!");
					uWins = false;
				}
			}

			// print out computer guess
			System.out.printf("The computer guessed: %s\n",
					cpuGuesses[round - 1] == 1 ? "odd" : "even");
			if (cWins) {
				System.out.println("The computer got it right!");
			} else {
				System.out.println("The computer got it wrong!");
			}

			// calculate who won and who didn't
			if (cWins && uWins) {
				cpuWins++;
				userWins++;
				cWins = false;// set to false so an extra
				uWins = false;// win isn't added
				ties++;
			}
			if (cWins) {
				cpuWins++;
			}
			if (uWins) {
				userWins++;
			}

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
			} else {// print out results
				playing = false;
				System.out.println("All right then. Here are the results: ");
				System.out.println("Number or rounds played: " + round);
				if (cpuWins == userWins) {
					System.out.println("IT'S A TIE! NO ONE WON IN THE END!");
				} else {
					System.out.printf("Ultimate Winner: %s\n",
							cpuWins > userWins ? "COMPUTER" : "PLAYER");
				}
				System.out.println("Player Wins: " + userWins
						+ "\tComputer Wins: " + cpuWins + "\tTies: " + ties);
				System.out.print("Player guesses: ");
				for (int i = 0; i < userGuesses.length; i++) {
					if (userGuesses[i] == null) {
						break;
					}
					System.out.print(userGuesses[i] + " ");
				}
				System.out.print("\nComputer guesses: ");
				for (int i = 0; i < cpuGuesses.length; i++) {
					if (cpuGuesses[i] == 0) {
						break;
					}
					if (cpuGuesses[i] == 1) {
						System.out.print("odd ");
					} else {
						System.out.print("even ");
					}
				}
			}
		}
	}
}
