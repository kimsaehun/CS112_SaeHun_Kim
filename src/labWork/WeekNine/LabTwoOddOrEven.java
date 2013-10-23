/*
 * Sae Hun Kim
 * Sac CS 112
 * Week 9 lab 2
 */
package labWork.WeekNine;

public class LabTwoOddOrEven {
	private int m_val;

	public void setValue(int arg0) {
		m_val = arg0;
	}

	public String oddEven() {
		if (m_val % 2 == 0) {
			return "Even";
		} else {
			return "Odd";
		}
	}

	public void odd() {
		System.out.println("Odd");
	}

	public void even() {
		System.out.println("Even");
	}
}
