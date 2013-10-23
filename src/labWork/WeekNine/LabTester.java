/*
 * Sae Hun Kim
 * Sac CS 112
 * Week 9 Lab Tester for labs 1-4
 */
package labWork.WeekNine;

public class LabTester {
	public static void main(String[] args) {
		LabOneOddOrEven o1 = new LabOneOddOrEven();
		LabTwoOddOrEven o2 = new LabTwoOddOrEven();
		LabFourOddOrEven o4 = new LabFourOddOrEven();

		// lab 1
		System.out.println("Lab One");
		o1.odd();
		o1.even();
		// lab 2
		System.out.println("\nLab Two");
		o2.setValue(9);
		System.out.println(o2.oddEven());
		o2.setValue(2);
		System.out.println(o2.oddEven());
		// lab 3
		System.out.println("\nLab Three");
		LabThreeOddOrEven o3 = new LabThreeOddOrEven(5);
		System.out.println(o3.oddEven());
	}
}
