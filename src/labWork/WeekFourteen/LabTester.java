/*
 * Sae Hun Kim
 * Week 14 lab tester
 */

package labWork.WeekFourteen;

public class LabTester {
	public static void main(String[] args) {
		Dice d1 = new Dice("Dice 1");
		Dice d2 = new Dice("Dice 2");
		for (int i = 0; i < 25; i++) {
			Thread t1 = new Thread(d1);
			Thread t2 = new Thread(d2);
			t1.start();
			t2.start();
		}
	}
}
