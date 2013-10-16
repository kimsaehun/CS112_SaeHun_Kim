/*
 * Sae Hun Kim
 * CS 112
 * Midterm Bonus
 */
package labWork.WeekEight;

import java.util.Scanner;

public class MidtermBonus {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = 1;
		int F = 1;
		for (; M != N; M = M + 1) {
			F = F * M;
		}
		System.out.print(F);
	}
}