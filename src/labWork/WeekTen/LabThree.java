/*
 * Sae Hun Kim
 * CS 112
 * Week ten lab 3
 */

package labWork.WeekTen;

public class LabThree {
	private int value, throwValue;

	public LabThree(int bounces) {// constructor. this would be the Dice(int
									// bounces)
		Throw(bounces);
	}

	public int getThrowValue() {
		return throwValue;
	}

	public int Throw() {
		return (value = (int) ((Math.random() * 6) + 1));
	}

	public int Throw(int bounces) {// get the average number from the dice being
		// rolled bounces times
		int totalValueRolled = 0;
		int numRolled = 0;
		for (int i = 0; i < bounces; i++) {
			Throw();
			totalValueRolled += Value();
			numRolled++;
		}
		return (throwValue = totalValueRolled / numRolled);
	}

	public int Value() {
		return value;
	}
}
