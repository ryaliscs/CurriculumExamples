package algorithm;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(fibonacciNumber(50));
	}

	/**
	 * Return the nth febonicc number
	 * 
	 * @param n
	 * @return the nth febonicc number
	 */
	public static int fibonacciNumber(int n) {
		if (n <= 2) {
			return 1;
		}
		return fibonacciNumber(n - 1) + fibonacciNumber(n - 2);
	}
}
