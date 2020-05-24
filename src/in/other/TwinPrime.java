package in.other;

public class TwinPrime {

	public static void main(String[] args) {

		int m = 1;
		int n = 100;
		int prime = 0;
		int prevPrime = 1;

		for (; m <= n; m++) {
			if (isPrimeNumber(m)) {
				prime = m;
				int diff = prime - prevPrime;
				if (diff == 2) {
					System.out.print("(" + prevPrime + ", " + prime + ") ");
				}
				prevPrime = prime;
			}
		}
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
