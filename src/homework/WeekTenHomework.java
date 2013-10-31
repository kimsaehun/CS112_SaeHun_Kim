/*
 * Sae Hun Kim
 * Cs 112
 * Week ten homework
 */

package homework;

import java.util.ArrayList;

public class WeekTenHomework {
	private int value, throwValue, numOfThrows = 0, returnValue;
	private static int oneValue;
	private ArrayList<Integer> history = new ArrayList<Integer>();

	public WeekTenHomework() {// bounces should = 1 for a default constructor
		Throw(1);
	}

	public WeekTenHomework(int bounces) {// constructor. this would be the
											// Dice(int
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
		value = (int) ((Math.random() * 6) + 1);
		return value;
	}

	public int Throw(int bounces) {// get the average number from the dice being
		// rolled bounces times
		int totalValueRolled = 0;
		int numRolled = 0;
		for (int i = 0; i < bounces; i++) {
			totalValueRolled += Throw();
			numRolled++;
		}
		throwValue = totalValueRolled / numRolled;
		return throwValue;
	}

	public int Throw(int dices, int bounces) {
		numOfThrows++;
		returnValue = 0;
		for (int i = 0; i < dices; i++) {
			returnValue += Throw(bounces);
		}
		returnValue /= dices;
		history.add(returnValue);
		return returnValue;
	}

	public int Value() {
		return value;
	}

	// methods added for the homework
	public int getNumOfThrows() {// returns the number of throws done
		return numOfThrows;
	}

	public void getHistory() {// prints out all the values from throwing the
								// dice in a single line
		for (int i = 0; i < history.size(); i++) {
			System.out.print(history.get(i) + " ");
		}
	}

	public int getReturnValue() {
		return returnValue;
	}
}
