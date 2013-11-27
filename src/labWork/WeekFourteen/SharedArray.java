/*
 * Sae Hun Kim
 * CS 112
 * week 14 lab 3
 */

package labWork.WeekFourteen;

import java.util.Arrays;

public class SharedArray {
	private final int[] history;
	private int writeIndex = 0;

	public SharedArray(int num) {
		history = new int[num];
	}

	public synchronized void add(int val) {
		System.out.println(Thread.currentThread().getName() + " wrote " + val
				+ " unto position " + writeIndex);
		history[writeIndex] = val;
		writeIndex++;
	}

	public String toString() {
		return "The values were: " + Arrays.toString(history);
	}
}
