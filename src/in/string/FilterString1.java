package in.string;

import java.util.Scanner;

public class FilterString1 {

	public static void main(String[] args) {

		String cities[] = { "Delhi", "Mumbai", "Hyderabad", "kolkokata", "Bokaro", "Pune", "Reddy" };
		Scanner sc = new Scanner(System.in);
		// System.out.println("Enter 10 cities names");
		// for (int i = 0; i < 10; i++) {
		// String s = sc.next();
		// cities[i] = s;
		// }

		System.out.println("You entered ");
		for (int i = 0; i < cities.length; i++) {
			System.out.print(cities[i]+" ");
		}

		System.out.println("\n filtered ");
		for (int i = 0; i < cities.length; i++) {
			String s = cities[i];
			s = s.toLowerCase();
			char ch = s.charAt(0);
			if (ch != 'a' || ch != 'e' || ch != 'i' || ch != 'o' || ch != 'u') {
				char lc = s.charAt(s.length() - 1);
				if (lc == 'a' || lc == 'e' || lc == 'i' || lc == 'o' || lc == 'u') {
					System.out.print(cities[i]+" ");
				}
			}
		}

	}

} 
