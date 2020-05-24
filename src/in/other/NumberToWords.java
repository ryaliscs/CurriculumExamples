package in.other;

import java.util.Scanner;

public class NumberToWords {

	public static void main(String args[]) {
		String twoD[] = { "", "one", "two", "three", "four", "five", "six", "sven", "eight", "nine", //
				"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", //
				"eighteen", "nintenn", "twnety" };

		String unit1[] = { "", "", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninty" };

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Number ");
		int n = sc.nextInt();
		if (n < 9) {
			System.out.println(twoD[n]);
		} else if (n > 9 && n < 100) {
			int d = n / 10;
			String s = unit1[d];
			d = n % 10;
			s = s + " " + twoD[d];
			System.out.println(s);
		} else if (n > 99 && n < 1000) {
			int d = n / 100;
			String s = twoD[d] + " hundred ";
			n = n % 100;
			d = n / 10;
			s = s + unit1[d];
			d = n % 10;
			s = s + " " + twoD[d];
			System.out.println(s);
		} else if (n > 1000 && n < 10000) {
			int d = n / 1000;
			String s = twoD[d] + " thousand ";
			n = n % 1000;
			if (n != 0) {

				d = n / 100;
				s = s + twoD[d] + " hundred ";
				n = n % 100;
				d = n / 10;
				s = s + unit1[d];
				d = n % 10;
				s = s + " " + twoD[d];
			}
			System.out.println(s);
		}

	}
}
