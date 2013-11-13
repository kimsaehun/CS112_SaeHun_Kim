/*
 * Sae Hun Kim
 * CS 112
 * week 12
 */

package labWork.WeekTwelve;

public class DoubleDice extends LabOne {
	public int value;

	public DoubleDice() {
		value = 2;
	}

	@Override
	int Throw() {
		return 2;
	}

	@Override
	public String toString() {
		return "DoubleDice value: " + value;
	}
}
