package in.other;

import java.util.Scanner;

public class PrintDigitsOfaNumber {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number ");
		int n = sc.nextInt();
		if(n<10)
		{
			System.out.println(n);
		}
		else if(n>9 && n<100){
			handleTwoDigits(n);
		}
		else if(n>99 && n<1000)
		{
			handleThreeDigits(n);
		}
		else if(n>999 && n<10000)
		{
			int d=n/1000;
			System.out.println(d);
			d = n%1000;
			handleThreeDigits(d);
		}
	}
	
	public static void handleThreeDigits(int n)
	{
		int d=n/100;
		System.out.println(d);
		d=n%100;
		handleTwoDigits(d);
	}
	public static void handleTwoDigits(int n)
	{
		int d = n/10;
		System.out.println(d);
		d=n%10;
		System.out.println(d);
	}

}
