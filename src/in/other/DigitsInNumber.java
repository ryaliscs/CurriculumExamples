package in.other;

import java.util.Scanner;

public class DigitsInNumber {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n[] = new int[10];
		System.out.println("Enter 10 numbers");
		for (int i = 0; i < 10; i++) {
			n[i] = sc.nextInt();

		}
		int a = 0, count = 0, tcount = 0;
		for (int i = 0; i < n.length; i++) {
			a = n[i];

			if (a > 9 && a < 100) {
				tcount++;
				System.out.println(a);
			} else if (a >= 100 && a < 1000) {
				count++;
				System.out.println(a);
			}
		}
		System.out.println("Two Digit numbers:" + tcount);
		System.out.println("Three Digit numbers:" + count);
	}
}
