package labWork.weekSix;

public class RandomNumber {
	public int GetANumber_Between_1_and_10() {
		int i = (int) ((Math.random() * 10) + 1);
		return i;
	}

	// gets a number from int lo to int hi inclusive
	public int GetANumber(int lo, int hi) {
		int i = (int) (((Math.random() * ((hi - lo) + 1)) + lo));
		return i;
	}
}
