/*
 * Sae Hun Kim
 * CS 112 week 13
 * Lab 1 and lab 2
 * 119
 */

package labWork.WeekThirteen;

import java.util.ArrayList;

public class Dice implements RanNumGen {
	private int num;
	private ArrayList<Integer> history = new ArrayList<Integer>();

	@Override
	public int generateRandomNumber() throws Exception {
		if (history.size() == 3) {
			throw new Exception();
		}
		num = (int) (Math.random() * 6 + 1);
		history.add(num);
		return num;
	}

	@Override
	public ArrayList printHistory() {
		return history;
	}

}
