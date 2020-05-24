package in.files;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Example to write a Binary File
 * 
 * fileName:product.dat
 * file information to store
 * product code
 * product quantity
 * product price 
 * 
 */
public class BinaryWrite {

	/**
	 * Always throw exception related to file streams
	 * 
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		String pcode;
		int pquantity;
		double pprice;
		int psize;
		Scanner sc = new Scanner(System.in);
		FileOutputStream fos = new FileOutputStream("c:\\temp\\product.dat");
		DataOutputStream dos = new DataOutputStream(fos);

		System.out.println("Enter no. of products");
		psize = sc.nextInt();
		for (int i = 0; i < psize; i++) {
			System.out.println("Enter product code:");
			pcode = sc.next();
			System.out.println("Enter product quantity:");
			pquantity = sc.nextInt();
			System.out.println("Enter product price:");
			pprice = sc.nextDouble();

			dos.writeUTF(pcode);
			dos.writeInt(pquantity);
			dos.writeDouble(pprice);
		}

		dos.close();
		fos.close();
		sc.close();
	}

}
