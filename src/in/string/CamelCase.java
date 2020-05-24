package in.string;

import java.util.Scanner;
import java.util.StringTokenizer;

import sun.util.locale.StringTokenIterator;

public class CamelCase {
	private String str;

	void readSent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a sentence");
		str = sc.nextLine();
		sc.close();
	}

	String convertToCamelCase(String word) {
		String cc = "" + Character.toUpperCase(word.charAt(0));
		cc = cc + word.substring(1, word.length());
		return cc;
	}

	void convertSent() {
		String newStr = "";
		StringTokenizer st = new StringTokenizer(str);
		while (st.hasMoreTokens()) {
			String word = st.nextToken();
			newStr = newStr + " " + convertToCamelCase(word);
		}
		str = newStr;
	}

	void display() {
		System.out.println(str);
	}

	public static void main(String[] args) {
		CamelCase cc = new CamelCase();
		cc.readSent();
		cc.display();
		cc.convertSent();
		cc.display();
	}
}
