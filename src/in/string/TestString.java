package in.string;

public class TestString {

	public static void main(String[] args) {
		String s= "Delhi";
		s = s.toUpperCase();
		int fci = 0;
		int lci = s.length()-1;
		System.out.println(s);
		System.out.println("First Character "+ s.charAt(fci));
		System.out.println("Last Character "+s.charAt(lci));
		
	}

}
