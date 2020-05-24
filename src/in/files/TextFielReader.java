package in.files;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TextFielReader {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("c:\\temp\\student.txt"));
		String name;
		int code;
		double average;
		
		while(sc.hasNext())
		{
			name = sc.next();
			code = sc.nextInt();
			average = sc.nextDouble();
			System.out.println("Name:"+name);
			System.out.println("Code:"+code);
			System.out.println("Average:"+average);
		}
		
		sc.close();
	}

}
