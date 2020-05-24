package in.other;

import java.util.*;

public class AsciiValue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string");
		String s = sc.next();
		for (int i = 0; i < s.length(); i++) {
			int c = (int) s.charAt(i);
			System.out.println(c);
		}
	}
}
