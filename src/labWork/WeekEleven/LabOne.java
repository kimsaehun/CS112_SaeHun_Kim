/*
 * Sae Hun Kim
 * CS 112
 * Lab 1 Three Dice class
 */

package labWork.WeekEleven;

import labWork.WeekTen.LabFive;

public class LabOne {// Three Dice class
	LabFive d1 = new LabFive();// Dice class from last week
	LabFive d2 = new LabFive();
	LabFive d3 = new LabFive();

	public int Throw() {
		return (d1.Throw() + d2.Throw() + d3.Throw()) / 3;
	}
}
