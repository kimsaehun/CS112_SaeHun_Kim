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
		LabThreeOddOrEven o3 = new LabThreeOddOrEven(5);
		LabFourOddOrEven o4 = new LabFourOddOrEven();

		// lab 1
		System.out.println("Lab One");
		o1.odd();
		o1.even();
	}
}
