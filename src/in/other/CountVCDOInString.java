package in.other;

import java.util.Scanner;

/**
 * Count vowels, consonants, digits and others chars in string.
 * 
 * @author saryal
 *
 */
public class CountVCDOInString {

	public static void main(String[] args) {

		int v = 0, c = 0, d = 0, o = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a character");
		String s = sc.next();
		System.out.println("Entered: " + s);
		s = s.toUpperCase();
		System.out.println("to Upper: " + s);
		for (int i = 0; i < s.length(); i++) {
			// get each char in the string
			int a = s.charAt(i);
			// check if it is a char
			if ((a >= 65 && a <= 90)) {
				if (a == 65 || a == 69 || a == 73 || a == 79 || a == 85) {
					v++;
				} else {
					c++;
				}
			}
			// check of digits
			else if (a >= 48 && a <= 57) {
				d++;
			}
			// else others
			else {
				o++;
			}
		}

		System.out.println("Vowels " + v);
		System.out.println("Consonants " + c);
		System.out.println("digits " + d);
		System.out.println("Others :" + o);
	}
}
