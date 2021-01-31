package in.enums;

/**
 * Enum with defined methods.  
 * <pre> A abstract method action is defined for Enum Options and that is overridden for each of the enum constant we define 
 * @author saryal
 *
 */
public enum Options {

	ONE {
		@Override
		void action() {
			System.out.println("enum one");
		}
	},
	TWO {
		@Override
		void action() {
			System.out.println("enum two");
		}
	},
	THREE {
		@Override
		void action() {
			System.out.println("enum three");
		}
	};

	abstract void action();

}
