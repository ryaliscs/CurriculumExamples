package contest;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class GraphMatrix {

	public static void main(String[] args) throws IOException {

		int BEGIN = 50000;
		int cost = 10;
		try (Writer wr = new FileWriter("c:\\dev\\inputflie.txt")) {
			wr.write(BEGIN + " " + BEGIN + "\n");

			for (int i = 1; i <= BEGIN; i++) {
				cost = (i % 2 == 0) ? 10 : 5;
//				System.out.println(i);
				for (int j = i + 1; j <= (i+10); j++) {
					 wr.write(i + " " + j + " " + cost + "\n");
//					System.out.println(i + " " + j + " " + cost + "\n");
				}
			}
		}
	}
}
