package in.condition;

import java.util.Scanner;

public class Condition2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Syllabus (I) - ICSE, (C) - CBSE");
		String s = sc.next();
		System.out.println("Enter your Total marks");
		double tot = sc.nextDouble();
		double avg = tot / 6;

		switch (s) {
		case "I":
			if (avg >= 80) {
				System.out.println("Your grade is A");
			} else if (avg >= 60 && avg < 80) {
				System.out.println("Your grade is B");
			} else if (avg >= 50 && avg < 60) {
				System.out.println("Your grade is C");
			} else {
				System.out.println("Your Fail");
			}
			break;
		case "C":
			if (avg >= 90) {
				System.out.println("Your grade is A");
			} else if (avg >= 75 && avg < 90) {
				System.out.println("Your grade is B");
			} else if (avg >= 60 && avg < 75) {
				System.out.println("Your grade is C");
			} else {
				System.out.println("Your Fail");
			}
			break;
		default:
			System.out.println("Invalid");

		}
//		if (s.equals("C")) {
//			if (avg >= 80) {
//				System.out.println("Your grade is A");
//			} else if (avg >= 60 && avg < 80) {
//				System.out.println("Your grade is B");
//			} else if (avg >= 50 && avg < 60) {
//				System.out.println("Your grade is C");
//			} else {
//				System.out.println("Your Fail");
//			}
//		} else if (s.equals("I")) {
//			if (avg >= 90) {
//				System.out.println("Your grade is A");
//			} else if (avg >= 75 && avg < 90) {
//				System.out.println("Your grade is B");
//			} else if (avg >= 60 && avg < 75) {
//				System.out.println("Your grade is C");
//			} else {
//				System.out.println("Your Fail");
//			}
//		} else {
//			System.out.println("Invalid Choice");
//		}
		System.out.println("Your Total is" + tot);
		System.out.println("Your Average is" + avg);
	}
}
