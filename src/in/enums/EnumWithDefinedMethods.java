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
		aOption.action();
	}
}
