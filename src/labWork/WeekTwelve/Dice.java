/*Sae Hun Kim
 * cs 112
 * week 12
 */
package labWork.WeekTwelve;

public class Dice extends LabOne {// base class for lab 2
	private int value;

	public Dice() {
		value = 1;
	}

	@Override
	int Throw() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String toString() {
		return "Dice valueL " + value;
	}
}
