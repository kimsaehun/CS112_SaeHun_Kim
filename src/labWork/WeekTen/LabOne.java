/*
 * Sae Hun Kim
 * SAC CS 112
 * Week ten lab 1
 */

package labWork.WeekTen;

public class LabOne {// dice class
	private int value;

	public int Throw() {
		return (value = (int) ((Math.random() * 6) + 1));
	}

	public int Value() {
		return value;
	}
}
