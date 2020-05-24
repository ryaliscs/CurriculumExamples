package in.string;

import java.util.Scanner;

/**
 * Accept an word and: Shift all the consonants of the word at the beaning and
 * vowels at the end. convert all cosonants to upper case eg: spoon : SPNoo
 * 
 * @author saryal
 *
 */
public class ConsChange {

	String word;
	String shiftword;
	String changeword;

	int len;

	public ConsChange() {
		word = "";
		len = 0;
	}

	public void readWord() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a word in lower case:");
		word = sc.nextLine();
		len = word.length();
	}

	public void shiftcons() {
		String consonants = "";
		String vowels = "";

		for (int i = 0; i < word.length(); i++) {
			if (isVowel(word.charAt(i))) {
				vowels = vowels + word.charAt(i);
			} else {
				consonants = consonants + word.charAt(i);
			}
		}
		shiftword = consonants + vowels;
	}

	public void changeword() {
		String consonants = "";
		String vowels = "";

		for (int i = 0; i < word.length(); i++) {
			if (isVowel(word.charAt(i))) {
				vowels = vowels + word.charAt(i);
			} else {
				consonants = consonants + word.charAt(i);
			}
		}
		changeword = consonants.toUpperCase()+vowels;
	}
	

	public boolean isVowel(char ch) {
		return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
	}
	
	public void show()
	{
		System.out.println("original:"+ word);
		System.out.println("shifted:"+shiftword);
		System.out.println("changed:"+changeword);
	}
	
	public static void main(String[] args) {
		ConsChange cc = new ConsChange();
		cc.readWord();
		cc.shiftcons();
		cc.changeword();
		cc.show();
	} 
}
