package in.other;

public class PrimePalindrome {

	public static void main(String[] args) {

		int m = 100;
		int n = 3000;
		int freq = 0;

		// check the range of m and n should be less then 3000

		System.out.println(" Prime Palindromes are: ");
		for (; m <= n; m++) {
			if (isPrimePalindrome(m)) {
				freq++;
				System.out.print(m + " ");
			}
		}
		System.out.println("\nFrequency of Prime Palindromes is:" + freq);

	}

	private static boolean isPrimePalindrome(int m) {
		if (isPrimeNumber(m) && isPalindrome(m)) {
			return true;
		}
		return false;

	}

	private static boolean isPalindrome(int m) {
		int rev = reverse(m);
		return (m == rev);
	}

	private static int reverse(int m) {
		int rev = 0;
		while (m != 0) {
			rev = rev * 10;
			rev = rev + (m % 10);
			m = m / 10;
		}
		return rev;
	}

	private static boolean isPrimeNumber(int m) {
		for (int n = 2; n < m; n++) {
			if (m % n == 0) {
				return false;
			}
		}
		return true;
	}

}
