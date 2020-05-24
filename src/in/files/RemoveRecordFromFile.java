package in.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RemoveRecordFromFile {
	
	public static void main(String[] args) throws IOException {
		Scanner scInput = new Scanner(System.in);
		System.out.println("Enter student code to remove:");
		int searchCode = scInput.nextInt();
		
		int code=0;
		String name="";
		int m1=0,m2=0,m3=0;
		
		File f1 = new File("c:\\temp\\studentMarks.txt");
		Scanner scFile = new Scanner(f1);
		
		File f2 = new File("c:\\temp\\temp.txt");
		FileWriter fw = new FileWriter(f2);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		
		while(scFile.hasNext())
		{
			code = scFile.nextInt();
			name = scFile.next();
			m1 = scFile.nextInt();
			m2 = scFile.nextInt();
			m3 = scFile.nextInt();
			if(code != searchCode)
			{
				pw.println(code);
				pw.println(name);
				pw.println(m1);
				pw.println(m2);
				pw.println(m3);
			}
		}
		
		pw.close();
		bw.close();
		fw.close();
		scFile.close();
		scInput.close();
		
		f1.delete();
		f2.renameTo(f1);
		
	}

}
