/*
 * Sae Hun Kim
 * Cs 112
 * Week ten lab 5
 */

package labWork.WeekTen;

public class LabFive {
	private int value, throwValue;
	private static int oneValue;

	public LabFive(int bounces) {// constructor. this would be the Dice(int
									// bounces)
		Throw(bounces);
	}

	public int getThrowValue() {
		return throwValue;
	}

	public static void OneThrow() {
		oneValue = (int) ((Math.random() * 6) + 1);
	}

	public int getOneValue() {
		return oneValue;
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

	public int Throw(int dices, int bounces) {
		int returnValue = 0;
		for (int i = 0; i < dices; i++) {
			returnValue += Throw(bounces);
		}
		returnValue /= dices;
		return returnValue;
	}

	public int Value() {
		return value;
	}
}
