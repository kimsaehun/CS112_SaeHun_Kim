/*
 * Sae Hun Kim
 * Week 14 lab 1 and lab 2 and lab 3
 * 22
 */

package labWork.WeekFourteen;

public class Dice implements Runnable {
	int value, numRolls;
	String name;

	public Dice(String arg0, int num) {
		name = arg0;
		numRolls = num;
	}

	public synchronized int roll() {
		value = (int) ((Math.random() * 6) + 1);
		return value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public void run() {
		System.out.println(name + " will roll " + numRolls + "times.");
		for (int i = 0; i < numRolls; i++) {
			System.out.println("Roll #" + (i + 1) + " for "
					+ Thread.currentThread().getName() + " " + name + " is "
					+ this.roll());
			this.roll();
		}
		System.out.println(Thread.currentThread().getName() + " " + name
				+ " finished rolling.");
	}

}
