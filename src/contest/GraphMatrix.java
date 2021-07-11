package contest;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class GraphMatrix {

	public static void main(String[] args) throws IOException {

		int BEGIN = 50000;
		int cost = 1000;
		try (Writer wr = new FileWriter("c:\\dev\\inputflie_1.txt")) {
			wr.write(BEGIN + " " + BEGIN + "\n");
			int count = 0;
			for (int i = 25011; i <= BEGIN; i++) {
				cost = (i % 2 == 0) ? 10 : 5;
				for (int j = i + 1; j <= (i + 10); j++) {
					wr.write(i + " " + j + " " + cost * j + "\n");
					count++;
					if (count > 500000)
						break;
				}
				if (count > 500000)
					break;
			}
		}
	}
}
