package in.loop;

import java.util.*;

public class Loop1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		int n = sc.nextInt();
		System.out.println("Enter another number");
		int a = sc.nextInt();
		for (int i = 0; i <= a; i++) {
			System.out.println(n + "*" + i + "=" + n * i);
		}

	}
}