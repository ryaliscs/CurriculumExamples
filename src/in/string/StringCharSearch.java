package in.string;

import java.util.Scanner;

public class StringCharSearch {

	public static void main(String args[]) {
		String n[] = { "Amit", "vishnu", "shiva", "siddu" };
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a character: ");
		String a = sc.next();

		for (int i = 0; i < n.length; i++) {
			String t = n[i];
			if (t.startsWith(a)) {
				System.out.println(t);
			}

		}
	}
}
