package in.enums;

/**
 * This example shows java enum with defined methods
 * @author saryal
 *
 */
public class EnumWithConstants {
	
	public static void main(String[] args) {
		EnumWithConstants ee = new EnumWithConstants();
		ee.printOption(Options.THREE);
	}
	
	public void printOption(Options aOption) {
		switch (aOption) {
		case ONE :
			one();
			break;
		case TWO:
			two();
			break;
		case THREE:
			three();
			break;
		}
	}
	
	public void one() {
		System.out.println("one");
	}
	
	public void two() {
		System.out.println("two");
	}
	
	public void three() {
		System.out.println("three");
	}

}
