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
		LabFour dice4 = new LabFour(1);
		LabFive dice5 = new LabFive(1);

		// lab 1 test
		dice.Throw();
		System.out.println(dice.Value());
		System.out.println();

		// lab 2 test
		System.out.println(dice2.Throw(3));
		System.out.println();

		// lab 3 Test
		LabThree dice3 = new LabThree(3);
		System.out.println(dice3.getThrowValue());
		System.out.println();

		// lab 4 test
		LabFour.OneThrow();
		System.out.println(dice4.getOneValue());
		System.out.println();

		// Lab 5 test
		System.out.println(dice5.Throw(2, 4));
	}
}
