/*
 * Sae Hun Kim
 * Week 14 lab tester for labs 1, 2, and 3
 */

package labWork.WeekFourteen;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LabTester {
	public static void main(String[] args) {
		System.out.println("Main thread started.");
		Dice d1 = new Dice("Dice 1", 25);
		Dice d2 = new Dice("Dice 2", 25);

		SharedArray arg = new SharedArray(9);
		Dice sharedDice1 = new Dice("Shared Dice1", 3, arg);
		Dice sharedDice2 = new Dice("Shared Dice2", 3, arg);
		Dice sharedDice3 = new Dice("Shared Dice3", 3, arg);

		ExecutorService tE = Executors.newCachedThreadPool();
		// lab1
		// tE.execute(d1);
		// tE.execute(d2);

		// lab 2
		tE.execute(sharedDice1);
		tE.execute(sharedDice2);
		tE.execute(sharedDice3);
		tE.shutdown();

		System.out.println("Main is done.");

		try {
			boolean isFinished = tE.awaitTermination(30, TimeUnit.SECONDS);
			if (isFinished) {
				System.out.println(arg);
			} else {
				System.out.println("Could not finish in time.");
			}
		} catch (InterruptedException e) {
			System.out.println("SOMEONE INTERRUPTED THE TASKS!");
		}
	}
}
