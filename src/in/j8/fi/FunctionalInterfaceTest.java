package in.j8.fi;

public class FunctionalInterfaceTest {

	public static void main(String[] args) {

		// normal style
		System.out.println(getCalculations().calculate(20, 30));
		System.out.println(getCalculations().subtract(20, 30));

		// in line implementation of functional interface
		ICalculator c1 = (x, y) -> x + y;
		ICalculator c2 = (x, y) -> {
			System.out.println("addition of " + x + " + " + y + " = " + (x + y));
			return (x + y);
		};

		System.out.println(c1.calculate(10, 20));
		c2.calculate(100, 200);		

		math((p, q) -> p + q, 20, 20); // addition
		math((p, q) -> p - q, 20, 20); // subtraction
		math((p, q) -> p * q, 20, 20); // multiplication
		math((p, q) -> p / q, 20, 20); // division
		math((p, q) -> p % q, 20, 20); // modulus

		// passing normal object
		math(getCalculations(), 200, 400);

	}

	public static ICalculations getCalculations() {
		ICalculations c = new ICalculations() {

			@Override
			public int calculate(int a, int b) {
				return a + b;
			}

			@Override
			public int subtract(int a, int b) {
				return a - b;
			}
		};

		return c;
	}


	public static void math(ICalculator aFI, int a, int b) {
		System.out.println(aFI.calculate(a, b));
	}

}
