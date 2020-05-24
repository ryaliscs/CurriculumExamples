package in.files;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BinaryRead {

	public static void main(String[] args) throws IOException {
		String pcode;
		int pquantity;
		double pprice;
		FileInputStream fis = new FileInputStream("c:\\temp\\product.dat");
		DataInputStream dis = new DataInputStream(fis);
		while(dis.available()>0)
		{
			pcode = dis.readUTF();
			pquantity = dis.readInt();
			pprice = dis.readDouble();
			
			System.out.println("Code:"+pcode);
			System.out.println("Quantity:"+pquantity);
			System.out.println("Price:"+pprice);
		}
		
		dis.close();
		fis.close();
	}
}
