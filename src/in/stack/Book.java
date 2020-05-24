package in.stack;

public class Book {
	String Name[];
	int point;
	int max;

	Book(int cap) {
		max = cap;
		point = -1;
		Name = new String[cap];
	}

	void tell() {
		String k;
		if (point == -1) {
			System.out.println("Shelf Empty");

		} else {
			k = Name[point];
			point--;
			System.out.print(k);
		}
	}

	void add(String v) {
		if (point == (max - 1)) {
			System.out.println("Shelf Full");
		} else {
			point++;
			Name[point] = v;
		}
	}

	void display() {
		System.out.println("\n---------------");
		for (int i = point; i > -1; i--)
			System.out.println(Name[i]);
		System.out.println("---------------");
	}
	
	public static void main(String[] args) {
		Book book = new Book(5);
		book.add("book1");
		book.add("book2");
		book.display();
		book.tell();
		book.add("book3");
		book.display();
	}
}
