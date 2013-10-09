/*
 * Sae Hun Kim
 * SAC CS 112
 * Week 7 lab 2
 */
package labWork.WeekSeven;

import java.util.Scanner;

public class LabTwo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] moves = { "ROCK", "PAPER", "SCISSORS", "ROCK" };
		String[] cpuMoves = new String[25];
		String[] userMoves = new String[25];
		String yourMove;
		int compWins = 0, userWins = 0, count = 0;
		boolean cannotSpell = false, playing = true;

		System.out.println("****************************************");
		System.out.println("Welcome to the land Rock Paper Scissors!");
		System.out.println("              LETS PLAY");
		System.out.println("****************************************");
		while (playing) {
			do {
				System.out
						.print("Choose your move: Rock, Paper, or Scissors? ");
				yourMove = scan.nextLine();
				if (!(yourMove.toLowerCase().equals("rock")
						|| yourMove.toLowerCase().equals("paper") || yourMove
						.toLowerCase().equals("scissors"))) {
					System.out
							.println("INVALID INPUT SPELL YOUR MOVE CORRECTLY!!!");
					cannotSpell = true;
				} else {
					cannotSpell = false;
				}
			} while (cannotSpell);

			int ram = (int) (Math.random() * 3);
			cpuMoves[count] = moves[ram];
			userMoves[count] = yourMove.toUpperCase();
			System.out.println("Player Versus Computer");
			System.out.println(yourMove.toUpperCase() + " vs. " + moves[ram]);
			if (moves[ram + 1].equals(yourMove.toUpperCase())) {
				System.out.println("You Win!");
				userWins++;
			} else if (moves[ram].equals(yourMove.toUpperCase())) {
				System.out.println("Its a Draw!");
			} else {
				System.out.println("You Lose!");
				compWins++;
			}

			System.out.println("Play again? y/n");
			int i = (int) (scan.nextLine().charAt(0));
			do {
				if (i == (int) 'n') {
					playing = false;
				} else if (!(i == (int) 'y')) {
					System.out.print("INVALID INPUT! Enter 'y' or 'n'.");
					i = (int) (scan.nextLine().charAt(0));
				}
			} while (!(i == 121 || i == (int) 'n'));
			count++;
		}
		if (compWins > userWins) {
			System.out.println("THE COMPUTER IS THE ULTIMATE WINNER!");
		} else if (userWins > compWins) {
			System.out.println("THE PLAYER IS THE ULTIMATE WINNER!");
		} else {
			System.out.println("NOBODY IS THE WINNER!");
		}

		System.out.print("Player moves: ");
		for (int n = 0; n < count; n++) {
			System.out.print(userMoves[n] + " ");
		}
		System.out.print("\nComputer moves: ");
		for (int n = 0; n < count; n++) {
			System.out.print(cpuMoves[n] + " ");
		}
		System.out.println("Bye Bye!");
	}
}
