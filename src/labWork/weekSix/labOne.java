/*
 * SAC CS 112 JAVA PROGRAMMING
 * Sae Hun Kim
 * Week 6
 * lab 1
 */
package labWork.weekSix;

import java.util.Scanner;

public class labOne {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int ran = (int) (Math.random() * 10);
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
