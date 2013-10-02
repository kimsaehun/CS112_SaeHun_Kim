package labWork.weekSix;

import java.util.Scanner;

public class LabFifteen {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int ans;
		boolean correct = false, greater;
		RandomNumber ramNum = new RandomNumber();

		System.out.println("Enter a high number: ");
		int hi = scan.nextInt();
		System.out.println("Enter a lower number: ");
		int lo = scan.nextInt();
		int ran = ramNum.GetANumber(lo, hi);

		System.out.print("Guess a number between " + lo + " and " + hi
				+ " inclusive : ");
		ans = scan.nextInt();
		correct = (ans == ran);
		greater = (ans > ran);
		if (correct) {
			System.out.println("Congratulations. You Won!");
		} else if (greater) {
			System.out.println("Your number was too high!");
		} else {
			System.out.println("Your number was too low!");
		}
	}
}
