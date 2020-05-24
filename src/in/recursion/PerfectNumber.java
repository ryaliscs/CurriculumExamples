package in.recursion;

public class PerfectNumber {

	int num;

	public PerfectNumber(int n) {
		num = n;
	}

	int sum_of_factors() {
		int sum = 0;
		for (int i = 1; i < num; i++) {
			if (num % i == 0) {
				sum = sum + i;
			}
		}

		return sum;
	}

	int rec_sum_of_factors(int i) {
		if (i >= num) {
			return 0;
		}
		if (num % i == 0) {
			return i + rec_sum_of_factors(i + 1);
		}
		return rec_sum_of_factors(i + 1);

	}

	void check() {
		int sum = rec_sum_of_factors(1);
		System.out.println(sum);
		if (sum == num) {
			System.out.println("perfect number");
		} else {
			System.out.println("not a perfect number");
		}
	}

	public static void main(String[] args) {
		PerfectNumber pn = new PerfectNumber(496);
		pn.check();
	}
}
