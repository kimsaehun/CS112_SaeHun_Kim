/*
 * Sae Hun Kim
 * CS 112
 * Week 12 lab tester
 */

package labWork.WeekTwelve;

public class LabTester {
	public static void main(String[] args) {
		DoubleDice d2 = new DoubleDice();
		TripleDice d3 = new TripleDice();
		System.out.println(d2 + ": " + d2.Throw() + "\n" + d3 + ": "
				+ d3.Throw());
		
		// lab 2
		LabOne d1 = d2;
		System.out.println(d1.Throw());
	}
}
