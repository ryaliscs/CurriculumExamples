package in.files;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileFindStudentWithHighestTotal {

	public static void main(String[] args) throws IOException {
		int code=0;
		String name="";
		int m1=0,m2=0,m3=0,total=0;
		int htotal=0;
		Scanner sc = new Scanner(new File("c:\\temp\\studentMarks.txt"));
		while(sc.hasNext())
		{
			int rcode = sc.nextInt();
			String rname = sc.next();
			int rm1 = sc.nextInt();
			int rm2 = sc.nextInt();
			int rm3 = sc.nextInt();
			int rtotal = rm1+rm2+rm3;
			if(rtotal > htotal)
			{
				code = rcode;
				name = rname;
				m1=rm1;
				m2=rm2;
				m3=rm3;
				total = rtotal;
				htotal = rtotal;
			}
		}

		sc.close();
		
		//print student with hight total
		System.out.println("code:"+code);
		System.out.println("name:"+name);
		System.out.println("total:"+total);
		
		
	}
}
