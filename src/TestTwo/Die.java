/*
 * Sae Hun Kim
 * CS 112
 * Week 12 Test 2
 */

package TestTwo;

import java.util.ArrayList;

public abstract class Die {
	private ArrayList<Integer> history = new ArrayList<Integer>();
	private int value;

	public Die() {
	}

	abstract void rollDice();

	@Override
	public String toString() {
		return "Dice " + history;
	}
}
