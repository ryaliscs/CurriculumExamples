package in.other;

public class KarprekarNumber {

	public static void main(String[] args) {

		int n = 1;
		int nk = 0;

//		// for karprekar numbers for the given range
//		for (n = 2; n <= 10000; n++) {
//			if (isKarprekarNumber(n)) {
//				System.out.println(n + " is Karparekar Number");
//				nk++;
//			}
//		}
		// first n karprekar number
		for (n = 2, nk = 0; nk <= 10; n++) {
			if (isKarprekarNumber(n)) {
				System.out.println(n + " is Karparekar Number");
				nk++;
			}

		}
	}

	private static boolean isKarprekarNumber(int n) {
		int sn = (int) Math.pow(n, 2);
		// System.out.println("n :" + n);
		// System.out.println("sn :" + sn);
		int nd = numberOfDigits(sn);
		int ld = nd / 2;// rounded to floor
		// System.out.println("ld :" + ld);
		int rd = nd - ld;
		// System.out.println("rd :" + rd);
		int div = getDivisor(rd);
		int ln = sn / div;
		int rn = sn % div;
		// System.out.println("ln :" + ln);
		// System.out.println("rn :" + rn);
		int total = ln + rn;
		// System.out.println("Result :" + total);
		if (total == n) {
			return true;
		}

		return false;

		// return total==n;
	}

	private static int getDivisor(int rd) {
		int n = 1;
		for (int i = 0; i < rd; i++) {
			n = n * 10;
		}
		return n;
	}

	/**
	 * Returns the number of digits in a given number
	 * 
	 * @param sn
	 */
	private static int numberOfDigits(int sn) {
		int n = sn;
		int nd = 0;
		while (n != 0) {
			n = n / 10;
			nd++;
		}
		// System.out.println("No of digits:" + nd);
		return nd;
	}
}