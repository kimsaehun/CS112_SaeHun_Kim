/*
 * Sae Hun Kim
 * CS 112
 * Midterm Bonus
 * 
 * The problem with this is that the first iteration of the for loop
 * does is not multiply,check,add but its multiply, add, multiply, then check.
 * afterwards, it goes add, multiply, check.
 */
package labWork.WeekEight;

import java.util.Scanner;

public class MidtermBonus {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = 1;
		int F = 1;
		for (F = F * M; M != N; F = F * M) {
			M = M + 1;
		}
		System.out.print(F);
	}
}