/*
 * Sae Hun Kim
 * CS 112
 * Week 13
 * lab tester
 */

package labWork.WeekThirteen;

public class LabTester {
	public static void main(String[] args) {
		// Lab 1 test
		Dice d1 = new Dice();
		Card c1 = new Card();
		try {// lab 2 test
			System.out.println("Dice numbers: " + d1.generateRandomNumber()
					+ " and " + d1.generateRandomNumber());
		} catch (Exception e) {
			System.out.println("Too many throws!");
		}
		System.out.println("Card numbers: " + c1.generateRandomNumber()
				+ " and " + c1.generateRandomNumber());
		System.out.println("Dice history: " + d1.printHistory());
		System.out.println("Card history: " + c1.printHistory());

		// lab 2 test
		int[] nums = new int[4];
		try {// lab 2 test
			for (int i : nums) {
				nums[i] = d1.generateRandomNumber();
			}
		} catch (Exception e) {
			System.out.println("Too many throws Exception! "
					+ d1.printHistory());
		}
	}
}
