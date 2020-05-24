package in.arrays;

public class FeboArray {

	public static void main(String args[]) {
		int a[] = new int[20];
		fibonicSeries(a);
		printArray(a);
		int b[] = subtractConsecutiveNumbers(a);
		printArray(b);
	}

	private static int[] subtractConsecutiveNumbers(int[] a) {
		int b[] = new int[a.length - 1];
		for (int i = 0; i < b.length; i++) {
			b[i] = a[i + 1] - a[i];
		}
		return b;
	}

	private static void fibonicSeries(int a[]) {
		int sum = 0, x = 0, y = 1;
		int j = 0;
		a[j++] = y;
		for (int i = 1; i < 20; i++) {
			sum = x + y;
			x = y;
			y = sum;
			a[j++] = sum;
		}
	}

	private static void printArray(int[] c) {

		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i] + " ");
		}
		System.out.println("");
	}
}
