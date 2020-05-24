package in.recursion;

public class PrintTable {

	public static void main(String args[]) {

		PrintTable pt = new PrintTable();
		// pt.printTable(2, 20, 1);
		pt.printTableRec(2, 20, 0);
	}

	public void printTable(int table, int end, int start) {
		for (; start <= end; start++) {
			System.out.println(table + " * " + start + " = " + table * start);
		}
	}

	public void printTableRec(int table, int end, int start) {
		if (start > end) {
			return;
		}
		System.out.println(table + " * " + start + " = " + table * start);
		start = start + 1;
		printTableRec(table, end, start);
	}

}
