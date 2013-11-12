/*
 * Sae Hun Kim
 * Cs 112
 * lab 8 week 11
 * also used for homework 11
 */

package labWork.WeekEleven;

import java.util.ArrayList;

public class LabEight extends LabSeven {
	// Tripple dice with history class
	private ArrayList<Integer> values = new ArrayList<Integer>();;
	private int numThrows = 0, dice;

	public LabEight() {
		super();
		values = new ArrayList<Integer>();
	}

	@Override
	public int Throw() {
		values.add(super.Throw());
		numThrows++;
		return values.get(values.size() - 1);
	}

	@Override
	public String toString() {
		return "Num of throws: " + numThrows + "\nList of values: " + values;
	}

	// implemented methods for homework 11
	public LabEight clone() {
		return this;
	}

	public boolean equal(LabEight arg0) {
		if (this.equals(arg0)) {
			return true;
		} else {
			return false;
		}
	}

	public LabEight(int dices) {
		super(dices);
		dice = dices;
	}
}
