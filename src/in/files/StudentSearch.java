package in.files;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class StudentSearch {

	boolean found = false;

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the student to search:");
		String searchName = sc.next();
		StudentSearch ss = new StudentSearch();
		ss.printStudentDetails(searchName);
	}

	public void printStudentDetails(String searchName) throws IOException {
		Scanner scFile = new Scanner(new File("c:\\temp\\student.txt"));
		while (scFile.hasNext()) {
			String name = scFile.next();
			int m1 = scFile.nextInt();
			int m2 = scFile.nextInt();
			int m3 = scFile.nextInt();
			// if (startsWithVowel(name) && endsWithVowel(name)) {
			if (name.equals(searchName)) {
				System.out.println(name);
				System.out.println(m1 + "," + m2 + "," + m3);
				found = true;
				break;
			}
		}

		if (found == false) {
			System.out.println("No record found");
		}

		scFile.close();
	}

	private boolean startsWithVowel(String name) {
		String lname = name.toLowerCase();
		char ch = lname.charAt(0);
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
			return true;
		}
		return false;
	}

	private boolean endsWithVowel(String name) {
		String lname = name.toLowerCase();
		int len = name.length() - 1;
		char ch = lname.charAt(len);
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
			return true;
		}
		return false;
	}
}
