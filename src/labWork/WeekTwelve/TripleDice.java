/*
 * Sae Hun Kim
 * CS 112
 * week 12
 */

package labWork.WeekTwelve;

public class TripleDice extends Dice {
	private int value;

	public TripleDice() {
		value = 3;
	}

	@Override
	int Throw() {
		return 3;
	}

	@Override
	public String toString() {
		return "TripleDice value: " + value;
	}
}
