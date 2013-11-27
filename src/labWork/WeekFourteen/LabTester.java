/*
 * Sae Hun Kim
 * Week 14 lab tester for labs 1, 2, and 3
 */

package labWork.WeekFourteen;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LabTester {
	public static void main(String[] args) {
		System.out.println("Main thread started.");
		Dice d1 = new Dice("Dice 1", 25);
		Dice d2 = new Dice("Dice 2", 25);
		// Dice sharedDice = new Dice("Shared Dice", 3);

		ExecutorService tE = Executors.newCachedThreadPool();
		// lab1
		tE.execute(d1);
		tE.execute(d2);

		// tE.execute(sharedDice);
		// tE.execute(sharedDice);
		// tE.execute(sharedDice);
		// tE.shutdown();

		System.out.println("Main is done.");
	}
}
