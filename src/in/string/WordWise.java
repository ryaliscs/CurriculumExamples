package in.string;

import java.util.Scanner;
import java.util.StringTokenizer;

public class WordWise {
	private String str;

	public WordWise() {
	}

	void readSent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a sentence:");
		str = sc.nextLine();
		sc.close();
	}

	int freqVowel(String w) {
		int count = 0;
		String lw = w.toLowerCase();
		for (int i = 0; i < lw.length(); i++) {
			char ch = lw.charAt(i);
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				count++;
			}
		}
		return count;
	}

	void arrange() {
		StringTokenizer tokens = new StringTokenizer(str);
		while (tokens.hasMoreTokens()) {
			String token = tokens.nextToken();
			int freq = freqVowel(token);
			System.out.println(token + " - " + freq);
		}
		}
	
	
	public static void main(String[] args) {
		WordWise ww = new WordWise();
		ww.readSent();
		ww.arrange();
	}

}
