package in.files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextFileWrite {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("c:\\temp\\student.txt", true/*to append*/);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		
		String name;
		int code;
		double average;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter No. of Students:");
		int noOfStudnets = sc.nextInt();
		for(int i=0; i< noOfStudnets; i++)
		{
			System.out.println("Enter Student Name:");
			name = sc.next();
			System.out.println("Enter code:");
			code = sc.nextInt();
			System.out.println("Average:");
			average = sc.nextDouble();
			
			pw.println(name);
			pw.println(code);
			pw.println(average);
		}
		
		pw.close();
		bw.close();
		fw.close();
		
		
	}
}
