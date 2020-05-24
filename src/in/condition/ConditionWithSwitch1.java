package in.condition;

import java.util.Scanner;

public class ConditionWithSwitch1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		int n = sc.nextInt();
		int res = n%2;
		
		switch (res)
		{
		case 0:
			System.out.println("Even");
			break;
		default:
			System.out.println("Odd");
		}

	}
}
