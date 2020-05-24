package in.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextfileReaderWithBR {
	
	public static void main(String[] args) throws IOException {

		String name;
		int code;
		double average;
		
		FileReader fr = new FileReader("c:\\temp\\student.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while(line!=null)
		{
			System.out.println(line);
			line = br.readLine();
		}
		
		br.close();
		fr.close();
		
		
	}

}
