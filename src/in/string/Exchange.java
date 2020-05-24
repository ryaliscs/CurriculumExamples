package in.string;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Exchange the first and last char of each work in a given sentence:
 * 
 * <pre>
 *  eg: It is a warm day 
 * result: ti si a marw yad
 * </pre>
 * 
 * @author saryal
 *
 */
public class Exchange {

	private String sent;
	private String rev;
	int size;;

	public Exchange() {
		sent = "";
		rev = "";
		size = 0;
	}

	public void readsentence() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a sentence:");
		sent = sc.nextLine();
		size = sent.length();
	}

	public void exfirstlast() {
		StringTokenizer tokens = new StringTokenizer(sent, " ");
		while (tokens.hasMoreTokens()) {
			String word = tokens.nextToken();
			int wordlen = word.length();

			int check = word.length() - 2;
			if (wordlen == 1) { // only one character word
				rev = rev + " " + word;
			} else if (wordlen == 2) { // only two character word
				String revword = "" + word.charAt(wordlen - 1);
				revword = revword + word.charAt(0);
				rev = rev + " " + revword;
			} else {
				String revword = ""+ word.charAt(wordlen - 1);
				revword = revword + word.substring(1, wordlen - 1);
				revword = revword + word.charAt(0);
				rev = rev + " " + revword;
			}
		}
	}

	public void display() {
		System.out.println("Original: " + sent);
		System.out.println("Exchanged: " + rev);
	}

	public static void main(String[] args) {
		Exchange ex = new Exchange();
		ex.readsentence();
		ex.exfirstlast();
		ex.display();
	}

}
