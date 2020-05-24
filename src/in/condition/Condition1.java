package in.condition;

import java.util.Scanner;

public class Condition1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		double total = 0.0;
		double dis = 0.0;
		double amt = 0.0;
		double bill = 0.0;

		System.out.println("Enter the amount");
		amt = sc.nextDouble();

		if (amt >= 10000)
			dis = amt * 10.0 / 100.0;
		else if (amt >= 20000)
			dis = amt * 20.0 / 100.0;
		else if (amt >= 30000)
			dis = amt * 30.0 / 100.0;
		bill = amt - dis;

		System.out.println("\t");
		System.out.println("Amount is" + amt);
		System.out.println("The Bill is" + bill);
		System.out.println("The Discount is" + dis);
	}
}
