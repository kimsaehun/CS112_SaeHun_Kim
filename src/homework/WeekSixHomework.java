package homework;

import javax.swing.JOptionPane;

public class WeekSixHomework {

	public static void main(String[] args) {

		String[] moves = { "ROCK", "PAPER", "SCISSORS", "ROCK" };
		String yourMove;
		boolean cannotSpell = true;
		int plays, numPlays, ties = 0, compWins = 0, userWins = 0, requiredWins = -1;

		String intro = JOptionPane
				.showInputDialog("WELCOME TO THE LAND OF ROCK, PAPER, SCISSORS!\n"
						+ "HOW MANY ROUNDS DO YOU WANT TO PLAY?");
		plays = numPlays = Integer.parseInt(intro);

		JOptionPane.showMessageDialog(null, "ALL RIGHT! WE'LL PLAY " + numPlays
				+ " ROUNDS!\n" + "HERE WE GO!", "Rock Paper Scissors",
				JOptionPane.PLAIN_MESSAGE);

		for (int i = 0; i < numPlays; i++) {
			requiredWins = plays / 2 + 1;

			do {
				String round = JOptionPane
						.showInputDialog("CHOOSE YOUR MOVE: \nROCK, PAPER, OR SCISSORS?");
				yourMove = round;
				if (!(yourMove.toUpperCase().equals("ROCK")
						|| yourMove.toUpperCase().equals("PAPER") || yourMove
						.toUpperCase().equals("SCISSORS"))) {
					JOptionPane.showMessageDialog(null,
							"INVALID INPUT\nSPELL YOUR CHOICE CORRECTLY",
							"You can't spell.", JOptionPane.PLAIN_MESSAGE);
					cannotSpell = true;
				} else {
					cannotSpell = false;
				}
			} while (cannotSpell);

			int ram = (int) (Math.random() * 3);
			if (moves[ram + 1].equals(yourMove.toUpperCase())) {
				JOptionPane.showMessageDialog(null, "Player Versus Computer\n"
						+ yourMove.toUpperCase() + " vs. " + moves[ram]
						+ "\nYou Win!", "Round " + (i + 1),
						JOptionPane.PLAIN_MESSAGE);
				userWins++;
			} else if (moves[ram].equals(yourMove.toUpperCase())) {
				JOptionPane.showMessageDialog(null, "Player Versus Computer\n"
						+ yourMove.toUpperCase() + " vs. " + moves[ram]
						+ "\nIt's a Draw!", "Round " + (i + 1),
						JOptionPane.PLAIN_MESSAGE);
				ties++;
				plays--;
			} else {
				JOptionPane.showMessageDialog(null, "Player Versus Computer\n"
						+ yourMove.toUpperCase() + " vs. " + moves[ram]
						+ "\nYou Lose!", "Round " + (i + 1),
						JOptionPane.PLAIN_MESSAGE);
				compWins++;
			}

			JOptionPane.showMessageDialog(null, "Player Score: " + userWins
					+ "\nComputer Score: " + compWins + "\nTies: " + ties,
					" Scores", JOptionPane.PLAIN_MESSAGE);

			if (compWins == requiredWins || userWins == requiredWins) {
				break;
			}
		}
		if (compWins > userWins) {
			JOptionPane.showMessageDialog(null,
					"The Computer Is the Ultimate Winner!", "You're a Loser!",
					JOptionPane.PLAIN_MESSAGE);
		} else if (userWins > compWins) {
			JOptionPane.showMessageDialog(null, "You're the Ultimate Winner!",
					"You're a Winner!", JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Nobody Wins!",
					"Worst Game Ever", JOptionPane.PLAIN_MESSAGE);
		}
	}
}