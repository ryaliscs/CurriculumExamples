package in.enums;

/**
 * This example shows java enum with defined methods
 * @author saryal
 *
 */
public class EnumWithDefinedMethods {
	
	public static void main(String[] args) {
		EnumWithDefinedMethods ee = new EnumWithDefinedMethods();
		ee.printOption(Options.ONE);
	}
	
	public void printOption(Options aOption) {
		switch (aOption) {
		case ONE :
			aOption.action();
			break;
		case TWO:
			aOption.action();
			break;
		case THREE:
			aOption.action();
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
