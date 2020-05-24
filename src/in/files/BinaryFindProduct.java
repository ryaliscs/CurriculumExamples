package in.files;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BinaryFindProduct {

	/**
	 * find the given product if found prints the given product else if print
	 * product not found
	 * 
	 * @param p
	 */
	public void findPro(String p) throws IOException {
		FileInputStream fis = new FileInputStream("c:\\temp\\product.dat");
		DataInputStream dis = new DataInputStream(fis);
		boolean productFound = false;

		// reading the file
		while (dis.available() > 0) {
			String pcode = dis.readUTF();
			int pquantity = dis.readInt();
			double pprice = dis.readDouble();
			if (pcode.equals(p)) {
				System.out.println(p + " is available");
				System.out.println("Quantity - " + pquantity);
				System.out.println("Price - " + pprice);
				productFound = true;
				break;
			}
		}

		if (!productFound) {
			System.out.println(p + " not available");
		}

		dis.close();
		fis.close();
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the product code:");
		String pcode = sc.next();
		BinaryFindProduct bfp = new BinaryFindProduct();
		bfp.findPro(pcode);
	}
}
