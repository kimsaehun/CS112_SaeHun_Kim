/*
 * Sae Hun Kim
 * SAC CS 112
 * Week 7 Homework
 */
package homework;

import java.util.ArrayList;
import java.util.Scanner;

public class WeekSevenHomework {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numOfNewrams = 0;

		int blah;// used to check players guess
		int hardMode = 0;// if 1, the computer will guess more wisely
		int upperLimit, lowerLimit;// used for hardMode
		int[] wins = { 0, 0 };// index 0 for player. index 1 for computer.
		ArrayList<Integer> playerGuesses = new ArrayList<Integer>();
		ArrayList<Integer> cpuGuesses = new ArrayList<Integer>();
		boolean playing = true, outOfRange = false, guessing = true;

		System.out.println("Time to play GUESS A NUMBER!");
		System.out
				.println("Type \"READYtoLOSE\", without quotes and in the same case, "
						+ "to play in hard mode: ");
		if (scan.nextLine().equals("READYtoLOSE")) {
			hardMode = 1;
			System.out.println("Command Accepted. Good Luck.");
		}
		while (playing) {
			int ram = (int) ((Math.random() * 20) + 1);
			numOfNewrams++;
			upperLimit = 20;
			lowerLimit = 1;
			guessing = true;
			int max = 20, min = 0;// max=closest number to ram that is greater
									// than
			// ram
			// min= closest number to ram that is less than ram
			while (guessing) {// player is still guessing for the given number
				// check computer guess
				if (hardMode == 0) {// random guess computer
					cpuGuesses
							.add((int) ((Math.random() * upperLimit) + lowerLimit));
				}
				if (hardMode == 1) {// smart guess computer. uses knowledge of
									// player's guess and its own guesses
									// to leave the player
									// devastated
					if (cpuGuesses.size() > 0) {
						// determine max
						if (cpuGuesses.get(cpuGuesses.size() - 1) > ram) {
							if (cpuGuesses.get(cpuGuesses.size() - 1) < max) {
								max = cpuGuesses.get(cpuGuesses.size() - 1);
							}
						}
						if (playerGuesses.get(playerGuesses.size() - 1) > ram) {
							if (playerGuesses.get(playerGuesses.size() - 1) < max) {
								max = playerGuesses
										.get(playerGuesses.size() - 1);
							}
						}
						// determine min
						if (cpuGuesses.get(cpuGuesses.size() - 1) < ram) {
							if (cpuGuesses.get(cpuGuesses.size() - 1) > min) {
								min = cpuGuesses.get(cpuGuesses.size() - 1);
							}
						}
						if (playerGuesses.get(playerGuesses.size() - 1) < ram) {
							if (playerGuesses.get(playerGuesses.size() - 1) > min) {
								min = playerGuesses
										.get(playerGuesses.size() - 1);
							}
						}
						upperLimit = max - min - 1;
						lowerLimit = min + 1;
					}
					cpuGuesses
							.add((int) ((Math.random() * upperLimit) + lowerLimit));
				}

				// check player's guess
				do {
					System.out
							.println("Guess a number between 1 and 20 inclusive: ");
					blah = scan.nextInt();
					scan.nextLine();
					if (blah < 1 || blah > 20) {
						outOfRange = true;
						System.out.println("Your Guess is out of range.");
					} else {
						outOfRange = false;
					}
				} while (outOfRange);
				playerGuesses.add(blah);
				if (playerGuesses.get(playerGuesses.size() - 1) < ram) {
					System.out.println("Your guess was too low.");
				} else if (playerGuesses.get(playerGuesses.size() - 1) > ram) {
					System.out.println("Your guess was too high.");
				} else {
					System.out.println("You Got It Right!");
					wins[0] += 1;
					guessing = false;
				}

				// print computer's guess
				System.out.println("Computer guessed the number "
						+ cpuGuesses.get(cpuGuesses.size() - 1));
				if (cpuGuesses.get(cpuGuesses.size() - 1) == ram) {
					System.out.println("The Computer Got It Right!");
					wins[1] += 1;
					guessing = false;
				}

				// check to see if someone won
				if (guessing == false) {
					break;
				}
				System.out.println("Guess again, y/n? ");
				int i = (int) (scan.nextLine().charAt(0));
				do {
					if (i == (int) 'n') {
						guessing = false;
						wins[1] += 1;
					}
					if (!(i == (int) 'y')) {
						System.out.print("INVALID INPUT! Enter 'y' or 'n'.");
						i = (int) (scan.nextLine().charAt(0));
					}
				} while (!(i == 121 || i == (int) 'n'));
			}
			int i;// used for input
			do {
				System.out.println("Guess for a new number, y/n? ");
				i = (int) (scan.nextLine().charAt(0));
				if (i == (int) 'n') {
					playing = false;
				}
				if (!((i == (int) 'y') || (i == (int) 'n'))) {
					System.out.print("INVALID INPUT! Enter 'y' or 'n'");
				} else {
					System.out.println("Good Luck with The New Number!");
				}
			} while (!(i == (int) 'y' || i == (int) 'n'));
		}

		System.out.println("Total number of numbers guessed at: "
				+ numOfNewrams);
		System.out.print("List of Player's guesses: ");
		System.out.println(playerGuesses);
		System.out.println("Number of player wins: " + wins[0]);
		System.out.print("List of Compuer's guesses: ");
		System.out.println(cpuGuesses);
		System.out.println("Number of computer wins: " + wins[1]);
		if (wins[0] > wins[1]) {
			System.out.println("Congratulaions! You WIN!");
		} else if (wins[1] > wins[0]) {
			System.out.println("YOU LOSE!");
		} else {
			System.out.println("ITS A TIE!");
		}
	}
}
// 3 5 7
//