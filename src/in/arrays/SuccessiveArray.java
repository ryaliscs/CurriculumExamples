package in.arrays;

public class SuccessiveArray {

	public static void main(String args[]) {
		int a[] = { 2, 6, 12, 20, 30, 42 };
		printArray(a);
		int b[] = a;
		while (b.length > 0) {
			b = subtractConsecutiveNumbers(b);
			printArray(b);
		}

	}

	private static int[] subtractConsecutiveNumbers(int[] a) {
		int b[] = new int[a.length - 1];
		for (int i = 0; i < b.length; i++) {
			b[i] = a[i + 1] - a[i];
		}
		return b;
	}

	private static void printArray(int[] c) {

		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i] + " ");
		}
		System.out.println("");
	}
}
