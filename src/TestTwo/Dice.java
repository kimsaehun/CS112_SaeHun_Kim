package TestTwo;

import java.util.ArrayList;

public class Dice extends Die {// inheritance
	private ArrayList<Integer> history = new ArrayList<Integer>();
	private int value, numOfDices;

	public Dice() {
		super();
		numOfDices = 1;
	}

	public Dice(int numDices) {// overloading
		numOfDices = numDices;
	}

	@Override
	// overriding
	void rollDice() {
		value = (int) ((Math.random() * (6 * numOfDices)) + 1);
		history.add(value);
	}

	@Override
	public String toString() {
		return "You played with " + numOfDices + " Dice\nValue rolled:       "
				+ history;
	}

	public int getValue() {
		return value;
	}
}
