package in.recursion;

/**
 * Special Number == if the sum of factorial of the given digits of a number is
 * equal to the sumber
 * 
 * eg: 145 = 1! +4! + 5!
 * 
 * @author saryal
 *
 */
public class SpecialNumber {

	int num;

	public SpecialNumber(int n) {
		this.num = n;
	}

	int fact(int i) {
		if (i == 1) {
			return 1;
		}
		return i * fact(i - 1);
	}

	boolean isSpecial() {
		int sum = 0;
		int n = num;
		while (n > 0) {
			int res = n % 10;
			sum = sum + fact(res);
			n = n / 10;
		}

		if (sum == num) {
			return true;
		}
		return false;
	}

	void display() {
		if (isSpecial()) {
			System.out.println("Spacial Number");
		} else {
			System.out.println("Not a special number");
		}
	}

	public static void main(String[] args) {
		SpecialNumber sn = new SpecialNumber(145);
		sn.display();
	}
}
