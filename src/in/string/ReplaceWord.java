package in.string;

import java.util.Scanner;
import java.util.StringTokenizer;

public class ReplaceWord {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a sentence:");
		String str = sc.nextLine();
		StringTokenizer st = new StringTokenizer(str);
		while (st.hasMoreTokens()) {
			String w = st.nextToken();
			// if(startsWithVowel(w) && endsWithVowel(w))
			if (w.equals("Rakesh")) {
				str = str.replace(w, "Ram");
			} 
			if (w.equals("42")) {
				str = str.replace(w, "32");
			}
		}

		System.out.println(str);
	}

	private static boolean startsWithVowel(String name) {
		String lname = name.toLowerCase();
		char ch = lname.charAt(0);
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
			return true;
		}
		return false;
	}

	private static boolean endsWithVowel(String name) {
		String lname = name.toLowerCase();
		int len = name.length() - 1;
		char ch = lname.charAt(len);
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
			return true;
		}
		return false;
	}
}
