/*
 * Sae Hun Kim
 * SAC CS 112
 * Week Ten main program used to test the labs
 */

package labWork.WeekTen;

public class LabMainProgram {
	public static void main(String[] args) {
		LabOne dice = new LabOne();
		LabTwo dice2 = new LabTwo();

		// lab 1 test
		dice.Throw();
		System.out.println(dice.Value());

		// lab 2 test
		System.out.println(dice2.Throw(3));
	}
}
