/*
 * Sae Hun Kim
 * CS 112
 * Week 8 Lab 2
 * RandomNumber Class
 */

package labWork.WeekEight;

public class LabTwoRandomNumber {
	public int GetANumber_Between_1_and_10() {
		int i = (int) ((Math.random() * 10) + 1);
		return i;
	}
}
