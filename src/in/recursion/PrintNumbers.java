package in.recursion;

public class PrintNumbers {

	public static void main(String args[]) {

		PrintNumbers pt = new PrintNumbers();
//		pt.printNumbers(1, 10);
		pt.printNumbersRec(1, 10);
//		System.out.println(pt.sumOfDigits(123));
		System.out.println(pt.sumOfDigitsRec(123));
//		System.out.println(pt.sumOf(1, 10));
		System.out.println(pt.sumOfRec(1, 10));
		System.out.println(pt.factorialRec(3));

	} // end main

	public void printNumbers(int start, int end) {
		for (int i = start; i <= end; i++) {

			System.out.println(i);
		}
	}

	public int sumOfDigits(int num) {
		int result = 0;
		int rem = 0;
		while (num > 0) {
			rem = num % 10;
			result = result + rem;
			num = num / 10;
		}

		return result;
	}

	public int sumOfDigitsRec(int num) {
		if (num <= 0) {
			return 0;
		}
		int rem = num % 10;
		num = num / 10;
		return rem + sumOfDigitsRec(num);
	}

	public int factorialRec(int num) {
		if (num == 1) {
			return 1;
		}

		return num * factorialRec(--num);
	}

	public void printNumbersRec(int start, int end) {
		if (start > end) {
			return;
		}
		System.out.println(start);
		printNumbersRec(++start, end);
	}

	public int sumOf(int start, int end) {
		int result = 0;
		for (; start <= end; start++) {
			result = result + start;
		}
		return result;
	}

	public int sumOfRec(int start, int end) {

		if (start > end) {
			return 0;
		}

		return start + sumOfRec(++start, end);
	}

}// end class
