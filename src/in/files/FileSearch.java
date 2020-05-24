package in.files;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Program to search for the given code in student.txt and display the details
 * 
 */
public class FileSearch {

	public static void main(String[] args) throws IOException {
		Scanner scInput = new Scanner(System.in);
		System.out.println("Enter the student code to search:");
		int search = scInput.nextInt();
		boolean found = false;
		Scanner sc = new Scanner(new File("C:\\temp\\student.txt"));
		while (sc.hasNext()) {
			String name = sc.next();
			int code = sc.nextInt();
			double average = sc.nextDouble();
			if (search == code) 
			{
				found = true;
				System.out.println("Name:" + name);
				System.out.println("code:" + code);
				System.out.println("average:" + average);
				break;
			}
		}
		
		if(!found)
		{
			System.out.println("Student with code "+search +" not found");
		}
		scInput.close();
		sc.close();
	}
}
