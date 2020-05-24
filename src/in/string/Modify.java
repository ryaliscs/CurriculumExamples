package in.string;

import java.util.Scanner;

/**
 * Modifications of the given sentence
 * 
 * @author saryal
 *
 */
public class Modify {
	
	String str;
	int len;
	
	public Modify()
	{
		str = "";
		len = 0;
	}

	public void read()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a sentence:");
		str = sc.nextLine();
		len = str.length();
	}
	
	void put(int pos, char ch)
	{
		String temp = str.substring(0, pos);
		str = temp + ch + str.substring(pos, str.length());
		System.out.println("Changed string:"+str);
	}
	
	void takeout(int pos)
	{
		String temp = str.substring(0,pos);
		str = temp+str.substring(pos+1, str.length());
		System.out.println("take out:"+str);
	}
	
	void change()
	{
		String change="";
		for(int i =0; i<str.length();i++)
		{
			int alpha = str.charAt(i)+2;
			if(alpha > 90)
			{
				alpha = alpha - 26;
			}
			char ch = (char)alpha;
			change = change+ch;
		}
		System.out.println("changed:"+change);
	}
	
	public static void main(String[] args) {
		Modify modify = new Modify();
		modify.read();
		modify.put(3, '#');
		modify.takeout(4);
		modify.change();
	}
}
