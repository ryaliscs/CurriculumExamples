package in.string;

import java.util.Scanner;

/**
 * Return if true if the entered word has two consecutive characters
 * 
 * eg: mystery : true since it has ST
 * 
 * @author saryal
 *
 */
public class Magic {

	String str;

	public Magic() {
		str = "";
	}

	void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a word:");
		str = sc.nextLine().toUpperCase();
	}

	boolean check() {
		int p = (int) str.charAt(0);
		for (int i = 1; i < str.length(); i++) {
			int c = (int) str.charAt(i);
			if (c == (p + 1)) {
				return true;
			}
			p = c;
		}
		return false;
	}

	void display() {
		if (check()) {
			System.out.println(str + " is a magic word");
		} else {
			System.out.println(str + " is not a magic word");
		}
	}

	public static void main(String[] args) {
		Magic m = new Magic();
		m.input();
		m.display();
	}
}
