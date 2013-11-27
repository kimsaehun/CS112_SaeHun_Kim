/*
 * Sae Hun Kim
 * Week 14 lab 1 and lab 2
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

	public int roll() {
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
			System.out.println("Roll #" + (i + 1) + " for " + name + " is "
					+ this.roll());
		}
		System.out.println(name + " finished rolling.");
	}

}
