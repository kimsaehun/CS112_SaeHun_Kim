/*
 * Sae Hun Kim
 * CS 112
 * Week 11 lab 5
 */

package labWork.WeekEleven;

public class LabFive extends labWork.WeekTen.LabFive {// extends the dice class
	@Override
	public int Throw() {
		return (super.Throw() + super.Throw() + super.Throw()) / 3;
	}
}
