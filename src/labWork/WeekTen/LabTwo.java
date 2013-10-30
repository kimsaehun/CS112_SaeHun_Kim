/*
 * Sae Hun Kim
 * CS 112
 * Week ten lab 2
 */

package labWork.WeekTen;

public class LabTwo {
	private int value;

	public int Throw() {
		return (value = (int) ((Math.random() * 6) + 1));
	}

	public int Throw(int rolls) {// get the average number from the dice being
									// rolled arg0 times
		int totalValueRolled = 0;
		int numRolled = 0;
		for (int i = 0; i < rolls; i++) {
			Throw();
			totalValueRolled += Value();
			numRolled++;
		}
		return totalValueRolled / numRolled;
	}

	public int Value() {
		return value;
	}
}