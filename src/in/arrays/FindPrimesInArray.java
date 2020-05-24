package in.arrays;

import java.util.Scanner;

public class FindPrimesInArray {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n[] = new int[10];
		System.out.println("enter 10 numbers");
		for (int i = 0; i < 10; i++) {
			n[i] = sc.nextInt();
		} // end of for for accepting 10 numbers

		int a = 0;
		int count = 0;

		for (int i = 0; i < 10; i++) { // start looping throught the array 'n'
			a = n[i];

			int j;
			for (j = 2; j < a; j++) { // check if the number 'a' is prime
				if (a % j == 0) {
					//it is not a prime
					break;
				}
			} // end of prime check for loop
			if(j==a)
			{
				count++;
				System.out.println(a);
			}
		} //
		if (count == 0) {
			System.out.println("All are not prime numbers");
		} else {
			System.out.println("No of primes: " + count);
		}
	}
}
