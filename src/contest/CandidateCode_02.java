package contest;

import java.util.Scanner;

/**
 * <pre>
	Prime Game (100 Marks)
Rax, a school student, was bored at home in the pandemic. He wanted to play but there was no one to play with. He was doing some mathematics questions including prime numbers and thought of creating a game using the same. After a few days of work, he was ready with his game. He wants to play the game with you.


GAME:

Rax will randomly provide you a range [ L , R ] (both inclusive) and you have to tell him the maximum difference between the prime numbers in the given range. There are three answers possible for the given range.

There are two distinct prime numbers in the given range so the maximum difference can be found.

There is only one distinct prime number in the given range. The maximum difference in this case would be 0.

There are no prime numbers in the given range. The output for this case would be -1.


To win the game, the participant should answer the prime difference correctly for the given range.


Example:

Range: [ 1, 10 ]

The maximum difference between the prime numbers in the given range is 5.

Difference = 7 - 2 = 5


Range: [ 5, 5 ]

There is only one distinct prime number so the maximum difference would be 0.


Range: [ 8 , 10 ]

There is no prime number in the given range so the output for the given range would be -1.


Can you win the game?



Input Format
The first line of input consists of the number of test cases, T

Next T lines each consists of two space-separated integers, L and R



Constraints
1<= T <=10

2<= L<= R<=10^6



Output Format
For each test case, print the maximum difference in the given range in a separate line. 

Sample TestCase 1
Input
5
5 5
2 7
8 10
10 20
4 5
Output
0
5
-1
8
0
Explanation

Test Case 1: [ 5 - 2 ] = 3

Test Case 2: [ 7 - 2 ] = 5

Test Case 3: No prime number in the given range. Output = -1

Test Case 4: [ 19 - 11 ] = 8

Test Case 5: The difference would be 0 since there is only one prime number in the given range.
 * </pre>
 *
 */
public class CandidateCode_02 {
	public static void main(String args[]) throws Exception {
		try (Scanner sc = new Scanner(System.in)) {
			int noOfTests = getNoOfTests(sc);
			String[] inputs = getRangesInput(sc, noOfTests);
			for (int i = 0; i < noOfTests; i++) {
				printDifferent(inputs[i]);
			}
		}
	}

	private static int getNoOfTests(Scanner sc) {
		int noOfTest = sc.nextInt();
		return noOfTest;
	}

	private static String[] getRangesInput(Scanner sc, int noOfTests) {
		String[] inputs = new String[noOfTests];
		sc.nextLine();
		for (int i = 0; i < noOfTests; i++) {
			inputs[i] = sc.nextLine();
		}
		return inputs;
	}

	private static void printDifferent(String input) {
		String[] ranges = input.split(" ");
		int start_range = Integer.valueOf(ranges[0]).intValue();
		int end_range = Integer.valueOf(ranges[1]).intValue();
		int maxPrime = 0;
		int minPrime = 1;
		boolean found = false;

		for (int i = start_range; i <= end_range; i++) {
			if (isPrime(i)) {
				if (!found) {
					maxPrime = minPrime = i;
					found = true;
				}
				if (i >= maxPrime) {
					maxPrime = i;
				}
				if (i <= minPrime) {
					minPrime = i;
				}
			}
		}

		System.out.println(maxPrime - minPrime);

	}

	private static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		if (n <= 3)
			return true;

		if (n % 2 == 0 || n % 3 == 0)
			return false;

		for (int i = 5; i * i <= n; i = i + 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;

		return true;
	}
}
