/*
 * Sae Hun Kim
 * Cs 112
 * lab 8 week 11
 */

package labWork.WeekEleven;

import java.util.ArrayList;

public class LabEight extends LabSeven {
	private ArrayList<Integer> values = new ArrayList<Integer>();;
	private int numThrows = 0;

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

}
