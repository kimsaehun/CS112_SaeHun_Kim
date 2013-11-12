/*
 * Sae Hun Kim
 * CS 112
 * Lab tester
 */

package labWork.WeekEleven;

public class LabTester {
	public static void main(String[] args) {
		// Lab 1 test
		LabOne d1 = new LabOne();
		System.out.println(d1.Throw());

		System.out.println();
		// Lab 5 test
		LabFive d5 = new LabFive();
		System.out.println(d5.Throw());

		System.out.println();
		// lab 6 test
		LabSix d6 = new LabSix();
		System.out.println(d6.Value());

		System.out.println();
		// Lab 7 test
		LabSeven d7 = new LabSeven();
		System.out.println(d7);

		System.out.println();
		// Lab 8 test
		LabEight d8 = new LabEight();
		d8.Throw();
		d8.Throw();
		System.out.println(d8);

		System.out.println();
		// homework 11 test
		LabEight dH = new LabEight();
		dH.Throw();
		LabEight clone = dH.clone();
		System.out.println(clone.equal(dH));
		System.out.println(dH + "\n" + clone);
	}
}
