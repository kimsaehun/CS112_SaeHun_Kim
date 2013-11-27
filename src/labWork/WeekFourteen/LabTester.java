/*
 * Sae Hun Kim
 * Week 14 lab tester
 * and lab 2
 */

package labWork.WeekFourteen;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LabTester {
	public static void main(String[] args) {
		System.out.println("Main thread started.");
		Dice d1 = new Dice("Dice 1", 25);
		Dice d2 = new Dice("Dice 2", 25);

		ExecutorService tE = Executors.newCachedThreadPool();
		tE.execute(d1);
		tE.execute(d2);
		tE.shutdown();
		System.out.println("Main is done.");
	}
}
