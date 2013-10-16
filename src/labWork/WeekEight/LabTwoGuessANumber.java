/*
 * Sae Hun Kim
 * CS 112
 * Week 8 lab 2
 * GuessANumber Class
 */

package labWork.WeekEight;

import java.util.Scanner;

public class LabTwoGuessANumber {
	public static void main(String[] args) {
		LabTwoRandomNumber ramNum = new LabTwoRandomNumber();
		int ran = ramNum.GetANumber_Between_1_and_10();
		Scanner scan = new Scanner(System.in);
		int ans;
		boolean correct = false, greater;

		System.out.print("Guess a number: ");
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