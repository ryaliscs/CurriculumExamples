package in.recursion;

/**
 * if reversing a number is equal to the original number then it is called
 * Palidrome Number
 * 
 * eg: 454 == 454 (reverse) (Palindrome) <br>
 * 145 != 541
 * 
 * @author saryal
 *
 */
public class PalindromeNumber {

	int num;
	int revnum;

	public PalindromeNumber(int n) {
		num = n;
	}

	int reverse(int y) {
		if (y <= 0)
			return revnum;

		else {
			int mod = y % 10;
			revnum = revnum * 10 + mod;
			return reverse(y / 10);
		}
	}

	void check() {
		revnum = reverse(num);
		if (num == revnum) {
			System.out.println("Palindrom number");
		} else {
			System.out.println("Not Palindrom number");
		}
	}

	public static void main(String[] args) {
		PalindromeNumber pn = new PalindromeNumber(545);
		pn.check();
	}

}
