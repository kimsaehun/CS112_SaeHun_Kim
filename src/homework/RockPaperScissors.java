/**Sae Hun Kim
 * Sac CS 112
 * Week 5 homework
 * Rock Paper Scissors Game
 */
package homework;

import java.util.Scanner;

public class RockPaperScissors {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] moves = { "ROCK", "PAPER", "SCISSORS", "ROCK" };
		String yourMove;
		boolean yourALoser = false;
		boolean cannotSpell = false;

		System.out.println("****************************************");
		System.out.println("Welcome to the land Rock Paper Scissors!");
		System.out.println("           Play till you win");
		System.out.println("                   OR");
		System.out.println("       Play till you become a LOSER!");
		System.out.println("               LETS START!!!");
		System.out.println("****************************************");
		while (!yourALoser) {
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
			} else if (moves[ram].equals(yourMove.toUpperCase())) {
				System.out.println("Its a Draw!");
			} else {
				System.out.println("You Lose!");
			}

			System.out.println("Play again? y/n");
			int i = (int) (scan.nextLine().charAt(0));
			do {
				if (i == (int) 'n') {
					yourALoser = true;
				} else if (!(i == (int) 'y')) {
					System.out.print("INVALID INPUT! Enter 'y' or 'n'.");
					i = (int) (scan.nextLine().charAt(0));
				}
			} while (!(i == 121 || i == (int) 'n'));
		}
		System.out.println("Bye Bye!");
	}
}