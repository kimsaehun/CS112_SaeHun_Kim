/*
 * Sae Hun Kim
 * CS 112 week 13
 * Lab 1
 */

package labWork.WeekThirteen;

import java.util.ArrayList;

public class Card implements RanNumGen {
	private int num;
	private ArrayList<Integer> history = new ArrayList<Integer>();

	@Override
	public int generateRandomNumber() {
		num = (int) (Math.random() * 10 + 1);
		history.add(num);
		return num;
	}

	@Override
	public ArrayList printHistory() {
		return history;
	}

}
