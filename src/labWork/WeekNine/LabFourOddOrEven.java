/*
 * Sae Hun Kim
 * SAC CS 112
 * Week 9 Lab 4
 */
package labWork.WeekNine;

public class LabFourOddOrEven {
	private int m_val;

	public LabFourOddOrEven() {
		m_val = (int) (Math.random() * 2 + 1);
	}

	public LabFourOddOrEven(int arg0) {
		m_val = arg0;
	}

	public int getValue() {// added for use in Lab 5
		return m_val;
	}

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
