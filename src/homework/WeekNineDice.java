/*
 * Sae Hun Kim
 * SAC CS 112
 * Week 9 homework dice class
 * this dice class includes the dice AND the computer opponent
 */

package homework;

import java.util.ArrayList;

public class WeekNineDice {
	private int sides;// number of sides on the die
	private int num;// the number that was rolled
	private int wins = 0;
	private int losses = 0;

	// used to store computer's guesses
	private ArrayList<Integer> guesses = new ArrayList<Integer>();

	public WeekNineDice() {// default die
		sides = 6;
		num = (int) (Math.random() * sides + 1);
	}

	public WeekNineDice(int arg0) {// custom die
		sides = arg0;
		num = (int) (Math.random() * sides + 1);
	}

	public void roll() {
		num = (int) (Math.random() * sides + 1);
	}

	public int getSides() {
		return sides;
	}

	public int getNum() {
		return num;
	}

	public void guess() {// the computer's guess
		guesses.add((int) (Math.random() * sides + 1));
	}

	public int getGuesses(int index) {// returns the computer's guess at the
										// index
		return guesses.get(index);
	}

	public void win() {
		wins++;
	}

	public int getWins() {
		return wins;
	}

	public void lose() {
		losses++;
	}

	public int getLosses() {
		return losses;
	}
}