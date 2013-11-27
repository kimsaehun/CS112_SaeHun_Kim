/*
 * Sae Hun Kim
 * Week 14 lab 1
 * 22
 */

package labWork.WeekFourteen;

public class Dice implements Runnable {
	int value;
	String name;

	public Dice(String arg0) {
		name = arg0;
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
		System.out.println(name + " rolled a " + this.roll());
	}

}
