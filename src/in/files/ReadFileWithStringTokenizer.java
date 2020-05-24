package in.files;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReadFileWithStringTokenizer {
	private int wordCount = 0;
	private int vowelCount = 0;

	public static void main(String[] args) throws IOException {
		ReadFileWithStringTokenizer obj = new ReadFileWithStringTokenizer();
		obj.calculateWordAndVowelCount();
		System.out.println("Word Count:" + obj.getWordCount());
		System.out.println("Vowel Count:" + obj.getVowelCount());
	}

	public int getWordCount() {
		return wordCount;
	}

	public int getVowelCount() {
		return vowelCount;
	}

	public void calculateWordAndVowelCount() throws IOException {
		Scanner file = new Scanner(new File("c:\\temp\\story.txt"));
		while (file.hasNext()) {
			String line = file.nextLine();
			updateWordCount(line);
			updateVowelCount(line);
		}
		file.close();
	}

	private void updateWordCount(String str) {
		StringTokenizer token = new StringTokenizer(str);
		while (token.hasMoreTokens()) {
			token.nextToken();
			wordCount++;
		}
	}

	private void updateVowelCount(String word) {
		String lword = word.toLowerCase();
		for (int i = 0; i < lword.length(); i++) {
			char ch = lword.charAt(i);
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				vowelCount++;
			}
		}
	}
}
