/*
 * SAC CS 112 JAVA PROGRAMMING
 * Sae Hun Kim
 * Week 6
 * lab 4
 */
package labWork.weekSix;

import java.util.Scanner;

public class labFour {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int ran = (int) (Math.random() * 10);
		int ans;
		boolean correct = false, greater, wantToPlay = true;

		while (wantToPlay) {
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
			System.out.print("Play Again: y/n? ");
			if (scan.next().charAt(0) == 'n') {
				wantToPlay = false;
			}
		}

		System.out.println("Bye Bye!");
	}
}
