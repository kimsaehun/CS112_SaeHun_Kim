/*
 * Sae Hun Kim
 * Sac CS 112
 * Week 9 lab 3
 */

package labWork.WeekNine;

public class LabThreeOddOrEven {
	private int m_val;

	public LabThreeOddOrEven(int arg0) {
		m_val = arg0;
	}

	public void setValue(int arg0) {
		m_val = arg0;
	}

	public String oddEven() {
		return "Odd or Even";
	}

	public void odd() {
		System.out.println("Odd");
	}

	public void even() {
		System.out.println("Even");
	}
}
