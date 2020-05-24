package in.string;

public class StringReplace {

	public static void main(String args[]) {
		String a = "India";
		System.out.println(a);
		String newString = "";
		for (int i = 0; i < a.length(); i++) {
			char charAt = a.charAt(i);
			if (charAt == 'a' || charAt == 'A' || //
					charAt == 'e' || charAt == 'E' || //
					charAt == 'i' || charAt == 'I' || //
					charAt == 'o' || charAt == 'O' || //
					charAt == 'u' || charAt == 'u') {
				char newChar = (char) (charAt + 1);

				newString = newString + newChar;
			} else {
				newString = newString + charAt;
			}
		}

		System.out.println(newString);
	}

}
