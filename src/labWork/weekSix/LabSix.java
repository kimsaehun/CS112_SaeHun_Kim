/*
 * SAC CS 112
 * SAE HUN KIM
 * WEEK 6
 * LAB 6
 */

package labWork.weekSix;

import java.util.Scanner;

public class LabSix {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] moves = { "ROCK", "PAPER", "SCISSORS", "ROCK" };
		String yourMove;
		int numPlays, compWins = 0, userWins = 0, requiredWins = 999999999;
		boolean yourALoser = false;
		boolean cannotSpell = false;

		System.out.println("****************************************");
		System.out.println("Welcome to the land Rock Paper Scissors!");
		System.out.print(" How Many Times Do You Want to Play? ");
		numPlays = scan.nextInt();
		scan.nextLine();
		System.out.println("       LETS PLAY " + numPlays + " TIMES!!!");
		System.out.println("****************************************");
		for (int i = 0; i < numPlays; i++) {
			int plays = numPlays;
			if (plays % 2 == 1) {
				requiredWins = numPlays / 2 + 1;
			}
			System.out.println("\nROUND " + (i + 1));
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
			System.out.println("Player Versus Computer");
			System.out.println(yourMove.toUpperCase() + " vs. " + moves[ram]);
			if (moves[ram + 1].equals(yourMove.toUpperCase())) {
				System.out.println("You Win!");
				userWins++;
			} else if (moves[ram].equals(yourMove.toUpperCase())) {
				System.out.println("Its a Draw!");
				plays--;
			} else {
				System.out.println("You Lose!");
				compWins++;
			}

			System.out.println("PLAYER:   " + userWins);
			System.out.println("COMPUTER: " + compWins);

			if (compWins == requiredWins) {
				System.out.println("THE COMPUTER IS THE ULTIMATE WINNER!");
				break;
			} else if (userWins == requiredWins) {
				System.out.println("THE PLAYER IS THE ULTIMATE WINNER!");
				break;
			}
		}
		if (!(compWins == requiredWins || userWins == requiredWins)) {
			if (compWins > userWins) {
				System.out.println("THE COMPUTER IS THE ULTIMATE WINNER!");
			} else if (userWins > compWins) {
				System.out.println("THE PLAYER IS THE ULTIMATE WINNER!");
			} else {
				System.out.println("NOBODY IS THE WINNER!");
			}
		}
		System.out.println("Bye Bye!");
	}
}
